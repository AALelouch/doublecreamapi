package com.qnq.doublecreamapi.infrastructure.adapters.input.rest;

import com.qnq.doublecreamapi.application.ports.input.CrudDoubleCreamUseCase;
import com.qnq.doublecreamapi.application.ports.input.SendEmailDoubleCreamDetailsUseCase;
import com.qnq.doublecreamapi.infrastructure.adapters.input.rest.data.request.DoubleCreamRequest;
import com.qnq.doublecreamapi.infrastructure.adapters.input.rest.data.response.DoubleCreamResponse;
import com.qnq.doublecreamapi.infrastructure.adapters.input.rest.mapper.DoubleCreamRestMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/doubleCream/")
public class DoubleCreamRestAdapter {

  private CrudDoubleCreamUseCase crudDoubleCreamUseCase;
  private SendEmailDoubleCreamDetailsUseCase sendEmailDoubleCreamDetailsUseCase;
  private DoubleCreamRestMapper doubleCreamRestMapper;
  
  public DoubleCreamRestAdapter(final CrudDoubleCreamUseCase crudDoubleCreamUseCase,
      final SendEmailDoubleCreamDetailsUseCase sendEmailDoubleCreamDetailsUseCase,
      final DoubleCreamRestMapper doubleCreamRestMapper) {
    this.crudDoubleCreamUseCase = crudDoubleCreamUseCase;
    this.sendEmailDoubleCreamDetailsUseCase = sendEmailDoubleCreamDetailsUseCase;
    this.doubleCreamRestMapper = doubleCreamRestMapper;
  }
  
  @GetMapping
  public ResponseEntity<List<DoubleCreamResponse>> readAllDoubleCreams(){
    return ResponseEntity.ok(crudDoubleCreamUseCase.ReadAll()
                                 .stream().map(doubleCreamRestMapper::modelToResponse)
                                 .collect(Collectors.toList()));
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createDoubleCream(
      @RequestBody DoubleCreamRequest doubleCreamRequest){
    
    crudDoubleCreamUseCase.create(doubleCreamRestMapper.requestToModel(doubleCreamRequest));
  }
  
  @PutMapping("update/{id}")
  public ResponseEntity<DoubleCreamResponse> updateByIdDoubleCream(
      @PathVariable Long id, @RequestBody DoubleCreamRequest doubleCreamRequest){
    
    return
        ResponseEntity.ok(
            doubleCreamRestMapper.modelToResponse(
            crudDoubleCreamUseCase.updateById(
                doubleCreamRestMapper.requestToModel(doubleCreamRequest), id)));
    
  }
  
  @DeleteMapping("delete/{id}")
  public ResponseEntity<DoubleCreamResponse> deleteByIdDoubleCream(
      @PathVariable Long id){
    
    return
        ResponseEntity.ok(
            doubleCreamRestMapper.modelToResponse(
                crudDoubleCreamUseCase.deleteById(id)));
    
  }
  
  @PostMapping("sendSummary/{to}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void sendSummaryOfAllDoubleCream(@PathVariable String to){
    sendEmailDoubleCreamDetailsUseCase.sendEmail(to);
  }
  
}
