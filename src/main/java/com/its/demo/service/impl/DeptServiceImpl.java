package com.its.demo.service.impl;

import com.its.demo.dao.DeptMapper;
import com.its.demo.domain.DeptVO;
import com.its.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 杨金刚
 * @date 2020/4/22 13:34
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public DeptVO getDeptVOById(Long id) {
        return deptMapper.getDeptVOById(id);
    }

}
