package com.tliasweb.controller;


import com.tliasweb.pojo.Dept;
import com.tliasweb.pojo.Result;
import com.tliasweb.service.DeptService;
import com.tliasweb.service.EmpService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ling
 * @desc: 部门链接
 * @date 2024/3/15 22:49
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    /**
     * 根据id删除部门
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门数据:{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询部门信息:{}",id);
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result set(@RequestBody Dept dept){
        log.info("根据id:{}修改部门信息为:{}",dept.getId(),dept);
        deptService.set(dept);
        return Result.success();
    }


}
