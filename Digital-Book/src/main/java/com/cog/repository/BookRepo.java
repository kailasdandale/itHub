package com.cog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cog.model.Books;
@Repository
public interface BookRepo extends JpaRepository<Books, Integer>{

	Books findByBookId(int bookId);

	@Query("SELECT b FROM Books b WHERE "+
	"b.bookName LIKE CONCAT('%',:query, '%')"+
	"Or b.bookPrice LIKE CONCAT('%',:query, '%')"+
	"Or b.publishar LIKE CONCAT('%',:query, '%')"+
	"Or b.authorName LIKE CONCAT('%',:query, '%')"+
	"Or b.bookId LIKE CONCAT('%',:query, '%')")
	List<Books> search(String query);



}
