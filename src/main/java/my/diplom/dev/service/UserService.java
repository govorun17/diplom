package my.diplom.dev.service;

import lombok.AccessLevel;
import lombok.Setter;
import my.diplom.dev.dto.entity.User;
import my.diplom.dev.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class UserService {
	private UserRepo userRepo;

	public void save(User user) {
		userRepo.save(user);
	}

	public void saveIfNotExists(User user) {
		if (!userRepo.existsByUsername(user.getUsername())) {
			userRepo.save(user);
		}
	}

	public Boolean isUserExistsByUsername(String s) {
		return userRepo.existsByUsername(s);
	}

	public User findUserByUsername(String s) {
		return userRepo.findByUsername(s);
	}
}
