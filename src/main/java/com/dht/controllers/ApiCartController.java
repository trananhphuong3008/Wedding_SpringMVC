/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Cart;
import com.dht.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Phuong
 */

@RestController
@RequestMapping("/api")
public class ApiCartController {
    @PostMapping("/add-cart")
    public  ResponseEntity<Map<String, String>> addToCart(HttpSession session,
            @RequestBody Cart c){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart==null)
            cart = new HashMap<>();
        
        if (cart.containsKey(c.getId()) == true ){
            Cart c1 = cart.get(c.getId());
            c1.setQuantity(c1.getQuantity()+ 1);
        }else{
            cart.put(c.getId(), c);
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(Utils.cartStats(cart),HttpStatus.OK);
    }
}
