package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavController {
	@Autowired
    private JavaMailSender emailSender;

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/registration")
	public String registration(){
		return "registration";
	}
	 @GetMapping("/")
	    public String index() {
	        return "index";
	    }

	    @GetMapping("/forgot-password")
	    public String forgotPassword() {
	        return "forgot_password"; // return the name of the HTML file for forgot password
	    }

	@GetMapping("/newsong")
	public String newsong() {
		return "newsong";
	}
	 @PostMapping("/reset-password")
	    public String resetPassword(@RequestParam String email) {
	        // Logic to send password reset instructions to the provided email
	        
	        // Create a SimpleMailMessage object
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Password Reset Request");
	        message.setText("Please click on the following link to reset your password: [reset link]");
	        
	        // Send the email
	        emailSender.send(message);
	        
	        // Redirect back to the password reset success page
	        return "redirect:/password-reset-success";
	    }
	    
	    @GetMapping("/password-reset-success")
	    public String passwordResetSuccess() {
	        return "password_reset_success";
	    }
}