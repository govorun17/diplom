package my.diplom.dev.service.importer;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.diplom.dev.dto.entity.Role;
import my.diplom.dev.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class RoleImport {

	private RoleService roleService;

	@Order(0)
	@EventListener(ApplicationReadyEvent.class)
	public void importRoles() {
		Role role = new Role();
		role.setName(RoleService.USER);
		roleService.saveIfNotExists(role);

		role = new Role();
		role.setName(RoleService.ADMIN);
		roleService.saveIfNotExists(role);

		role = new Role();
		role.setName(RoleService.MODERATOR);
		roleService.saveIfNotExists(role);

		log.info("Импорт ролей завершен");
	}
}
