package com.tliasweb.service.impl;

import com.tliasweb.mapper.DeptMapper;
import com.tliasweb.mapper.EmpMapper;
import com.tliasweb.pojo.Dept;
import com.tliasweb.service.DeptService;
import com.tliasweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ling
 * @desc:
 * @date 2024/3/15 22:51
 */
@Scope(value = "prototype")
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        log.info("逻辑层查询全部部门数据");

        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
        int i=1/0;
        empMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept selectById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Override
    public void set(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.set(dept);
    }
}
