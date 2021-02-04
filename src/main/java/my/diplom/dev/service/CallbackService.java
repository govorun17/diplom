package my.diplom.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallbackService {
	private GroupService groupService;

	@Autowired
	private void setAutowired(
			GroupService groupService
	) {
		this.groupService = groupService;
	}

}
