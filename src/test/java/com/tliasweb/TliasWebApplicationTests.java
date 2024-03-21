package com.tliasweb;

import com.tliasweb.controller.DeptController;
import com.tliasweb.service.impl.DeptServiceImpl;
import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootTest
class TliasWebApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void uuidTest() {
        for (int i = 0; i < 100; i++) {
            String uuid= UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testGenJwt(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tom");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"zeros").setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)).compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Jws<Claims> zeros = Jwts.parser().setSigningKey("zeros")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQ" +
                        "iOjEsImV4cCI6MTcxMDg0MDIyMH0.BxpyH3R52JPskX0i2MZgCilBfBazd-IMlgWAR7iegX4");
//
        System.out.println(zeros);
    }

    @Test
    public void testGetBean(){
        DeptServiceImpl bean1 = (DeptServiceImpl) applicationContext.getBean("deptServiceImpl");

        DeptServiceImpl bean2 = applicationContext.getBean(DeptServiceImpl.class);

        DeptServiceImpl bean3 = applicationContext.getBean("deptServiceImpl",DeptServiceImpl.class);

        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);



    }
}
