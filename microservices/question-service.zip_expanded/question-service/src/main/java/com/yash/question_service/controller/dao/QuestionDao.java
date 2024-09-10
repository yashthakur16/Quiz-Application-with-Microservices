package com.yash.question_service.controller.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.question_service.controller.model.question;



@Repository
public interface QuestionDao extends JpaRepository<question, Integer> {

    List<question> findBydifficultyLevel(String level);

    @Query(value = "SELECT id FROM question WHERE difficulty_level=:level ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> getRandom(String level, int numQ);

}
