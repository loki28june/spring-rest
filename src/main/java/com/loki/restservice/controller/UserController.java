package com.loki.restservice.controller;

import java.util.List;

import com.loki.restservice.entity.Post;
import com.loki.restservice.entity.User;
import com.loki.restservice.exception.NoUsersFoundException;
import com.loki.restservice.exception.UserCanNotCreateException;
import com.loki.restservice.exception.UserNotFoundException;
import com.loki.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> findAll(){
		List<User> users= (List<User>) userService.findAll();
		if(null == users || users.size() == 0){
			throw new NoUsersFoundException("No users Found in Application");
		}
		return users;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody User user){
		try {
			userService.create(user);
		}
		catch (Exception e){
			throw new UserCanNotCreateException("User can not be created");
		}
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable("id")  Integer id){
		User user = userService.findById(id);
		if(null == user){
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@PathVariable("id") Integer id,@RequestBody User user){
		userService.update(id,user);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id){
		userService.deleteById(id);
	}

	@GetMapping(value = "{id}/posts")
	public List<Post> fetchAllUserPosts(@PathVariable("id") Integer id){
		User user = userService.findById(id);
		return user.getPosts();
	}

	@PostMapping(value = "{id}/posts")
	public ResponseEntity<Post> create(@PathVariable("id") Integer id ,@RequestBody Post post){
			User user = userService.findById(id);
			post.setUser(user);
			userService.createPost(post);
			return new ResponseEntity<>(post,HttpStatus.CREATED);
	}
}
