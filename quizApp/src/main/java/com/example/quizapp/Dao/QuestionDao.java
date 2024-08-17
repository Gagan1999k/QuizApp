package com.example.quizapp.Dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapp.Entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {

	List<Question> findByDifficultyLevel(String level);

	
	@Query(value="SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

	
}
