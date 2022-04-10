/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service.impl;

import com.dht.pojo.Cart;
import com.dht.repository.ReceiptRepository;
import com.dht.service.ReceiptService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author awmjo
 */
@Service
public class ReceiptServiceImlp implements ReceiptService{
    @Autowired
    private ReceiptRepository receiptRepository;
    @Override
    public boolean addReceipt(Map<Integer, Cart> cart) {
        return this.receiptRepository.addReceipt(cart);
    }
    
}
