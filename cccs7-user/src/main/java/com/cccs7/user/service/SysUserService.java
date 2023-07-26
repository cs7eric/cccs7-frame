package com.cccs7.user.service;

import com.cccs7.user.entity.po.SysUser;
import com.cccs7.user.entity.req.SysUserReq;
import com.cccs7.web.bean.PageResponse;
import org.springframework.stereotype.Service;


/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2023-07-26 11:27:12
 */
@Service
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Long id);

    /**
     * 分页查询
     *

     * @return 查询结果
     */
    PageResponse<SysUser> queryByPage(SysUserReq sysUserReq);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
