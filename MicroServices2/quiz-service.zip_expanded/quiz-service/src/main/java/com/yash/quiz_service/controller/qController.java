package com.yash.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.quiz_service.Service.QuizService;
import com.yash.quiz_service.model.QuestionWrapper;
import com.yash.quiz_service.model.Response;
import com.yash.quiz_service.model.quizDto;


@RestController
@RequestMapping("quiz")
public class qController 
{
	@Autowired
	QuizService qs;
	
	@PostMapping("create")
	public ResponseEntity<String> create(@RequestBody quizDto dto)
	{
		return qs.create(dto);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> get(@PathVariable int id)
	{
		return qs.get(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submit(@PathVariable int id,@RequestBody  List<Response> responses)
	{
		return qs.result(id,responses);
	}
	
}
