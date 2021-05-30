package my.diplom.dev.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Setter;
import my.diplom.dev.dto.MessageDto;
import my.diplom.dev.dto.entity.Group;
import my.diplom.dev.dto.mongo.Dictionary;
import my.diplom.dev.repo.DictionaryRepo;
import my.diplom.dev.service.helper.Combinations;
import my.diplom.dev.service.helper.Levenshtain;
import my.diplom.dev.service.helper.PorterStemmer;
import my.diplom.dev.service.helper.VkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {
	private static final String SIGNS = "\".,/@'!;:_=%#№`~";
	@Value("${R}")
	private Double R;

	@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
	private VkBuilder vkBuilder;
	@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
	private DictionaryRepo dictionaryRepo;

	public void sendAnswer(JsonNode json, Group group) {
		MessageDto message = new MessageDto();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			message = objectMapper.convertValue(json, message.getClass());

			String url = vkBuilder.buildResponseMessage(message.getFromId().toString(), this.getAnswer(message.getText()), group);

			RestTemplate rest = new RestTemplate();
			rest.getForObject(url, Object.class);
		} catch(Exception ignored) {

		}
	}

	private String getAnswer(String text) {
		text = text.replaceAll(SIGNS, "");
		List<String> words = Arrays.asList(text.split(" "));
		words = orthography(words);


		return words.toString();
	}

	private List<String> orthography(List<String> words) {
		List<String> result = new ArrayList<>();
		for(String word : words) {
			// есть ли стово в словаре (фактически в нормированной версии и без ошибок)
			if(!dictionaryRepo.existsByWord(word)) {
				// приводим к нормировке (отбрасываем приставки и тд)
				word = PorterStemmer.stem(word);
				String res = word;
				int lev = -1;
				// разделили слово на куски по предполагаемым ошибкам
				for(List<String> piece : ngramWord(word)) {
					// ищем слова с вхождениями кусочками
					for(Dictionary w : dictionaryRepo.findAllByWordIsContaining(piece)) {
						// находим минимального левенштейна
						if(lev == -1) {
							res = w.getWord();
							lev = Levenshtain.count(res, word);
						} else {
							int tmplev = Levenshtain.count(word, w.getWord());
							if (lev > tmplev) {
								res = w.getWord();
								lev = tmplev;
							}
						}
					}
				}
				result.add(res);
			} else {
				result.add(word);
			}
		}
		return result;
	}

	private List<List<String>> ngramWord(String word) {
		List<List<String>> result = new ArrayList<>();
		char[] wordChar = word.toCharArray();
		int n = ((int) Math.ceil(wordChar.length * R));

		List<List<Integer>> combinations = Combinations.generateCombinations(0, word.length() - 1, n);

		for(List<Integer> nums : combinations) {
			List<String> ngram = new ArrayList<>();
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < wordChar.length; i++) {
				if(!nums.contains(i)) {
					builder.append(wordChar[i]);
				} else {
					ngram.add(builder.toString());
					builder = new StringBuilder();
				}
			}
			result.add(ngram);
		}
		return result;
	}

}
