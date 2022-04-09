/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;

import com.dht.pojo.Product;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Phuong
 */
@Controller
@RequestMapping("/admin")
public class ProductControllers {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/product-add")
    public String addView(Model model){
         model.addAttribute("categories",this.categoryService.getCategories());
         model.addAttribute("product",new Product());
        return "product";
    }
    @PostMapping("/product-add")
    public String addHandler(Model model,@ModelAttribute(value = "product") Product p){
        if (this.productService.addOrUpdateProduct(p)==true) {
            return "redirect:/";
        }
          model.addAttribute("errMsg","Some thing wrong !!! Please try it again ");
    return "product";
    }
}
