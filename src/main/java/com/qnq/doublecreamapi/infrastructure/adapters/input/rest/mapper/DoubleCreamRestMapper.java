package com.qnq.doublecreamapi.infrastructure.adapters.input.rest.mapper;

import com.qnq.doublecreamapi.domain.model.DoubleCream;
import com.qnq.doublecreamapi.infrastructure.adapters.input.rest.data.request.DoubleCreamRequest;
import com.qnq.doublecreamapi.infrastructure.adapters.input.rest.data.response.DoubleCreamResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoubleCreamRestMapper {
  
  DoubleCreamResponse modelToResponse(DoubleCream doubleCream);
  DoubleCream requestToModel(DoubleCreamRequest doubleCreamRequest);
  
}
