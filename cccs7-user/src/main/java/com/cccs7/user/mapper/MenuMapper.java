package com.cccs7.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.user.entity.po.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p> menuMapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description menuMapper
 * @Date 2023/8/7 13:20
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询用户 权限
     *
     * @param id id
     * @return {@link List}<{@link String}>
     */
    List<String> selectPermsByUserId(Long id);
}
