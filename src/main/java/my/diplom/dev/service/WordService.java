package my.diplom.dev.service;

import lombok.AccessLevel;
import lombok.Setter;
import my.diplom.dev.dto.mongo.Dictionary;
import my.diplom.dev.repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class WordService {
	private DictionaryRepo dictionaryRepo;

	public Page<Dictionary> findWordsLikePaginated(String word, Integer page, Integer limit) {
		Pageable pageable = PageRequest.of(page, limit, Sort.by("word").ascending());
		return dictionaryRepo.findByWordIsContaining(word, pageable);
	}

	public List<Dictionary> findAll() {
		return dictionaryRepo.findAll();
	}
}
