package com.its.demo.domain;

import lombok.Data;

/**
 * 部门视图类
 *
 * @author 杨金刚
 * @date 2020/4/26 14:37
 */
@Data
public class UserVO extends UserDO{
    /**
     * 部门
     */
    private String dept;
    /**
     * 上级部门
     */
    private String parentDept;
    /**
     * 角色
     */
    private String role;
    /**
     * 角色汉字描述
     */
    private String roleDescription;
}
