package my.diplom.dev.service.importer;

import lombok.Setter;
import my.diplom.dev.dto.mongo.Dictionary;
import my.diplom.dev.repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class DictionaryImport {
	@Value("${import.file.path}")
	private String path;

	@Setter(onMethod = @__(@Autowired))
	private DictionaryRepo dictionaryRepo;

	@Order(0)
	@EventListener(ApplicationReadyEvent.class)
	public void importDictionaryFromFile() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
			for(String line : reader.lines().collect(Collectors.toList())) {
				if(!dictionaryRepo.existsByWord(line)) {
					Dictionary dictionary = new Dictionary();
					dictionary.setWord(line);
					dictionaryRepo.insert(dictionary);
				}
			}
			System.out.println("Завершен импорт словаря");
		} catch(Exception e) {
			System.out.println("Файл не найден");
			e.printStackTrace();
		}
	}

}
