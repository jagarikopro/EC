package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private int user_id;
	
	@NotNull(message = "空はだめですよ～")
	@Size(min = 1, max = 20, message =  "1文字以上20文字以内で！")
	private String name;
	
	@NotNull(message = "空はだめですよ～")
	@Email(message = "フォーマットが違います")
	private String email;
	
	@NotNull(message = "空はだめですよ～")
	private String password;

	private LocalDateTime created;

	
}
