package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.dbflute.cbean.result.ListResultBean;
import org.dbflute.optional.OptionalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.config.SessionUser;
import com.example.demo.dbflute.exbhv.CartBhv;
import com.example.demo.dbflute.exbhv.OrdersBhv;
import com.example.demo.dbflute.exbhv.ProductBhv;
import com.example.demo.dbflute.exbhv.StockBhv;
import com.example.demo.dbflute.exbhv.pmbean.CartInProductDitailsPmb;
import com.example.demo.dbflute.exbhv.pmbean.CartInTotalPricePmb;
import com.example.demo.dbflute.exbhv.pmbean.ProductRelationPmb;
import com.example.demo.dbflute.exentity.Orders;
import com.example.demo.dbflute.exentity.Stock;
import com.example.demo.dbflute.exentity.customize.CartInProductDitails;
import com.example.demo.dbflute.exentity.customize.CartInTotalPrice;
import com.example.demo.dbflute.exentity.customize.ProductRelation;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private SessionUser sessionUser;

    @Autowired
    private CartBhv cartBhv;

    @Autowired
    private StockBhv stockBhv;

    @Autowired
    private OrdersBhv ordersBhv;

    @Autowired
    private ProductBhv productBhv;

    @RequestMapping(method = { RequestMethod.POST })
    public String charge(
            @RequestParam("stripeToken") String stripeToken,
            @RequestParam("stripeTokenType") String stripeTokenType,
            @RequestParam("stripeEmail") String stripeEmail,
            Model model, RedirectAttributes redirectAttributes)
    {

        Stripe.apiKey = "sk_test_zyl9ezIjXWunH4Zbp6odgSZa00CZSyiTMg";

        int userId = sessionUser.getUser_id();

        CartInTotalPricePmb totalPricePmb = new CartInTotalPricePmb();
        totalPricePmb.setUserId(sessionUser.getUser_id());
        OptionalEntity<CartInTotalPrice> totalPrice = stockBhv.outsideSql().selectEntity(totalPricePmb);
        BigDecimal paymentPrice = totalPrice.get().getTotalPrice();

        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", paymentPrice.intValue());
        chargeMap.put("description", "購入されました～");
        chargeMap.put("currency", "jpy");
        chargeMap.put("source", stripeToken);

        try {
            Charge charge = Charge.create(chargeMap);
        } catch (StripeException e) {
            redirectAttributes.addFlashAttribute("complete", "支払いに失敗しました");
            return "redirect:/cart";
        }
        
        //カート情報を取得しオーダーテーブルにデータを作成する
        CartInProductDitailsPmb cartPmb = new CartInProductDitailsPmb();
        cartPmb.setUserId(userId);
        ListResultBean<CartInProductDitails> cartList = cartBhv.outsideSql().selectList(cartPmb);

        for(CartInProductDitails cart : cartList){
            Orders orders = new Orders();
            orders.setProductId(cart.getProductId());
            orders.setUserId(userId);
            orders.setOrderNum(cart.getCartNum());
            orders.setCreated(LocalDateTime.now());
            ordersBhv.insert(orders);
            
            //商品の在庫をカート分減らす
            ProductRelationPmb productPmb = new ProductRelationPmb();
            productPmb.setProductId(cart.getProductId());
            OptionalEntity<ProductRelation> productRelation = productBhv.outsideSql().selectEntity(productPmb);

            Stock stock = new Stock();
            stock.uniqueBy(cart.getProductId());
            stock.setStockNum(productRelation.get().getStockNum() - cart.getCartNum());
            stock.setTemporarySales(productRelation.get().getTemporarySales() - cart.getCartNum());
            stockBhv.update(stock);
        }
        //ユーザのカートを空にする
        cartBhv.queryDelete(cb -> {
            cb.query().setUserId_Equal(userId);
        });

        redirectAttributes.addFlashAttribute("complete", "購入できました");
        return "redirect:/cart";
    }

}
