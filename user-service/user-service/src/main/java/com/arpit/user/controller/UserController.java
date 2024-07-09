package com.arpit.user.controller;

import com.arpit.user.VO.ResponseTemplateVO;
import com.arpit.user.entity.User;
import com.arpit.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside user save user");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getaUserWithDepartment(@PathVariable Long id){
        log.info("Inside user get user");
        return userService.getaUserWithDepartment(id);
    }

}
