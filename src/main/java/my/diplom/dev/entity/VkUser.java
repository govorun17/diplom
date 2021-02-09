package my.diplom.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "vk_users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VkUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany
	private List<Message> request;

	@OneToMany
	private List<Message> response;
}
