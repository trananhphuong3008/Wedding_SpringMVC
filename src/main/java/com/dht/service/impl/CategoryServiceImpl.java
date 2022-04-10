/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Category;
import com.dht.repository.CategoryReposity;
import com.dht.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author awmjo
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryReposity categoryReposity;
    
    @Override
    public List<Category> getCategories() {
        
        return this.categoryReposity.getCategories();
    }
    
}
