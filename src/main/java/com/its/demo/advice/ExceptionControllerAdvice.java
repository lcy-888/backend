package com.its.demo.advice;

import com.its.demo.domain.ResponseCodeEnum;
import com.its.demo.domain.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 杨金刚
 * @date 2020/8/9 7:41
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    /**
     * 处理参数验证错误
     *
     * @param e 异常
     * @return ResponseVO<String>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        logger.error(objectError.getDefaultMessage());

        return new ResponseVO(ResponseCodeEnum.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    /**
     * 处理运行时错误
     * @param e 异常
     * @return ResponseVO
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseVO runtimeExceptionHandler(RuntimeException e) {
        logger.error(e.getMessage());

        return new ResponseVO(ResponseCodeEnum.FAILED, e.getMessage());
    }

    /**
     * 处理以上两个处理器处理无法处理的错误
     *
     * @param e 异常
     * @return ResponseVO<String>
     */
    @ExceptionHandler(Exception.class)
    public ResponseVO<String> commonExceptionHandler(Exception e) {
        logger.error(e.getMessage());

        return new ResponseVO(ResponseCodeEnum.ERROR, e.getMessage());
    }
}
