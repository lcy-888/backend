package com.its.demo.service.impl;

import com.its.demo.domain.UserDO;
import com.its.demo.constant.BaseConstant;
import com.its.demo.dao.UserMapper;
import com.its.demo.domain.CurrentUserDTO;
import com.its.demo.domain.UserVO;
import com.its.demo.service.UserService;
import com.its.demo.util.JWTUtil;
import com.its.demo.util.JsonUtil;
import com.its.demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 杨金刚
 * @date 2020/4/22 9:17
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public UserVO getUserVOByUsername(String username) {
        return userMapper.getUserVOByUsername(username);
    }

    @Override
    public CurrentUserDTO getCurrentUserFromCache(String token) {
        String username = JWTUtil.getUsernameFromToken(token);
        String json = stringRedisTemplate.opsForValue().get(BaseConstant.LOGINED_USER_CACHE_KEY_PREFIX + username);

        return JsonUtil.readValue(json, CurrentUserDTO.class);
    }
}
