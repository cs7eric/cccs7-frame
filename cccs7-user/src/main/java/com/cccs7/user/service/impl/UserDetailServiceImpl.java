package com.cccs7.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cccs7.user.entity.LoginUser;
import com.cccs7.user.entity.po.UserPo;
import com.cccs7.user.mapper.MenuMapper;
import com.cccs7.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>  </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description
 * @Date 2023/8/7 13:30
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<UserPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserPo::getUserName, username);
        UserPo userPo = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(userPo)) {
            throw new RuntimeException("用户名或者密码错误");
        }

        // 根据用户信息 查询权限信息，添加到 loginUser 中
        List<String> perms = menuMapper.selectPermsByUserId(userPo.getId());
        // 封装成 UserDetail 对象返回
        return new LoginUser(userPo, perms);
    }
}
