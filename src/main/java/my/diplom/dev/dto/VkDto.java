package my.diplom.dev.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class VkDto {
	@Value("${API_VERSION}")
	private String apiVersion;
}
