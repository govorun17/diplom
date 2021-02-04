package my.diplom.dev.service;

import my.diplom.dev.entity.Group;
import my.diplom.dev.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
	private GroupRepo groupRepo;

	@Autowired
	private void setAutowired(
			GroupRepo groupRepo
	) {
		this.groupRepo = groupRepo;
	}

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
