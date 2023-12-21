package com.kfm.shop.goods.controller;

import io.swagger.annotations.*;
import org.apiguardian.api.API;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yangbohan
 * @Date 2023/12/19 20:03
 */
@RestController
@Api(value = "HelloController", description = "测试Controller")
public class HelloController {
    @GetMapping("/hello")

    @ApiOperation(value = "hello接口", notes = "测试接口")
    @ApiResponses(
            @ApiResponse(code = 200, message = "成功", response = String.class,
                    examples = @Example(
                            @ExampleProperty(value = "hello world", mediaType = "application/text")
                    ))
    )
    public String hello() {
        return "hello world";
    }

    @PostMapping("/hello")
    public String helloPost(String name) {
        return "hello "+name;
    }
}
