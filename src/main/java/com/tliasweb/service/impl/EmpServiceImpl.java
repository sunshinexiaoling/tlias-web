package com.tliasweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tliasweb.mapper.EmpMapper;
import com.tliasweb.pojo.Emp;
import com.tliasweb.pojo.PageBean;
import com.tliasweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ling
 * @desc:
 * @date 2024/3/15 22:51
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        int start=(page-1)*pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//        return new PageBean(count,empList);
//    }
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        PageHelper.startPage(page,pageSize);
//        List<Emp> empList = empMapper.list();
//        Page<Emp> p = (Page<Emp>) empList;
//
//        return new PageBean(p.getTotal(),p.getResult());
//    }
    @Override// public PageBean page(Integer page,Integer pageSize)
    public PageBean page(Integer page, Integer pageSize, String name, Short gender,
                         LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp selectById(Integer id) {
        Emp emp = empMapper.selectById(id);
        return emp;
    }

    @Override
    public void set(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.set(emp);
    }

    @Override
    public Emp login(Emp emp) {
        Emp e = empMapper.selectByUsernameAndPassword(emp);
        return e;
    }


}
