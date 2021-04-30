package my.diplom.dev.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonDto {
	private String type;
	@JsonProperty("group_id")
	private Long groupId;
	private String secret;
	@JsonProperty("object")
	private JsonNode json;
}
