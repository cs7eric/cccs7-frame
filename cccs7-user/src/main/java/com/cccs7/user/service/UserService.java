package com.cccs7.user.service;

import com.cccs7.mybatisplus.entity.PageResult;
import com.cccs7.user.entity.dto.UserDto;
import com.cccs7.user.entity.po.UserPo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int addUser(UserDto userDto);

    int deleteUserById(Integer id);

    PageResult<UserPo> getUserPage(UserDto userDto);
}
