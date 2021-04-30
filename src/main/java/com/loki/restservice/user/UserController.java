package com.loki.restservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	private UserService userService;
	private UserRepository userRepository;

	@Autowired
	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@GetMapping
	public List<User> findAll(){
		return (List<User>) userService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findById(@PathVariable("id") Long id){
		return userService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody User user){
		userService.create(user);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@PathVariable("id") Long id,@RequestBody User user){
		userService.update(id,user);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") Long id){
		userService.deleteById(id);
	}
}
