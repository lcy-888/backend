package com.its.demo.service.impl;

import com.its.demo.domain.*;
import com.its.demo.constant.BaseConstant;
import com.its.demo.service.LoginService;
import com.its.demo.service.DeptService;
import com.its.demo.service.UserService;
import com.its.demo.util.JWTUtil;
import com.its.demo.util.JsonUtil;
import com.its.demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 杨金刚
 * @date 2020/4/21 11:46
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Value("${jwt.prefixKey}")
    private String prefixKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public CurrentUserDTO login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        UserVO user = userService.getUserVOByUsername(username);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        if (!BaseConstant.USER_DISABLED.equals(user.getDisabled())) {
            throw new RuntimeException("用户被禁用");
        }

        String encryptPassword = MD5Util.getMD5Hash(password, username, 2, "hex");
        if (!encryptPassword.equals(user.getPassword())) {
            throw new RuntimeException("用户/密码不匹配");
        }

        DeptVO dept = deptService.getDeptVOById(user.getDeptId());

        //生成JWT令牌
        String jwtToken = JWTUtil.issueJWT(username, user.getRole(), expiration);

        CurrentUserDTO currentUser = new CurrentUserDTO();
        currentUser.setUserId(user.getId());
        currentUser.setUsername(username);
        currentUser.setRoleId(user.getRoleId());
        currentUser.setDeptId(user.getDeptId());
        currentUser.setDept(dept.getDept());
        currentUser.setRole(user.getRole());
        currentUser.setRoleDescription(user.getRoleDescription());
        currentUser.setParentDept(dept.getParentDept());
        currentUser.setJwtToken(jwtToken);

        //将令牌存入Redis
        stringRedisTemplate.opsForValue().set(prefixKey + jwtToken, "eureka", expiration * 60, TimeUnit.SECONDS);
        //将登录用户存入Redis
        stringRedisTemplate.opsForValue().set(BaseConstant.LOGINED_USER_CACHE_KEY_PREFIX + username,
                JsonUtil.toJSon(currentUser), 24, TimeUnit.HOURS);

        return currentUser;
    }

    @Override
    public boolean logout(String token) {
        stringRedisTemplate.delete(prefixKey + token);

        return true;
    }
}
