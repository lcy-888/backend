package com.its.demo.service;

import com.its.demo.domain.CurrentUserDTO;
import com.its.demo.domain.UserVO;
import org.springframework.stereotype.Service;


/**
 * 用户服务接口
 *
 * @author 杨金刚
 * @date 2020/4/20 15:41
 */
@Service
public interface UserService {

    UserVO getUserVOByUsername(String username);

    CurrentUserDTO getCurrentUserFromCache(String token);
}
