package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.SessionUser;
import com.example.demo.dto.UserForm;
import com.example.demo.service.AuthService;
import com.example.demo.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/")
public class AuthController {
	@Autowired
	AuthService authService;
	
	@Autowired
	SessionUser sessionUser;

	@Autowired
	CartService cartService;
	
	@PostMapping("login")
	public String AuthUser(@ModelAttribute("userForm") UserForm userForm,Model model) {

		System.out.println(model);
		int resultUserId = authService.checkUser(userForm);
		
		if(resultUserId != 0) {
			sessionUser.setUserSession(true);
			sessionUser.setUser_id(resultUserId);
			return "redirect:/";
		}
		model.addAttribute("error", "メールアドレスまたは、パスワードが間違っています");
		return "login";
	}
	
	@GetMapping("logout")
	public String Logout(UserForm userForm,Model model) {

		sessionUser.reset();
		
		return "redirect:/";
	}

	@RequestMapping(value = "/checkuser", method = {RequestMethod.GET })
    public @ResponseBody String CheckUser() {
		
		if (sessionUser.isUserSession()) {
			int totalcount = cartService.countCart(sessionUser.getUser_id());
			return String.valueOf(totalcount);
		}
		return null;
	}

}
