package com.cccs7.user.service;

import com.cccs7.user.entity.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int addUser(UserDto userDto);

    int deleteUserById(Integer id);
}
