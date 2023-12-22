package com.kfm.shop.comment.ex;

/**
 * @Author yangbohan
 * @Date 2023/12/22 21:16
 */

public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }



}