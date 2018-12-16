package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

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

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}

}
