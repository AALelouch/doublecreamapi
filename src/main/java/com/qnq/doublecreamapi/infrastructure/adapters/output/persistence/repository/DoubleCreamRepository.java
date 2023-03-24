package com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.repository;

import com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.entity.DoubleCreamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoubleCreamRepository extends JpaRepository<DoubleCreamEntity, Long> {
}
