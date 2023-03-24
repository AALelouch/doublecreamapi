package com.qnq.doublecreamapi.domain.exception.advice.exceptionmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class DoubleCreamExceptionModel {
  
  private String message;
  private String httpError;
  
  public DoubleCreamExceptionModel(final String message, final String httpError) {
    this.message = message;
    this.httpError = httpError;
  }
  
  public DoubleCreamExceptionModel() {
  }
}
