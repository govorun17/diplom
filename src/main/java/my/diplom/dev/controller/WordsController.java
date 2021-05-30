package my.diplom.dev.controller;

import lombok.AccessLevel;
import lombok.Setter;
import my.diplom.dev.dto.mongo.Dictionary;
import my.diplom.dev.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/words")
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class WordsController {

	private WordService wordService;

	@GetMapping("/")
	public ModelAndView wordsListGet(
			String word,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			Map<String, Object> model
	) {
		return wordsListPost(word, page, model);
	}

	@PostMapping("/")
	public ModelAndView wordsListPost(
			String word,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			Map<String, Object> model
	) {
		if(word == null) {
			word = "";
		}

		Page<Dictionary> wordsPages = wordService.findWordsLikePaginated(word, page - 1, 10);
		int pages = wordsPages.getTotalPages();
		if(pages > 1) {
			if(page == 1) {
				model.put("next", "?page=2" + "&word=" + word);
			}
			else if(page == pages) {
				model.put("prev", "?page=" + (page - 1) + "&word=" + word);
			}
			else if(page > 1) {
				model.put("next", "?page=" + (page + 1) + "&word=" + word);
				model.put("prev", "?page=" + (page - 1) + "&word=" + word);
			}
		}
		List<String> words = wordsPages.stream().map(Dictionary::getWord).collect(Collectors.toList());

		model.put("list", words);
		model.put("value", word);
		return new ModelAndView("words", model, HttpStatus.OK);
	}
}
