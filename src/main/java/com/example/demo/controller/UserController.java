package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dbflute.exentity.User;
import com.example.demo.dto.ProductForm;
import com.example.demo.dto.UserForm;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String index(ProductForm productForm, Model model) {
		List<User>  list = userService.getAll();
		model.addAttribute("Userlist", list);
		model.addAttribute("title", "Usertitle");
		
		return "user/index_boot";
		
	}

	@GetMapping("/form")
	public String form(UserForm userForm,
			ProductForm productForm, Model model,
		@ModelAttribute("complete") String complete) {
		model.addAttribute("title","Getuser form");
		return "user/form";
				
	}
	
	@PostMapping("/form")
	public String formGoBack(UserForm userForm, ProductForm productForm, Model model) {
		model.addAttribute("title","Postuser form");
		return "user/form";
				
	}
	
	@PostMapping("/confirm")
	public String confirm(@Validated UserForm userForm,
			BindingResult result,
			ProductForm productForm,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title","user form");
			return "user/form";
		}
		model.addAttribute("title","confirm page");
		return "user/confirm";
	}

	@PostMapping("/complete")
	public String complete(@Validated UserForm userForm,
	BindingResult result,
	ProductForm productForm,
	Model model,
	RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			model.addAttribute("title", "エラーだよ");
			return "user/form";
		}else if(!userService.save(userForm)){
			model.addAttribute("title", "既にアドレスが使われているよ");
			return "user/form";
		}
		redirectAttributes.addFlashAttribute("complete","保存完了!");
		return "redirect:/user/form";
	}

}
