/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.Cart;
import com.dht.pojo.Receipt;
import com.dht.pojo.ReceiptDetail;
import com.dht.repository.ProductReposity;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.dht.repository.ReceiptRepository;

/**
 *
 * @author awmjo
 */
@Repository
public class ReceiRepositoryImpl implements ReceiptRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private ProductReposity ProductReposity;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {
            Receipt r = new Receipt();

            s.save(r);

            if (cart != null) {
                for (Cart c : cart.values()) {
                    ReceiptDetail d = new ReceiptDetail();
                    d.setReceiptId(r);
                    d.setProductId(this.ProductReposity.getProoductById(c.getId()));
                    d.setQuantity(c.getQuantity());
                    d.setPrice(c.getPrice());

                    s.save(d);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
