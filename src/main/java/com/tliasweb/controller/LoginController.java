package com.tliasweb.controller;

import com.tliasweb.pojo.Emp;
import com.tliasweb.pojo.Result;
import com.tliasweb.service.EmpService;
import com.tliasweb.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ling
 * @desc: 登录
 * @date 2024/3/16 22:21
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    EmpService empService;
    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}",emp);
        Emp e = empService.login(emp);

        if (e!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
