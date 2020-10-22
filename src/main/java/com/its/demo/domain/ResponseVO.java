package com.its.demo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请求返回视图类
 *
 * @author 杨金刚
 * @date 2020/4/21 7:37
 */
@Data
public class ResponseVO<T> {
    @ApiModelProperty(value = "返回码:0-成功;-1-接口响应失败;-2-参数校验失败;-4-未找到API;-5-内部错误")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String msg;
    @ApiModelProperty(value = "数据载荷")
    private T data;

    public ResponseVO(ResponseCodeEnum code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public ResponseVO(T data) {
        this(ResponseCodeEnum.SUCCESS, data);
    }
}
