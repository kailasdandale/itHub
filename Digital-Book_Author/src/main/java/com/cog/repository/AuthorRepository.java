package com.cog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.model.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	Author findByAuthorNameAndPassword(String authorName, String password);

	Author findByUsername(String username);

}
