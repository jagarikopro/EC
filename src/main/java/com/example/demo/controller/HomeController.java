package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.SessionUser;
import com.example.demo.dbflute.exbhv.CartBhv;
import com.example.demo.dbflute.exbhv.ProductBhv;
import com.example.demo.dbflute.exbhv.StockBhv;
import com.example.demo.dbflute.exbhv.pmbean.CartInProductDitailsPmb;
import com.example.demo.dbflute.exbhv.pmbean.ProductRelationPmb;
import com.example.demo.dbflute.exentity.Cart;
import com.example.demo.dbflute.exentity.Stock;
import com.example.demo.dbflute.exentity.customize.CartInProductDitails;
import com.example.demo.dbflute.exentity.customize.ProductRelation;
import com.example.demo.dto.ProductForm;
import com.example.demo.dto.UserForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
    private ProductBhv productBhv;
    
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private SessionUser sessionUser;

    @Autowired
    private CartBhv cartBhv;

    @Autowired
    private StockBhv stockBhv;

    @GetMapping
    public String home(@ModelAttribute("userForm") UserForm userForm, Model model) {
        return "home";
    }

    @RequestMapping(value = "/likeSearch", method = { RequestMethod.POST })
    public String productForm(@Validated ProductForm productForm, BindingResult result, Model model) {

        model.addAttribute("title", productForm.getName() + "の検索結果");
        return "serch_result";

    }


    @RequestMapping(value = "/json", method = { RequestMethod.POST },
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public @ResponseBody String cartIn(@RequestBody String requestJson) throws IOException {
        // System.out.println(requestJson);
        //ユーザがログイン済みかどうかを判定
         if (!sessionUser.isUserSession()) {
            return mapper.writeValueAsString("NG");
        }
        try {
            //リクエストJsonから値を取得
            JsonNode node = mapper.readTree(requestJson);
            int productId = node.get("productId").asInt();
            int cartNum = node.get("cartNum").asInt();

            //仮売上を行うため在庫の確認を行う
            ProductRelationPmb productPmb = new ProductRelationPmb();
            productPmb.setProductId(productId);
            OptionalEntity<ProductRelation> productOpt = productBhv.outsideSql().selectEntity(productPmb);
            if(!productOpt.isPresent()) {
                return mapper.writeValueAsString("NO");
            }

            int updateTemporarySales= productOpt.get().getTemporarySales() + cartNum;
            if(productOpt.get().getStockNum() < updateTemporarySales){
                return mapper.writeValueAsString("NO");
            }
            

            //既にカートの中に商品が存在する場合はカート個数を足す
            CartInProductDitailsPmb cartPmb = new CartInProductDitailsPmb();
            cartPmb.setUserId(sessionUser.getUser_id());
            cartPmb.setProductId(productId);
            OptionalEntity<CartInProductDitails> cartOpt = cartBhv.outsideSql().selectEntity(cartPmb);
            Cart cart = new Cart();
            if(cartOpt.isPresent()) {
                cart.setCartId(cartOpt.get().getCartId());
                cart.setCartNum(cartNum + cartOpt.get().getCartNum());
                cartBhv.update(cart);
            } else{
                cart.setProductId(productId);
                cart.setUserId(sessionUser.getUser_id());
                cart.setCartNum(cartNum);
                cart.setCreated(LocalDateTime.now());
                cartBhv.insert(cart);
            }
            Stock stock = new Stock();
            stock.uniqueBy(productId);
            stock.setTemporarySales(updateTemporarySales);
            stockBhv.update(stock);
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return mapper.writeValueAsString("OK");
    }

    @RequestMapping(value = "/get", method = {
            RequestMethod.GET })
    public @ResponseBody String get() {
        ProductRelationPmb pmb = new ProductRelationPmb();
        ListResultBean<ProductRelation> productList = productBhv.outsideSql().selectList(pmb);
        try {
            String json = mapper.writeValueAsString(productList);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/searchget", method = { RequestMethod.POST }
    // ,
    // produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE+ ";charset=utf-8"
    )
    public @ResponseBody String searchget(@RequestBody String requestJson) {
        ProductRelationPmb pmb = new ProductRelationPmb();
        pmb.setProductName_ContainSearch(requestJson);
//        pmb.getProductNameInternalLikeSearchOption();
        ListResultBean<ProductRelation> productList = productBhv.outsideSql().selectList(pmb);
        try {
            String json = mapper.writeValueAsString(productList);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return null;
    }

}
