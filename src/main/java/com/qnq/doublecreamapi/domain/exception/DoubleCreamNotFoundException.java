package com.qnq.doublecreamapi.domain.exception;

public class DoubleCreamNotFoundException extends RuntimeException{
  
  public DoubleCreamNotFoundException(Long id) {
    super("Producto con id " + id + " no encontrado");
  }
  
}
