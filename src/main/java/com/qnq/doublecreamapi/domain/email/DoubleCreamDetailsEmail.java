package com.qnq.doublecreamapi.domain.email;

import com.qnq.doublecreamapi.domain.model.DoubleCream;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCreamDetailsEmail {
  
  private List<DoubleCream> allDoubleCream;
  private LocalDateTime dateOfScan;
  
}
