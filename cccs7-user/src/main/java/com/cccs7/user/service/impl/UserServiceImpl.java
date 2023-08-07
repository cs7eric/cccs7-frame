package com.cccs7.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cccs7.mybatisplus.entity.PageResult;
import com.cccs7.redis.util.RedisCache;
import com.cccs7.security.util.JwtUtils;
import com.cccs7.user.entity.LoginUser;
import com.cccs7.user.entity.dto.UserDto;
import com.cccs7.user.entity.po.UserPo;
import com.cccs7.user.mapper.UserMapper;
import com.cccs7.user.service.UserService;
import com.cccs7.web.bean.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result<Map<String, String>> login(UserPo userPo) {

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userPo.getUserName(), userPo.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // 如果认证没有通过，给出相应的提示
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        // 如果认证通过，使用 userid 生成一个 jwt, jwt 存入 Result 中
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getUserPo().getId().toString();
        String jwt = JwtUtils.createJWT(userid);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把完整的信息 存到 redis ,userid 作为 key
        redisCache.setCacheObject("login:" + userid, loginUser);
        return Result.ok(map);
    }

    @Override
    public int addUser(UserDto userDto) {

        System.out.println("service");
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        System.out.println("mapper");
        int count = userMapper.insert(userPo);
        System.out.println("mapper over");
        return count;
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageResult<UserPo> getUserPage(UserDto userDto) {
        IPage<UserPo> userPoPage = new Page<>(userDto.getPageIndex(), userDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPoPage);
        PageResult<UserPo> pageResult = new PageResult<>();
        pageResult.loadData(userPage);
        return pageResult;
    }


}
