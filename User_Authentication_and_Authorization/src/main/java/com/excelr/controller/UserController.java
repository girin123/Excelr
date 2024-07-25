package com.excelr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.Entity.User;
import com.excelr.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User>register(@RequestBody User user){
		return ResponseEntity.ok(userService.registerUser(user));
		
	}
	@PostMapping("/login")
	public ResponseEntity<User>login(@RequestBody Map<String, String>credentials) throws Throwable{
		return ResponseEntity.ok(userService.authenticate(credentials.get("email"),credentials.get("password")));
	}
    
}

