package com.cccs7.user.controller;

import com.cccs7.user.entity.dto.UserDto;
import com.cccs7.user.entity.req.UserReq;
import com.cccs7.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Integer addUser(@RequestBody UserReq userReq){

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        int count = userService.addUser(userDto);
        return count;
    }
}
