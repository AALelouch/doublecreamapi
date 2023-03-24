package com.qnq.doublecreamapi.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCream {
  
  private Long id;
  private String provider;
  private Double quantity;
  private LocalDateTime dateOfArrive;
  private Double cost;
  private Double price;
  
}
