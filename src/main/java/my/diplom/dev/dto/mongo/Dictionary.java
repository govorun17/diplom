package my.diplom.dev.dto.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "dictionary")
public class Dictionary {
	@Id
	private String id;

	@Indexed(unique = true)
	@Field
	private String word;

	@Field
	private List<String> tags;

}
