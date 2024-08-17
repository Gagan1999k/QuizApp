package com.example.quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.quizapp.Entity.Question;
import com.example.quizapp.Entity.QuizQuestion;
import com.example.quizapp.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();	
	}
	
	@GetMapping("/level/{level}")
	public List<Question> getQuestionsByCategory(@PathVariable String level)
	{
		return questionService.getQuestionsByCategory(level);	
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody Question question)
	{
		return questionService.addQuestion(question);
		
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable Long id)
	{
		return questionService.deleteQuestion(id);
	}
	
	@PutMapping("/updateQuestion/{id}")
	public String updateQuestion(@RequestBody Question question, @PathVariable Long id)
	{
		return questionService.updateQuestion(question,id);
	}
	

}
