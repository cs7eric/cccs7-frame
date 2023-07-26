package com.cccs7.user.controller;

import com.cccs7.user.entity.dto.SysUserDto;
import com.cccs7.user.entity.po.SysUser;
import com.cccs7.user.entity.req.SysUserReq;
import com.cccs7.user.service.SysUserService;
import com.cccs7.web.bean.PageResponse;
import com.cccs7.web.bean.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2023-07-26 11:27:02
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     * @return 查询结果
     */
    @GetMapping
    public Result<PageResponse<SysUser>> queryByPage(@RequestBody SysUserReq sysUserReq) {

        System.out.println(sysUserReq.toString());
        PageResponse<SysUser> pageResponse = this.sysUserService.queryByPage(sysUserReq);
        System.out.println(pageResponse.toString());
        return Result.ok(pageResponse);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<SysUser> queryById(@PathVariable("id") Long id) {
        return Result.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<SysUser> add(@RequestBody SysUser sysUser) {
        return Result.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<SysUser> edit(SysUser sysUser) {
        return Result.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Long id) {
        return Result.ok(this.sysUserService.deleteById(id));
    }


    @PostMapping("/insert")
    public Result<String> insert(@RequestBody SysUserReq sysUserReq){

        SysUserDto sysUserDto = new SysUserDto();
        BeanUtils.copyProperties(sysUserReq, sysUserDto);
        int res = sysUserService.insertFunc(sysUserDto);
        return Result.ok("成功");
    }
}

