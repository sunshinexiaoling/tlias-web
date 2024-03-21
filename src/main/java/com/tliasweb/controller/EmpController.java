package com.tliasweb.controller;

import com.tliasweb.pojo.Dept;
import com.tliasweb.pojo.Emp;
import com.tliasweb.pojo.PageBean;
import com.tliasweb.pojo.Result;
import com.tliasweb.service.EmpService;
import com.tliasweb.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author ling
 * @desc:
 * @date 2024/3/15 22:50
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询,参数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除,参数:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加,参数:{}",emp);
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询部门信息:{}",id);
        Emp emp = empService.selectById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result set(@RequestBody Emp emp){
        log.info("根据id:{}修改部门信息为:{}",emp.getId(),emp);
        empService.set(emp);
        return Result.success();
    }
}
