package my.diplom.dev.service;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(value = AccessLevel.PRIVATE, onMethod = @__(@Autowired))
public class CallbackService {
	private GroupService groupService;

}
