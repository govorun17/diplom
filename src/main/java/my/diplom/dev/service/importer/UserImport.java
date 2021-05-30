package my.diplom.dev.service.importer;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.diplom.dev.dto.entity.User;
import my.diplom.dev.service.RoleService;
import my.diplom.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class UserImport {
	private UserService userService;
	private RoleService roleService;
	private PasswordEncoder encoder;

	@Order(1)
	@EventListener(ApplicationReadyEvent.class)
	public void importUser() {
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword(encoder.encode("admin"));
		admin.setActivated(true);
		admin.setRole(roleService.findByName(RoleService.ADMIN));
		userService.saveIfNotExists(admin);
		log.info("Пользователь Администратор создан");
	}
}
