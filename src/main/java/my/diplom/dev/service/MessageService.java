package my.diplom.dev.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import my.diplom.dev.dto.MessageDto;
import my.diplom.dev.dto.entity.Group;
import my.diplom.dev.service.builder.VkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {
	private static final String SIGNS = "\".,/@'!;:_=%#№`~";

	@Setter(onMethod = @__(@Autowired))
	private VkBuilder vkBuilder;

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

		return "";
	}
}
