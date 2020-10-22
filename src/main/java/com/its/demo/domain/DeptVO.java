package com.its.demo.domain;

import lombok.Data;

/**
 * 部门视图类
 *
 * @author 杨金刚
 * @date 2020/4/24 10:06
 */
@Data
public class DeptVO extends DeptDO {
    /**
     * 上级部门
     */
    private String parentDept;
}
