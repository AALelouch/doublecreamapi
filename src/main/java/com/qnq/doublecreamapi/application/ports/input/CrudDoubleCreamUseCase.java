package com.qnq.doublecreamapi.application.ports.input;

import com.qnq.doublecreamapi.domain.model.DoubleCream;
import java.util.List;

public interface CrudDoubleCreamUseCase {

  void create(DoubleCream doubleCream);
  List<DoubleCream> ReadAll();
  DoubleCream updateById(DoubleCream doubleCream, Long id);
  DoubleCream deleteById(Long id);

}
