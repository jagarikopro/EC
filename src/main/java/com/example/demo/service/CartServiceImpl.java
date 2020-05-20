package com.example.demo.service;

import org.dbflute.cbean.result.ListResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dbflute.exbhv.CartBhv;
import com.example.demo.dbflute.exbhv.pmbean.CartInProductDitailsPmb;
import com.example.demo.dbflute.exentity.customize.CartInProductDitails;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartBhv cartBhv;


	public int countCart(int userId){

		CartInProductDitailsPmb cartPmb = new CartInProductDitailsPmb();
		cartPmb.setUserId(userId);
		ListResultBean<CartInProductDitails> carts = cartBhv.outsideSql().selectList(cartPmb);

		int totalCount = 0;
		for(CartInProductDitails cart : carts){
			totalCount += cart.getCartNum();
		}
		
		return totalCount;
	};

}
