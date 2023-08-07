package com.cccs7.user.controller;

import com.cccs7.mybatisplus.entity.PageResult;
import com.cccs7.user.entity.dto.UserDto;
import com.cccs7.user.entity.po.UserPo;
import com.cccs7.user.entity.req.UserListReq;
import com.cccs7.user.entity.req.UserReq;
import com.cccs7.user.service.UserService;
import com.cccs7.web.bean.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<Map<String, String>> login(@RequestBody UserPo userPo) {

        return userService.login(userPo);
    }

    @PostMapping("/add")
    public Result<Integer> addUser(@RequestBody UserReq userReq) {

        UserDto userDto = new UserDto();
        System.out.println(userReq);
        BeanUtils.copyProperties(userReq, userDto);
        int count = userService.addUser(userDto);
        return Result.ok(count);
    }

    @DeleteMapping()
    public Result<String> deleteUserById(@RequestParam("id") Integer id) {
        int count = userService.deleteUserById(id);
        return Result.ok("删除成功");
    }

    @GetMapping("/list")
    public Result<PageResult<UserPo>> getUserPage(@RequestBody UserListReq userListReq) {
        UserDto userDto = new UserDto();
        System.out.println(userListReq);
        BeanUtils.copyProperties(userListReq, userDto);

        System.out.println(userDto);
        PageResult<UserPo> page = userService.getUserPage(userDto);
        return Result.ok(page);
    }
}
