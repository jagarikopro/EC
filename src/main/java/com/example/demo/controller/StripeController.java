package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class StripeController {

    @GetMapping("/checkout")
    public String checkout(Model model) {

        return "stripe/stripe-checkout";

    }


	
	@RequestMapping(path = "/pay", method = { RequestMethod.POST })
    public String charge(
            @RequestParam("stripeToken") String stripeToken,
            @RequestParam("stripeTokenType") String stripeTokenType,
            @RequestParam("stripeEmail") String stripeEmail)
    {

        Stripe.apiKey = "sk_test_zyl9ezIjXWunH4Zbp6odgSZa00CZSyiTMg";

        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 500);
        chargeMap.put("description", "コットンTシャツ");
        chargeMap.put("currency", "jpy");
        chargeMap.put("source", stripeToken);

        try {
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        // ResponseEntity response = ResponseEntity.ok().build();

        return "/order";
    }

}
