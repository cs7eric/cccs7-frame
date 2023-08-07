package com.cccs7.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cccs7.user.entity.po.UserPo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>  </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description
 * @Date 2023/8/7 13:00
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private UserPo userPo;

    /**
     * 存储权限信息权限
     */
    private List<String> permissions;

    public LoginUser(UserPo userPo, List<String> permissions) {
        this.userPo = userPo;
        this.permissions = permissions;
    }

    /**
     * 存储 SpringSecurity 所需要的 权限信息的集合
     */
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (authorities != null) {
            return authorities;
        }
        // 把 permissions 中的 字符串类型的权限信息 转换成 GrantedAuthority 对象 存入 authorities
        authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPo.getPassword();
    }

    @Override
    public String getUsername() {
        return userPo.getNickName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
