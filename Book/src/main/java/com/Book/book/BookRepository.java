package com.Book.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String title);

	// Custom query
	@Query("SELECT b FROM Book b WHERE b.publishDate > :date")
	List<Book> findByPublishedDateAfter(@Param("date") LocalDate date);
}
