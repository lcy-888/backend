package com.its.demo.controller;

import com.its.demo.domain.LoginDTO;
import com.its.demo.domain.CurrentUserDTO;
import com.its.demo.service.LoginService;
import com.its.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 登录API
 *
 * @author 杨金刚
 * @date 2020/4/20 16:08
 */
@RestController
@RequestMapping(value = "api/v1")
@Api(tags = {"用户登录操作接口"})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParam(name = "loginDTO", value = "登录时提交的数据对象", dataType = "LoginDTO", required = true, paramType = "body")
    public CurrentUserDTO login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }


    @GetMapping(value = "/current-user")
    @ApiOperation(value = "获取当前用户", notes = "获取当前登录用户信息")
    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    public CurrentUserDTO getCurrentUser(@RequestHeader String authorization){
        return userService.getCurrentUserFromCache(authorization);
    }

    @DeleteMapping(value = "/logout")
    @ApiOperation(value = "用户签退", notes = "用户退出系统")
    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    public boolean logout(@RequestHeader String authorization){
        return loginService.logout(authorization);
    }
}
