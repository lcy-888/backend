package com.its.demo.dao;

import com.its.demo.domain.DeptDO;
import com.its.demo.domain.DeptVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 部门Mapper
 *
 * @author 杨金刚
 * @date 2020/8/10 13:36
 */
@Mapper
@Component(value = "deptMapper")
public interface DeptMapper {

    /**
     * 通过部门ID获取部门视图信息
     *
     * @param id 部门ID
     * @return 单个部门信息
     */
    DeptVO getDeptVOById(Long id);

}
