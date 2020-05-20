package com.example.demo.service;

import java.util.List;

import org.dbflute.optional.OptionalEntity;

import com.example.demo.dbflute.exentity.Product;
import com.example.demo.dbflute.exentity.Stock;
import com.example.demo.dbflute.exentity.customize.ProductRelation;
import com.example.demo.dto.ProductForm;


public interface ProductService {
	
	List<ProductRelation>  getAll();

	 void insert(ProductForm productForm);

	void deleteById(int id);

	OptionalEntity<ProductRelation> getProduct(int id);

	 void update(Product product, Stock stock);
}
