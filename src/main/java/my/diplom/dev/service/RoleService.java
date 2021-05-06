package my.diplom.dev.service;

import lombok.AccessLevel;
import lombok.Setter;
import my.diplom.dev.dto.entity.Role;
import my.diplom.dev.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	public static final String USER = "USER";
	public static final String ADMIN = "ADMIN";
	public static final String MODERATOR = "MODERATOR";

	@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
	private RoleRepo roleRepo;

	public void saveIfNotExists(Role role) {
		if(roleRepo.findByName(role.getName()) == null) {
			roleRepo.save(role);
		}
	}

	public Role findByName(String name) {
		return roleRepo.findByName(name);
	}
}
