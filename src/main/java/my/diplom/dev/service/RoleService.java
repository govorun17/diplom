package my.diplom.dev.service;

import my.diplom.dev.entity.Role;
import my.diplom.dev.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	private RoleRepo roleRepo;

	@Autowired
	private void setAutowired(
			RoleRepo roleRepo
	) {
		this.roleRepo = roleRepo;
	}

	public void saveIfNotExists(Role role) {
		if(roleRepo.findByName(role.getName()) == null) {
			roleRepo.save(role);
		}
	}
}
