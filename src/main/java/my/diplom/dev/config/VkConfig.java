package my.diplom.dev.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class VkConfig {
	@Value("${API_VERSION}")
	private String apiVersion;
	@Value("${GROUP_ID}")
	private Long groupId;
	@Value("${ACCESS_TOKEN}")
	private String token;
	@Value("${RESPONSE_KEY}")
	private String responseKey;
}
