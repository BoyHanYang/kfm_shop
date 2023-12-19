package com.kfm.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author yangbohan
 * @Date 2023/12/19 22:40
 */
@SpringBootApplication
@MapperScan("com.kfm.system.mapper")
public class SystemSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemSpringBootApplication.class);
        System.out.println("SystemSpringBootApplication 启动成功");
    }
}
