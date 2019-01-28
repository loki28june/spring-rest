package com.loki.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.loki.entity.User;
import com.loki.repository.UserRepository;
import com.loki.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createUsers() {
		userService.addUsers();
		return "created";
	}

	@PostMapping("/createUsers")
	@ResponseStatus(HttpStatus.CREATED)
	public String createUsers(@RequestBody List<User> users) {
		userService.addUsers(users);
		return "created";
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) {

		Optional<User> userInDb = userRepo.findById(id);
		if (!userInDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		user.setId(id);
		userRepo.save(user);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

}
