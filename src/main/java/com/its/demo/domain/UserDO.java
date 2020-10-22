package com.its.demo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author 杨金刚
 * @date 2020/8/9 13:50
 */
@Data
public class UserDO implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 登录名
     */
    private String username;
    /**
     * 口令
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 禁止标记：1-禁用；0-正常
     */
    private Integer disabled;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 记录创建时间
     */
    private Date gmtCreate;
    /**
     * 记录修改时间
     */
    private Date gmtModified;
}
