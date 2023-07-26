package com.cccs7.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cccs7.user.entity.po.SysUser;
import com.cccs7.user.dao.SysUserDao;
import com.cccs7.user.entity.req.SysUserReq;
import com.cccs7.user.service.SysUserService;
import com.cccs7.web.bean.PageResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-07-26 11:27:12
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Long id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @Override
    public PageResponse<SysUser> queryByPage(SysUserReq sysUserReq) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserReq, sysUser);
        PageResponse<SysUser> response = new PageResponse<>();
        response.setCurrent(sysUserReq.getPageNo());
        response.setPageSize(sysUserReq.getPageSize());
        Long pageStart = (sysUserReq.getPageNo() - 1) * sysUserReq.getPageSize();
        Long total = this.sysUserDao.count(sysUser);
        List<SysUser> sysUserList = this.sysUserDao.queryAllByLimit(sysUser, pageStart, sysUserReq.getPageSize());
        response.setTotal(total);
        response.setRecords(sysUserList);
        return response;
    }
    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserDao.deleteById(id) > 0;
    }
}
