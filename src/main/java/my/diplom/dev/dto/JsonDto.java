package my.diplom.dev.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class JsonDto {
	public String type;
	@JsonProperty("group_id")
	public Long groupId;
	private String secret;
	@JsonProperty("object")
	private JsonNode json;
}
