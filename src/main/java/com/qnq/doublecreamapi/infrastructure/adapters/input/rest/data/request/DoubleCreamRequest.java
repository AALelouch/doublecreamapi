package com.qnq.doublecreamapi.infrastructure.adapters.input.rest.data.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCreamRequest {
  
  private String provider;
  private Double quantity;
  private LocalDateTime dateOfArrive;
  private Double cost;
  private Double price;
  
}
