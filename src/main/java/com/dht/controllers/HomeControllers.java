/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Cart;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import com.dht.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author awmjo
 */
@Controller
@ControllerAdvice
    public class HomeControllers {
        @Autowired
        private CategoryService categoryService;
        @Autowired
        private ProductService productService;
        
        @ModelAttribute
        public void commonAttribute(Model model, HttpSession session){
              model.addAttribute("categories",this.categoryService.getCategories());
              model.addAttribute("cartStats", Utils.cartStats((Map<Integer, Cart>) session.getAttribute("cart")));
        }
                
        @RequestMapping("/")       
        public String index(Model model,
                @RequestParam(name="kw", required=false) String kw,
                @RequestParam(name="categoryId", required=false, defaultValue = "" ) String categoryId, 
                @RequestParam(name="page", required=false, defaultValue = "1") Integer page){
    
            Map<String, String> params = new HashMap<>();
            params.put("kw", kw);
            params.put("categoryId" , categoryId);
            
            model.addAttribute("products",this.productService.getProducts(params,page));
            model.addAttribute("productCounter",this.productService.countProducts());
            return "index";
        }
        @RequestMapping("/product/{productId}")
        public String productDetail(Model model,
                @PathVariable(name = "productId") int id){
            model.addAttribute("product",this.productService.getProoductById(id));
            return "product-detail";
        }
    }

