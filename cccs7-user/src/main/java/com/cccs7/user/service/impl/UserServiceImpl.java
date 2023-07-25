package com.cccs7.user.service.impl;

import com.cccs7.user.entity.dto.UserDto;
import com.cccs7.user.entity.po.UserPo;
import com.cccs7.user.mapper.UserMapper;
import com.cccs7.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {

        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        int count = userMapper.insert(userPo);
        return count;
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }


}
