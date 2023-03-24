package com.qnq.doublecreamapi.application.ports.input;

import com.qnq.doublecreamapi.domain.model.DoubleCream;

public interface SendEmailDoubleCreamDetailsUseCase {
  void sendEmail(String to);
  
}
