package my.diplom.dev.service.importer;

import lombok.Setter;
import my.diplom.dev.dto.entity.Role;
import my.diplom.dev.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod = @__(@Autowired))
public class RoleImport {
	private RoleService roleService;

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
