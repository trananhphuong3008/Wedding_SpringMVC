/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service;

import com.dht.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author awmjo
 */
public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    User getUserByUsername(String username);
}
