package com.yash.quiz_service.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.quiz_service.model.Quiz;
import com.yash.quiz_service.model.question;



@Repository
public interface Quizdao extends JpaRepository<Quiz, Integer>{

	@Query(value = "SELECT id FROM question WHERE difficulty_level=:level ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
	List<question> getRandom(String level, int num);

}
