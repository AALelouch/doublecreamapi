package com.qnq.doublecreamapi.infrastructure.adapters.output.emailsender.mapper;

import com.qnq.doublecreamapi.domain.email.DoubleCreamDetailsEmail;
import com.qnq.doublecreamapi.domain.model.DoubleCream;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoubleCreamEmailMapper {
  
  DoubleCreamDetailsEmail doubleCreamToDoubleCreamDetailsEmail(DoubleCream doubleCream);
  
}
