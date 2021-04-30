package my.diplom.dev.service;

import lombok.Setter;
import my.diplom.dev.dto.entity.Group;
import my.diplom.dev.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter(onMethod = @__(@Autowired))
public class GroupService {
	private GroupRepo groupRepo;

	public Group findById(Long id) {
		return groupRepo.findById(id).orElse(null);
	}

	public Group saveOrUpdate(
			Long id,
			String key,
			String secret,
			String token
	) {
		Group group = groupRepo.findById(id).orElse(null);
		if(group != null) {
			if(key != null && !key.isEmpty()) {
				group.setCode(key);
			}
			if(secret != null && !secret.isEmpty()) {
				group.setSecret(secret);
			}
			if(token != null && !token.isEmpty()) {
				group.setToken(token);
			}
		}
		else {
			group = new Group(id, key, secret, token);
		}
		groupRepo.save(group);
		return group;
	}

	public Boolean validateGroup(Group group, String secret) {
		return group != null && secret.equals(group.getSecret());
	}
}
