package com.its.demo.service;

import com.its.demo.domain.LoginDTO;
import com.its.demo.domain.CurrentUserDTO;
import org.springframework.stereotype.Service;

/**
 * 登录服务接口
 *
 * @author 杨金刚
 * @date 2020/4/20 13:45
 */
@Service
public interface LoginService {

    CurrentUserDTO login(LoginDTO loginDTO);

    boolean logout(String token);
}
