package com.usercomment.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByText(String text);

	List<User> findBydateofcomment(@Param("date") LocalDate date);
}
