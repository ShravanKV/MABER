package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.verifyrequest;
import com.example.demo.service.PasswordService;




@RestController
public class ForgotpasswordController {
	@Autowired
	PasswordService passwordservice;
	
	
@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
public ResponseEntity<?> forgotpassword(@RequestBody verifyrequest req) {
		boolean result = this.passwordservice.sendEmail(req.getEmail());
		if(result) {
		System.out.println(req);
		return ResponseEntity.ok("Email Sent to your email");
		
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent.....");
	}
	

	}



