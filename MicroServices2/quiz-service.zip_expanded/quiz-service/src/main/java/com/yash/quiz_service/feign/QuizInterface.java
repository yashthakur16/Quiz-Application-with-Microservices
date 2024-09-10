package com.yash.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.quiz_service.model.QuestionWrapper;
import com.yash.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface 
{
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String level, @RequestParam int num);
	
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> qID);
	
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody  List<Response> responses);
	
}
