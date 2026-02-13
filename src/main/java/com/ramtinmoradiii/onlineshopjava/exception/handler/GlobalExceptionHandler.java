package com.ramtinmoradiii.onlineshopjava.exception.handler;

import com.ramtinmoradiii.onlineshopjava.dto.common.ApiResponse;
import com.ramtinmoradiii.onlineshopjava.dto.common.ValidationError;
import com.ramtinmoradiii.onlineshopjava.exception.AlreadyExistsException;
import com.ramtinmoradiii.onlineshopjava.exception.ResourceNotFoundException;
import com.ramtinmoradiii.onlineshopjava.exception.TokenRefreshException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleNotFound(ResourceNotFoundException ex) {
        log.warn("Resource Not Found: {}", ex.getMessage());
        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse<Void> handleAccessDenied(AccessDeniedException ex) {
        log.warn("Security Alert - Access Denied: {}", ex.getMessage());
        return ApiResponse.error("شما دسترسی لازم برای این عملیات را ندارید.");
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse<Void> handleBadCredentials(BadCredentialsException ex) {
        log.warn("Login Failed: Bad Credentials");
        return ApiResponse.error("نام کاربری یا رمز عبور اشتباه است.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationError> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.add(new ValidationError(error.getField(), error.getDefaultMessage()))
        );

        return ApiResponse.validationError(errors);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse<Void> handleAlreadyExists(AlreadyExistsException ex) {
        log.warn("Duplicate Entry: {}", ex.getMessage());
        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(TokenRefreshException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse<Void> handleExpireRefreshToken(TokenRefreshException ex) {
        log.error("Token Refresh Failed: {}", ex.getMessage());
        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleGeneralError(Exception ex) {
        log.error("Unhandled Internal Server Error: ", ex);
        return ApiResponse.error("خطای داخلی سرور رخ داده است. لطفاً با پشتیبانی تماس بگیرید.");
    }
}