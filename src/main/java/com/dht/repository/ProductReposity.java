/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.Product;
import java.util.List;

/**
 *
 * @author Phuong
 */
public interface ProductReposity {
    List<Product> getProducts(String kw, int page);
    int countProducts();
    boolean addOrUpdateProduct(Product p);
    
    Product getProoductById(int id);
}
