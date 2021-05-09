package com.loki.restservice.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.loki.restservice.entity.Post;
import com.loki.restservice.entity.User;
import com.loki.restservice.exception.UserNotFoundException;
import com.loki.restservice.repository.PostRepository;
import com.loki.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class UserService {
    public static final String SYSTEM = "SYSTEM";
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public UserService(UserRepository userRepo, PostRepository postRepository) {
        this.userRepository = userRepo;
        this.postRepository = postRepository;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> userOptional= userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("User not found exception");
        }
        return userOptional.get();
    }

    public void create(User user) {
        user.setCreatedBy(SYSTEM);
        user.setModifiedBy(SYSTEM);
        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        userRepository.save(user);
    }

    public void update(Integer id, User updatedUser) {
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

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public void createPost(Post post) {
        post.setCreatedDate(LocalDateTime.now());
        post.setModifiedDate(LocalDateTime.now());
        postRepository.save(post);
    }
}
