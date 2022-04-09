/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.service.CategoryService;
import com.dht.service.ProductService;
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
 * @author Phuong
 */
@Controller
@ControllerAdvice
    public class HomeControllers {
        @Autowired
        private CategoryService categoryService;
        @Autowired
        private ProductService productService;
        
        @ModelAttribute
        public void commonAttribute(Model model){
              model.addAttribute("categories",this.categoryService.getCategories());
        }
                
        @RequestMapping("/")       
        public String index(Model model,
                @RequestParam(name="kw", required=false) String kw,
                @RequestParam(name="page",defaultValue = "1") Integer page){
    
            model.addAttribute("products",this.productService.getProducts(kw,page));
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

