package my.diplom.dev.repo;

import my.diplom.dev.dto.mongo.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DictionaryRepo extends MongoRepository<Dictionary, Long> {

	Page<Dictionary> findByWordIsContaining(String word, Pageable pageable);

	boolean existsByWord(String word);

	boolean existsByWordIsLike(String word);

	List<Dictionary> findAllByWordIsContaining(List<String> word);
}
