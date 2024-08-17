package com.example.quizapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.Dao.QuestionDao;
import com.example.quizapp.Entity.Question;
import com.example.quizapp.Entity.QuizQuestion;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try
		{
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public String addQuestion(Question question) {
		
		questionDao.save(question);
		return "success";
	}

	public List<Question> getQuestionsByCategory(String level) {
		
		return questionDao.findByDifficultyLevel(level);
	}

	public String deleteQuestion(Long id) {
		Long questionId = id;
		questionDao.deleteById(id);
		return questionId+" deleted";
	}

	public String updateQuestion(Question question, Long id) {
		
		 Question q = questionDao.findById(id).orElseThrow(() -> new RuntimeException("Questions not found"));
		 q.setQuestionTitle(question.getQuestionTitle());
		 q.setOption1(question.getOption1());
		 q.setOption2(question.getOption2());
		 q.setOption3(question.getOption3());
		 q.setOption4(question.getOption4());
		 q.setRightAnswer(question.getRightAnswer());
		 q.setDifficultyLevel(question.getDifficultyLevel());
		 questionDao.save(q);
		 return "updated";
	}

}
