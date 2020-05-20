package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@NotNull(message = "空はだめですよ～")
//	@Size(min = 1, max = 20, message =  "1文字以上20文字以内で！")
	private int name;
	
//	@NotNull(message = "空はだめですよ～")
//	@Email(message = "フォーマットが違います")
	private String price;
	
//	@NotNull(message = "空はだめですよ～")
	private String cart_num;

	
}
