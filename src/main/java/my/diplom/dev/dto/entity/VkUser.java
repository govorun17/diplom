package my.diplom.dev.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.diplom.dev.dto.Modes;

import javax.persistence.*;

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

	@Column(unique = true, nullable = false)
	private String vkId;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Modes mode;

	public static VkUser newUser(String vkId) {
		return new VkUser(
				null,
				vkId,
				Modes.DEFAULT
		);
	}
}
