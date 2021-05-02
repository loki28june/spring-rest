package com.loki.restservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.loki.restservice.entity.User;
import com.loki.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final String SYSTEM = "SYSTEM";
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void create(User user) {
        user.setCreatedBy(SYSTEM);
        user.setModifiedBy(SYSTEM);
        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        userRepository.save(user);
    }

    public void update(Long id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setModifiedBy(SYSTEM);
            user.setModifiedDate(LocalDateTime.now());
            userRepository.save(user);
            return;
        }
        throw new RuntimeException("User entity update failed");
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
