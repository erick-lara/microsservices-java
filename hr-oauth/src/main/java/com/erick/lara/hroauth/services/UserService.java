package com.erick.lara.hroauth.services;

import com.erick.lara.hroauth.domain.User;
import com.erick.lara.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findUserByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null){
            LOGGER.error("[FIND USER BY EMAIL] Email not found: {}",email);
            throw new IllegalArgumentException("Email not found");
        }

        LOGGER.info("[FIND USER BY EMAIL] Email found: {}",email);
        return user;
    }
}
