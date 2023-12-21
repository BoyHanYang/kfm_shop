package com.kfm.shop.goods.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author yangbohan
 * @Date 2023/12/19 15:13
 */
@SpringBootApplication(scanBasePackages = {"com.kfm.shop.goods", "com.kfm.shop.comment"})
@MapperScan("com.kfm.shop.goods.mapper")
public class GoodsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsSpringBootApplication.class, args);
        System.out.println("GoodsSpringBootApplication 项目启动成功");
    }
}
