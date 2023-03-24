package com.qnq.doublecreamapi.domain.service;

import com.qnq.doublecreamapi.application.ports.input.CrudDoubleCreamUseCase;
import com.qnq.doublecreamapi.application.ports.input.SendEmailDoubleCreamDetailsUseCase;
import com.qnq.doublecreamapi.application.ports.output.DoubleCreamEmailSenderPort;
import com.qnq.doublecreamapi.application.ports.output.DoubleCreamOutputPort;
import com.qnq.doublecreamapi.domain.exception.DoubleCreamNotFoundException;
import com.qnq.doublecreamapi.domain.model.DoubleCream;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DoubleCreamService implements CrudDoubleCreamUseCase,
                                               SendEmailDoubleCreamDetailsUseCase {
  
  private DoubleCreamOutputPort doubleCreamOutputPort;
  private DoubleCreamEmailSenderPort doubleCreamEmailSenderPort;
  
  public DoubleCreamService(DoubleCreamOutputPort doubleCreamOutputPort,
      DoubleCreamEmailSenderPort doubleCreamEmailSenderPort) {
    this.doubleCreamOutputPort = doubleCreamOutputPort;
    this.doubleCreamEmailSenderPort = doubleCreamEmailSenderPort;
  }
  
  @Override
  public void create(DoubleCream doubleCream) {
    doubleCreamOutputPort.create(doubleCream);
  }
  
  @Override
  public List<DoubleCream> ReadAll() {
    return doubleCreamOutputPort.ReadAll();
  }
  
  @Override
  public DoubleCream updateById(DoubleCream doubleCream, Long id) {
    return doubleCreamOutputPort.updateById(doubleCream, id).orElseThrow(
        () -> new DoubleCreamNotFoundException(doubleCream.getId())
    );
  }
  
  @Override
  public DoubleCream deleteById(Long id) {
    return doubleCreamOutputPort.deleteById(id)
               .orElseThrow(() -> new DoubleCreamNotFoundException(id));
  }
  
  @Override
  public void sendEmail(String to) {
    doubleCreamEmailSenderPort.sendEmail(to);
  }
}
