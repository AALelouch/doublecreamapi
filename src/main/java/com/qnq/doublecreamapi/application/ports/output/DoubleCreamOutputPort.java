package com.qnq.doublecreamapi.application.ports.output;

import com.qnq.doublecreamapi.domain.model.DoubleCream;
import java.util.List;
import java.util.Optional;

public interface DoubleCreamOutputPort {
  
  void create(DoubleCream doubleCream);
  List<DoubleCream> ReadAll();
  Optional<DoubleCream> updateById(DoubleCream doubleCream, Long id);
  Optional<DoubleCream> deleteById(Long id);
  
}
