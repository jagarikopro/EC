package com.example.demo.controller;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.SessionUser;
import com.example.demo.dbflute.exbhv.CartBhv;
import com.example.demo.dbflute.exbhv.ProductBhv;
import com.example.demo.dbflute.exbhv.StockBhv;
import com.example.demo.dbflute.exbhv.pmbean.CartInProductDitailsPmb;
import com.example.demo.dbflute.exbhv.pmbean.CartInTotalPricePmb;
import com.example.demo.dbflute.exbhv.pmbean.ProductRelationPmb;
import com.example.demo.dbflute.exentity.Cart;
import com.example.demo.dbflute.exentity.Stock;
import com.example.demo.dbflute.exentity.customize.CartInProductDitails;
import com.example.demo.dbflute.exentity.customize.CartInTotalPrice;
import com.example.demo.dbflute.exentity.customize.ProductRelation;
import com.example.demo.dto.ProductForm;
import com.example.demo.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/cart")
public class CartController {
	
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

    @Autowired
    CartService cartService;

    @GetMapping
    public String home(ProductForm productForm, Model model) {
        if (!sessionUser.isUserSession()) {
            model.addAttribute("error", "カートを利用するにはログインまたは会員登録をしてください。");
            return "login";
        }
        return "cart";
    }

    @RequestMapping(value = "/changeCount", method = { RequestMethod.GET })
    public @ResponseBody String CheckUser() {

        int totalcount = cartService.countCart(sessionUser.getUser_id());
        return String.valueOf(totalcount);
    }

    @RequestMapping(value = "/get", method = {
            RequestMethod.GET })
    public @ResponseBody String get() {
        CartInProductDitailsPmb cartPmb = new CartInProductDitailsPmb();
        cartPmb.setUserId(sessionUser.getUser_id());
        ListResultBean<CartInProductDitails> cart = cartBhv.outsideSql().selectList(cartPmb);
        try {
            String cartJson = mapper.writeValueAsString(cart);
            return cartJson;
        } catch (JsonProcessingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getPrice", method = { RequestMethod.GET })
    public @ResponseBody String getPrice() {
        CartInTotalPricePmb totalPricePmb = new CartInTotalPricePmb();
        totalPricePmb.setUserId(sessionUser.getUser_id());
        ListResultBean<CartInTotalPrice> totalPrice = stockBhv.outsideSql().selectList(totalPricePmb);
        try {
            String priceJson = mapper.writeValueAsString(totalPrice);
            return priceJson;
        } catch (JsonProcessingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = {
            RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
                    + ";charset=utf-8")
    public @ResponseBody boolean cartDelete(@RequestBody String requestJson) {
        try {
            JsonNode node = mapper.readTree(requestJson);
            int cartId = node.get("cartId").asInt();
            int productId = node.get("productId").asInt();
            int cartNum = node.get("cartNum").asInt();

            //在庫確保の解除
            ProductRelationPmb productPmb = new ProductRelationPmb();
            productPmb.setProductId(productId);
            OptionalEntity<ProductRelation> productOpt = productBhv.outsideSql().selectEntity(productPmb);
            if (!productOpt.isPresent()) {
                return false;
            };
            int updateTemporarySales = productOpt.get().getTemporarySales() - cartNum;
            if (productOpt.get().getStockNum() < updateTemporarySales) {
                return false;
            }
            Stock stock = new Stock();
            stock.uniqueBy(productId);
            stock.setTemporarySales(updateTemporarySales);
            stockBhv.update(stock);

            //カート内商品を削除
            Cart cart = new Cart();
            cart.setCartId(cartId);
            cartBhv.delete(cart);
        } catch (JsonProcessingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/change", method = {
            RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
                    + ";charset=utf-8")
    public @ResponseBody boolean cartChange(@RequestBody String requestJson) {
        try {
            JsonNode node = mapper.readTree(requestJson);
            int cartId = node.get("cartId").asInt();
            int productId = node.get("productId").asInt();
            int cartNum = node.get("cartNum").asInt();
            int defaultCartNum = node.get("defaultCartNum").asInt();

            // 仮売上を行うため在庫の確認を行う
            ProductRelationPmb productPmb = new ProductRelationPmb();
            productPmb.setProductId(productId);
            OptionalEntity<ProductRelation> productOpt = productBhv.outsideSql().selectEntity(productPmb);
            if (!productOpt.isPresent()) {
                return false;
            }

            int updateTemporarySales = productOpt.get().getTemporarySales() + (cartNum - defaultCartNum);
            if (productOpt.get().getStockNum() < updateTemporarySales) {
                return false;
            }

            Cart cart = new Cart();
            cart.setCartId(cartId);
            cart.setCartNum(cartNum);
            cartBhv.update(cart);

            Stock stock = new Stock();
            stock.uniqueBy(productId);
            stock.setTemporarySales(updateTemporarySales);
            stockBhv.update(stock);

        } catch (JsonProcessingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
