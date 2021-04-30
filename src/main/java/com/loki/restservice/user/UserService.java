package com.loki.restservice.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    private List<User> users = Arrays.asList(
            new User("Lokesh", "lnmanit@gmail.com"),
            new User("Neeti", "neeti@gmail.com"),
            new User("Nimmi", "nimmi@gmail.com"),
            new User("Kimmi", "kimmi@gmail.com"));

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public void update(Long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(updatedUser.getEmail());
            user.setName(updatedUser.getName());
            userRepository.save(user);
            return;
        }
        throw new RuntimeException("User entity update failed");
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
