package com.example.demo.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dto.UserForm;

@ControllerAdvice
@SessionAttributes(types = {UserForm.class})
public class WevMvcControllerAdvice{

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String hadnleException(EmptyResultDataAccessException e, Model model) {
		model.addAttribute("message", e);
		return "error/CustomPage";
	}
	
	/*
	 * This method changes empty character to null
	 * こちらのメソッドを用意しておくと送信された空文字はnullに変換されます
	 */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
    @ModelAttribute("userForm")
    public UserForm setUpUserForm() {
        return new UserForm();
    }
}