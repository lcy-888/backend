package com.its.demo.domain;

import lombok.Data;

/**
 * 当前登录用户信息
 *
 * @author 杨金刚
 * @date 2020/4/21 13:02
 */
@Data
public class CurrentUserDTO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 登录名
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 部门
     */
    private String dept;
    /**
     * 上级部门
     */
    private String parentDept;
    /**
     * 令牌
     */
    private String jwtToken;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色
     */
    private String role;
    /**
     * 角色描述
     */
    private String roleDescription;
    /**
     * 未读通知数
     */
    private Integer unreadCount;
}
