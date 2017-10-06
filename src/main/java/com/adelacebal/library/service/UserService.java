package com.adelacebal.library.service;

import com.adelacebal.library.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User findUserByUsername(String username);
}
