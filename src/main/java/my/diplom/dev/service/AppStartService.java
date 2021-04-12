package my.diplom.dev.service;

import my.diplom.dev.dto.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AppStartService {
	RoleService roleService;

	@Autowired
	private void setAutowired(
			RoleService roleService
	) {
		this.roleService = roleService;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void validateRoles() {
		Role role = new Role();
		role.setName("USER");
		roleService.saveIfNotExists(role);

		role = new Role();
		role.setName("ADMIN");
		roleService.saveIfNotExists(role);

		role = new Role();
		role.setName("MODERATOR");
		roleService.saveIfNotExists(role);
	}
}
