/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository;

import com.dht.pojo.User;

/**
 *
 * @author awmjo
 */
public interface UserRepository {
    boolean addUser(User user);
    User getUserByUsername(String username);
}
