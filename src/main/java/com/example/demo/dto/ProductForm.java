package com.example.demo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int product_id;

	@NotNull(message = "空はだめですよ～")
	// @JsonProperty("name")
	private String name;
	
	// @JsonProperty("description")
    private String description;

    @NotNull(message = "空はだめですよ～")
    private BigDecimal price;

    @NotNull(message = "空はだめですよ～")
	private String unit;
    
    @NotNull(message = "空はだめですよ～")
	private int stock;

	private int stemporary_salestock;
	
	private String image;

	private LocalDateTime created;
	
	public boolean isNewProduct; 

	private MultipartFile fileData;

}
