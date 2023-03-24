package com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.mapper;

import com.qnq.doublecreamapi.domain.model.DoubleCream;
import com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.entity.DoubleCreamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoubleCreamPersistenceMapper {
  
  DoubleCream entityToModel(DoubleCreamEntity doubleCream);
  DoubleCreamEntity modelToEntity(DoubleCream doubleCream);
  
}
