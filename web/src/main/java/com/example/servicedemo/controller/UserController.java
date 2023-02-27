package com.example.servicedemo.controller;

import com.example.servicedemo.domain.User;
import com.example.servicedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
//    @RequestMapping(value="/person/save",method = RequestMethod.POST)
    //这种写法是url后面带参数  法克
    public User save(@RequestParam(value = "name",required = false) String name) {
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)) {
            System.out.printf("用户对象 %s 存储成功\n", user);
        }
        return user;
    }

}
