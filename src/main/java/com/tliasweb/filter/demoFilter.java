package com.tliasweb.filter;

import com.alibaba.fastjson2.JSONObject;
import com.google.gson.JsonObject;
import com.tliasweb.pojo.Result;
import com.tliasweb.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author ling
 * @desc:
 * @date 2024/3/19 17:31
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class demoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("拦截器初始化开始执行");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();
        log.info("请求的url:{}",url);

        if (url.contains("login")){
            log.info("登录放行..");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String jwt = request.getHeader("token");

        if (!StringUtils.hasLength(jwt)){
            log.info("请求头为空,返回未登录信息");
            Result error=Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("jwt令牌解析失败");
            Result error=Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        log.info("jwt令牌合法,放行通过");
        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {
        System.out.println("拦截器销毁");
        Filter.super.destroy();
    }
}
