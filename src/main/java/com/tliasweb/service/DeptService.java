package com.tliasweb.service;

import com.tliasweb.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept selectById(Integer id);

    void set(Dept dept);
}
