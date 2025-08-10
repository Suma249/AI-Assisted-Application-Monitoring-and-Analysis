package com.spring.learning.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learning.service.GptChatServiceImpl;

@RestController
@RequestMapping("/api/ask-ai")
@CrossOrigin("*")
public class OpenAIController {

	@Autowired
	private GptChatServiceImpl gptChatService;
	
	@GetMapping("/{question}")
	public ResponseEntity<Map<String, String>> getAnswer(@PathVariable String question){
		String response=gptChatService.askQuestionWithContext(question);
		Map<String, String> body = new HashMap<>();
	    body.put("answer", response);
		return ResponseEntity.ok(body);
	}
}
