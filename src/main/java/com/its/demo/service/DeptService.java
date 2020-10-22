package com.its.demo.service;

import com.its.demo.domain.DeptVO;
import org.springframework.stereotype.Service;

/**
 * @author 杨金刚
 * @date 2020/4/22 13:32
 */
@Service
public interface DeptService {

    /**
     * 通过ID获取部门详细信息
     *
     * @param id 部门ID
     * @return 部门对象
     */
    DeptVO getDeptVOById(Long id);

}
