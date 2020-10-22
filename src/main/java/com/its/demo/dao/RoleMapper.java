package com.its.demo.dao;

import com.its.demo.domain.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author 杨金刚
 * @date 2020/8/9 13:36
 */
@Mapper
@Component(value = "roleMapper")
public interface RoleMapper {
    /**
     * 获取所有角色信息
     *
     * @return
     */
    List<RoleDO> listAllRole();
}
