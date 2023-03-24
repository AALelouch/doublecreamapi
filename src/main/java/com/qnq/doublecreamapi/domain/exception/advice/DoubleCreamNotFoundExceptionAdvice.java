package com.qnq.doublecreamapi.domain.exception.advice;

import com.qnq.doublecreamapi.domain.exception.DoubleCreamNotFoundException;
import com.qnq.doublecreamapi.domain.exception.advice.exceptionmodel.DoubleCreamExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DoubleCreamNotFoundExceptionAdvice {
  
  @ExceptionHandler(DoubleCreamNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public DoubleCreamExceptionModel handleDoubleCreamNotFoundException(DoubleCreamNotFoundException e){
    return new DoubleCreamExceptionModel(e.getMessage(), "404-Not-Found");
  }
  
  
}
