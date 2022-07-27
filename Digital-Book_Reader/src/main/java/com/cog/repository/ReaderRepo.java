package com.cog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cog.model.Reader;

@Repository
public interface ReaderRepo extends JpaRepository<Reader, Integer>{

	Reader findByReaderId(int readerId);

}
