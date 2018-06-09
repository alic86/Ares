package com.alic.handler;

import com.alic.repo.UserRepository;
import org.springframework.stereotype.Component;

/**
 * @author suxingzhe
 * @create 2018-06-08 下午12:35
 **/
@Component
public class UserHandler {
    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
