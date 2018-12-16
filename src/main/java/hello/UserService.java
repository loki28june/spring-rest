package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void addUsers() {
		List<User> users = new ArrayList<User>();
		
		AtomicLong key = new AtomicLong();
		users.add(new User(key.incrementAndGet(), "Lokesh", "lnmanit@gmail.com"));
		users.add(new User(key.incrementAndGet(), "Neeti", "neeti@gmail.com"));
		users.add(new User(key.incrementAndGet(), "Nimmi", "nimmi@gmail.com"));
		users.add(new User(key.incrementAndGet(), "Kimmi", "kimmi@gmail.com"));
		userRepo.saveAll(users);
	}
	
	public void addUsers(List<User> users) {
		userRepo.saveAll(users);
	}
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}

}
