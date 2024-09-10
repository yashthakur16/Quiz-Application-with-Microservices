package com.yash.quiz_service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.quiz_service.Dao.Quizdao;
import com.yash.quiz_service.feign.QuizInterface;
import com.yash.quiz_service.model.QuestionWrapper;
import com.yash.quiz_service.model.Quiz;
import com.yash.quiz_service.model.Response;
import com.yash.quiz_service.model.question;
import com.yash.quiz_service.model.quizDto;

@Service
public class QuizService 
{
	@Autowired
	Quizdao quizdao;
	
	@Autowired
	QuizInterface qI;
	


	public ResponseEntity<List<QuestionWrapper>> get(int id) {
		Optional<Quiz> quiz=quizdao.findById(id);
		List<Integer> qIds=quiz.get().getQuestionsIds();
		
		ResponseEntity<List<QuestionWrapper>> questions=qI.getQuestions(qIds);
		return questions;
	}
	
	public ResponseEntity<Integer> result(int id, List<Response> responses)
	{
		return qI.getScore(responses);
	}

	public ResponseEntity<String> create(quizDto dto) {
	
		List<Integer> questions=qI.generateQuestions(dto.getLevel(), dto.getNum()).getBody();
		Quiz q=new Quiz();
		q.setTitle(dto.getTitle());
		q.setQuestionsIds(questions);
		quizdao.save(q);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}
	
	

	
}
