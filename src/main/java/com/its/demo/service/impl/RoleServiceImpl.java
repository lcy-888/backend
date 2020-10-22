package com.its.demo.service.impl;

import com.its.demo.dao.RoleMapper;
import com.its.demo.domain.RoleDO;
import com.its.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDO> listAllRole() {
        return roleMapper.listAllRole();
    }
}
