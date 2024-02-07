package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController_chatting {
	// a20_chatting
	// http://localhost:5050/chatting
	@GetMapping("chatting")
	public String chatting() {
		
		
		return "chatting";
	}	
	
}
