package my.diplom.dev.service;

import lombok.Setter;
import my.diplom.dev.dto.entity.Role;
import my.diplom.dev.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod = @__(@Autowired))
public class RoleService {
	private RoleRepo roleRepo;

	public void saveIfNotExists(Role role) {
		if(roleRepo.findByName(role.getName()) == null) {
			roleRepo.save(role);
		}
	}
}
