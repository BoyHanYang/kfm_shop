package com.kfm.shop.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author yangbohan
 * @Date 2023/12/19 21:34
 */
@Data
@Accessors(chain = true)
public class Result extends HashMap<String, Object> implements Serializable {
    private static Result getInstance(Integer code){
        return new Result().put("timestamp", System.currentTimeMillis()).put("code", code);
    }
    public static Result ok() {
        return getInstance(200).put("message", "操作成功");
    }

    public static Result ok(Object data) {
        return getInstance(200).put("message", "操作成功").put("data", data);
    }


    public static Result error(String message) {
        return getInstance(500).put("message", message);
    }
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
