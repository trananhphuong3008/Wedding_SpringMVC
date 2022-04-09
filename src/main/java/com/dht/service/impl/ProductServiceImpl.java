/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Product;
import com.dht.repository.ProductReposity;
import com.dht.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phuong
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReposity productReposity;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productReposity.getProducts(kw, page);
    }

    @Override
    public int countProducts() {
        return this.productReposity.countProducts();
    }

    @Override
    public boolean addOrUpdateProduct(Product p) {
        if (p.getFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setImages((String) res.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.productReposity.addOrUpdateProduct(p);
    }

    @Override
    public Product getProoductById(int i) {
        return this.productReposity.getProoductById(i);
    }
}
