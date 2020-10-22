package com.its.demo.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.its.demo.domain.ResponseCodeEnum;
import com.its.demo.domain.ResponseVO;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 杨金刚
 * @date 2020/4/21 8:17
 */
@RestControllerAdvice(basePackages = "com.its.demo")
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getGenericParameterType().equals(ResponseVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object data,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {


        // 处理404（有时不好使）
        if(methodParameter.getContainingClass().equals(BasicErrorController.class)) {
            return new ResponseVO(ResponseCodeEnum.NOT_FOUND, null);
        }

        // 如果发生异常
        if(methodParameter.getContainingClass().equals(ExceptionControllerAdvice.class)) {
            return data;
        }

        // 如果返回JSON串
        if(methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResponseVO(data));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("返回String类型错误");
            }
        }

        // 包装正常返回数据
        return new ResponseVO(data);
    }
}
