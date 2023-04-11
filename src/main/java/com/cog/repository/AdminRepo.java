package com.cog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.model.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	Admin findByUsername(String username);

}
