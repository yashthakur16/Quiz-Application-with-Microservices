package com.yash.question_service.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.question_service.controller.dao.QuestionDao;
import com.yash.question_service.controller.model.QuestionWrapper;
import com.yash.question_service.controller.model.Response;
import com.yash.question_service.controller.model.question;


@Service
public class questionService {

	@Autowired
	QuestionDao dao;
	
	@Autowired
	Environment e;
	
	public ResponseEntity< List<question>> getAllQuestions() 
	{
		try
		{
			return new ResponseEntity<>(dao.findAll(),HttpStatus.OK) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
		
	}


	public ResponseEntity< List<question>> levelQuestion(String level) {
		try
		{
			return new ResponseEntity<> (dao.findBydifficultyLevel(level),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
		
	}


	public ResponseEntity<String> addQuestion(question p) {
		dao.save(p);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}


	public ResponseEntity<List<Integer>> generate(String level, int num) {
		List<Integer> questions=dao.getRandom(level, num);
		return new ResponseEntity<List<Integer>>(questions, HttpStatus.OK);
		
	}


	public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> qID) {
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<question> questions=new ArrayList<>();
		System.out.println(e.getProperty("local.server.port"));
		
		for (int id : qID) 
		{
			questions.add(dao.findById(id).get());
		}
		
		for (question question : questions) 
		{
			QuestionWrapper wrapper=new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
			wrappers.add(wrapper);
		}
		
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}


	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		int right=0;
		for (Response r : responses) 
		{
			question questions=dao.findById(r.getId()).get();
			if(r.getAnswer().equals(questions.getRightAnswer()))
			{
				right++;
			}
			
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
