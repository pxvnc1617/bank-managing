package com.example.bank_coding.exceptionHandler;

import com.example.bank_coding.dto.ResponseDto;
import com.example.bank_coding.exceptionHandler.ex.CustomValidationException;
import com.example.bank_coding.exceptionHandler.ex.CustomApiException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.*;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException customApiException) {
        logger.error(customApiException.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, customApiException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationApiException(CustomValidationException customValidationException) {
        logger.error(customValidationException.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, customValidationException.getMessage(), customValidationException.getErrorMap()), HttpStatus.BAD_REQUEST);
    }

}
