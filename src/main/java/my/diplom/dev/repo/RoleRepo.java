package my.diplom.dev.repo;

import my.diplom.dev.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
