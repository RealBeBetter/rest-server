package com.example.restserver.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wei.song
 * @since 2023/7/3 0:05
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理方法参数无效异常
     *
     * @param ex ex
     * @return {@link Return}<{@link Void}>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Return<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder();
        BindingResult bindingResult = ex.getBindingResult();
        int length = bindingResult.getFieldErrors().size();
        for (int i = 0; i < length; i++) {
            FieldError fieldError = bindingResult.getFieldErrors().get(i);
            errorMessage.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage());
            if (i != length - 1) {
                errorMessage.append(",");
            }
        }
        return Return.failed(errorMessage.toString());
    }

    /**
     * 处理非法参数异常
     *
     * @param ex ex
     * @return {@link Return}<{@link Void}>
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Return<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
        StringBuilder errorMessage = new StringBuilder("参数异常:");
        String message = ex.getMessage();
        String result = errorMessage.append(message).toString();
        return Return.failed(result);
    }
}
