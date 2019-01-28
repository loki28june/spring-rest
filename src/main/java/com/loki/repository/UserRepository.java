package com.loki.repository;

import org.springframework.data.repository.CrudRepository;

import com.loki.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
