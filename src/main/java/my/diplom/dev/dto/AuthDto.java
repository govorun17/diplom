package my.diplom.dev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
	private String name;
	private String surname;
	private String username;
	private String password;
	private String passwordRepeat;
}
