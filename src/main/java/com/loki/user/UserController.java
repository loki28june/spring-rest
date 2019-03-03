package com.loki.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public Iterable<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("created", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) {

		Optional<User> userInDb = userRepository.findById(id);
		if (!userInDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);
		userRepository.save(user);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

	@PostMapping("/users/populate")
	public String createUsers() {
		userService.addUsers();
		return "created";
	}

}
