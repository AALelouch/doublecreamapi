package com.qnq.doublecreamapi.infrastructure.adapters.output.persistence;

import com.qnq.doublecreamapi.application.ports.output.DoubleCreamOutputPort;
import com.qnq.doublecreamapi.domain.model.DoubleCream;
import com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.entity.DoubleCreamEntity;
import com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.mapper.DoubleCreamPersistenceMapper;
import com.qnq.doublecreamapi.infrastructure.adapters.output.persistence.repository.DoubleCreamRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DoubleCreamPersistenceAdapter implements DoubleCreamOutputPort {
  
  private DoubleCreamRepository doubleCreamRepository;
  private DoubleCreamPersistenceMapper doubleCreamPersistenceMapper;
  
  public DoubleCreamPersistenceAdapter(DoubleCreamRepository doubleCreamRepository, DoubleCreamPersistenceMapper doubleCreamPersistenceMapper) {
    this.doubleCreamRepository = doubleCreamRepository;
    this.doubleCreamPersistenceMapper = doubleCreamPersistenceMapper;
  }
  
  @Override
  public void create(final DoubleCream doubleCream) {
    doubleCreamRepository.save(doubleCreamPersistenceMapper.modelToEntity(doubleCream));
  }
  
  @Override
  public List<DoubleCream> ReadAll() {
    return doubleCreamRepository.findAll().stream()
               .map(doubleCreamPersistenceMapper::entityToModel).collect(Collectors.toList());
  }
  
  @Override
  public Optional<DoubleCream> updateById(final DoubleCream doubleCream, final Long id) {
  
    if (findByIdDoubleCream(id).isEmpty()){
      return Optional.empty();
    }
    
    DoubleCreamEntity doubleCreamEntity = doubleCreamPersistenceMapper.modelToEntity(doubleCream);
    doubleCreamEntity.setId(id);
    doubleCreamRepository.save(doubleCreamEntity);
    
    return Optional.of(doubleCream);
  }
  
  @Override
  public Optional<DoubleCream> deleteById(final Long id) {
    
    Optional<DoubleCreamEntity> doubleCreamEntity = findByIdDoubleCream(id);
    
    if (doubleCreamEntity.isEmpty()){
      return Optional.empty();
    }
    
    doubleCreamRepository.deleteById(id);
  
    return Optional.of(doubleCreamPersistenceMapper.entityToModel(doubleCreamEntity
                                                                      .get()));
  }
  
  private Optional<DoubleCreamEntity> findByIdDoubleCream(Long id){
    return doubleCreamRepository.findById(id);
  }
}
