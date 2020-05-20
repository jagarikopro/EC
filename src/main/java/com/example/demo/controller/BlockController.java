package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.config.SessionUser;
import com.example.demo.dto.ProductForm;
import com.example.demo.dto.UserForm;

@Controller
@RequestMapping("/")
@SessionAttributes(types = { UserForm.class })
public class BlockController {
	
	@Autowired
	SessionUser sessionUser;

    @GetMapping
    public String home(ProductForm productForm, Model model) {
        return "home";
    }
	
	@GetMapping("/login")
    public String login(UserForm userForm, ProductForm productForm, Model model){
        return "login";
    }

    //カリで作成以下二つ
    @GetMapping("/index")
    public String test2(@ModelAttribute("userForm") UserForm userForm,Model model) {
    	if(sessionUser.isUserSession()) {
    		System.out.println("セッションアリ！");	
    	}
    	
        return "index";
    }
    

    @ModelAttribute("/userForm")
    public UserForm setUpUserForm() {
        return new UserForm();
    }

}
