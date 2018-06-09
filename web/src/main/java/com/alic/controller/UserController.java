package com.alic.controller;

import com.alic.domain.User;
import com.alic.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author suxingzhe
 * @create 2018-06-05 下午2:30
 **/
@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/user/save")
    public User user(@RequestParam String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);

        return user;
    }

    @PostMapping("/user/save2")
    public User user(@Valid @RequestBody User user){
//        userRepository.save(user);

        return user;
    }

    @PostMapping("/user/all")
    public Collection<User> allUsers(){
        Collection<User> all = userRepository.findAll();
        return all;
    }

    @PostMapping(value = "/user/json/2/properties"
                ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE   //请求类型
                ,produces = "application/properties+user"           //响应类型
    )
    public User userJson2Properties(@RequestBody User user){

        return user;
    }

    @PostMapping(value = "/user/properties/2/json"
                ,consumes = "application/properties+user"           //请求类型
                ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE   //响应类型
    )
    public User userProperties2Json(@RequestBody User user){

        return user;
    }
}
