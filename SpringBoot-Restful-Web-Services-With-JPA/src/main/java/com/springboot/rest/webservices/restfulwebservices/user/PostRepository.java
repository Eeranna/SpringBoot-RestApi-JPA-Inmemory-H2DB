package com.springboot.rest.webservices.restfulwebservices.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	Optional<User> findById(int id);

	void deleteById(int id);

}
