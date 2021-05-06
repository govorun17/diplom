package my.diplom.dev.repo;

import my.diplom.dev.dto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

	Boolean existsByUsername(String username);
}
