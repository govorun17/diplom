package my.diplom.dev.service.builder;

import my.diplom.dev.dto.entity.Group;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class VkBuilder {
	@Value("${API_VERSION}")
	private String apiVersion;

	@Value("${PREFIX_URL}")
	private String prefixUrl;

	@Value("${SEND_MESSAGES}")
	private String sendMessageSuffixUrl;

	private String getPostfix(String token) {
		return token + "&v=" + apiVersion;
	}

	public String buildResponseMessage(String userId, String message, Group group) {
		return prefixUrl + sendMessageSuffixUrl
				+ "user_id=" + userId
				+ "&message=" + message
				+ "&random_id=" + ThreadLocalRandom.current().nextLong()
				+ "&" + getPostfix(group.getToken());
	}
}
