package my.diplom.dev.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group_vk")
public class Group {
	@Id
	@JsonProperty(value = "group_id")
	private Long groupId;
	private String code;
	private String secret;
	private String token;
}
