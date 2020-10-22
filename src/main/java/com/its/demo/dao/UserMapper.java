package com.its.demo.dao;

import com.its.demo.domain.RoleDO;
import com.its.demo.domain.UserDO;
import com.its.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 用户Mapper
 *
 * @author 杨金刚
 * @date 2020/4/22 9:21
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {

    UserVO getUserVOByUsername(String username);

    void changePassword(@Param("password") String password,
                        @Param("username") String username);

}
