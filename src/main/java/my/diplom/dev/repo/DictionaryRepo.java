package my.diplom.dev.repo;

import my.diplom.dev.dto.mongo.Dictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DictionaryRepo extends MongoRepository<Dictionary, Long> {

	boolean existsByWord(String word);
}
