package com.qnq.doublecreamapi.infrastructure.adapters.input.rest.data.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCreamResponse {
  
  private Long id;
  private String provider;
  private Double quantity;
  private LocalDateTime dateOfArrive;
  private Double cost;
  private Double price;
  
}
