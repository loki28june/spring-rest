package com.loki.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	private List<User> users = Arrays.asList(
			new User("Lokesh", "lnmanit@gmail.com"),
			new User("Neeti", "neeti@gmail.com"),
			new User("Nimmi", "nimmi@gmail.com"),
			new User("Kimmi", "kimmi@gmail.com"));

	
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User getUser(String id) {
		return userRepo.findById(Long.valueOf(id)).orElse(null);
	}

	public void addUsers() {
		userRepo.saveAll(users);
	}
	
	public void addUser(User user) {
		userRepo.save(user);
	}

	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}

}
