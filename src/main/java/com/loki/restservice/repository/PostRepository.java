package com.loki.restservice.repository;

import com.loki.restservice.entity.Post;
import com.loki.restservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
