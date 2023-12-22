package com.kfm.system.interceptor;

import io.lettuce.core.api.coroutines.RedisTransactionalCoroutinesCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yangbohan
 * @Date 2023/12/22 20:07
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("Authorization");
        if (StringUtils.hasText(header)){
            Object o = redisTemplate.opsForValue().get(header);
            if (ObjectUtils.isEmpty(o)){
                throw new RuntimeException("登录已过期");
            }
            return true;
        }
        throw new RuntimeException("请先登录");
    }
}
