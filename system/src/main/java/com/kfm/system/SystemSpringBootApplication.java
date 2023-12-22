package com.kfm.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author yangbohan
 * @Date 2023/12/19 22:40
 */
@SpringBootApplication(scanBasePackages = {"com.kfm.system", "com.kfm.shop.comment"})
@MapperScan("com.kfm.system.mapper")
@EnableAspectJAutoProxy
public class SystemSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemSpringBootApplication.class);
        System.out.println("SystemSpringBootApplication 启动成功");
    }
}
