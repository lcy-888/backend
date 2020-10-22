package com.its.demo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 部门实体类
 *
 * @author 杨金刚
 * @date 2020/4/20 14:00
 */
@Data
public class DeptDO implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 部门
     */
    private String dept;
    /**
     * 上级部门ID
     */
    private Long parentDeptId;
    /**
     * 记录创建时间
     */
    private Date gmtCreate;
    /**
     * 记录修改时间
     */
    private Date gmtModified;
}
