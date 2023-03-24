package com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "double_cream")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCreamEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String provider;
  private Double quantity;
  private LocalDateTime dateOfArrive;
  private Double cost;
  private Double price;
  
}
