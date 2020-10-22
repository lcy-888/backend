package com.its.demo.domain;

import lombok.Getter;

/**
 * 响应码
 *
 * @author 杨金刚
 * @date 2020/8/9 8:01
 */
@Getter
public enum ResponseCodeEnum {
    SUCCESS(0, "操作成功"),
    FAILED(-1, "接口响应失败"),
    VALIDATE_FAILED(-2, "参数校验失败"),
    NOT_FOUND(-4, "未找到API(404)"),
    ERROR(-5, "内部错误(500)");

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;

    ResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
