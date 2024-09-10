package com.yash.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.question_service.controller.model.QuestionWrapper;
import com.yash.question_service.controller.model.Response;
import com.yash.question_service.controller.model.question;
import com.yash.question_service.controller.service.questionService;

@RestController
@RequestMapping("question")
public class QuizControlller 
{
	
	@Autowired
	questionService qs;
	
	@GetMapping("allQuestions")
	public ResponseEntity< List<question>> getAllQuestions()
	{
		return qs.getAllQuestions();
	}
	
	@GetMapping("allQuestions/{level}")
	public ResponseEntity< List<question>>levelQuestion(@PathVariable String level)
	{
		return qs.levelQuestion(level);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity< String> addQuestion(@RequestBody question p)
	{
		return qs.addQuestion(p);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String level, @RequestParam int num)
	{
		return qs.generate(level,num);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> qID)
	{
		return qs.getQuestions(qID);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody  List<Response> responses)
	{
		return qs.getScore(responses);
	}

}