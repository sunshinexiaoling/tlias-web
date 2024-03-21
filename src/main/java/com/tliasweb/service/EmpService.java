package com.tliasweb.service;

import com.tliasweb.pojo.Dept;
import com.tliasweb.pojo.Emp;
import com.tliasweb.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize,String name, Short gender,
                  LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp selectById(Integer id);

    void set(Emp emp);

    Emp login(Emp emp);

}
