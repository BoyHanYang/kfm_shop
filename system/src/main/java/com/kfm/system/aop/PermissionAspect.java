package com.kfm.system.aop;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.kfm.shop.comment.annotation.Permission;
import com.kfm.shop.comment.ex.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author yangbohan
 * @Date 2023/12/22 21:30
 */

@Aspect // 标记为切面类
@Component // 加入到 spring 容器中
@Slf4j
public class PermissionAspect {

    @Autowired
    private RedisTemplate redisTemplate;
    @Before("@annotation(permission)")
    public void before(JoinPoint jp, Permission permission) {
        log.info("权限拦截");
        // 需要的权限
        String value = permission.value();
        log.info(jp.getSignature().getName() + "需要的权限：" + value);
        // 获取请求头中的 token
        String token = getToken();
        // 根据 token 获取用户权限
        List<String> list = (List<String>) redisTemplate.opsForValue().get(token + "_permissions");

        if (!ObjectUtils.isEmpty(list) && list.contains(value)) {
            log.info("权限校验通过");
        } else {
            log.info("权限校验失败");
            throw new ServiceException("未授权");
        }

    }

    private String getToken() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new RuntimeException("requestAttributes is null");
        }
        // 获取请求头中的 token
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String header = request.getHeader("Authorization");
        return header;
    }
}