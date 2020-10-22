package com.its.demo.service;

import com.its.demo.domain.RoleDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨金刚
 * @date 2020/4/22 13:32
 */
@Service
public interface RoleService {
    /**
     *
     * @return
     */
    List<RoleDO> listAllRole();
}
