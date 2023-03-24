package com.qnq.doublecreamapi.infrastructure.adapters.output.emailsender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qnq.doublecreamapi.application.ports.output.DoubleCreamEmailSenderPort;
import com.qnq.doublecreamapi.application.ports.output.DoubleCreamOutputPort;
import com.qnq.doublecreamapi.domain.email.DoubleCreamDetailsEmail;
import com.qnq.doublecreamapi.infrastructure.adapters.output.emailsender.mapper.DoubleCreamEmailMapper;
import java.time.LocalDateTime;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class EmailSenderAdapter implements DoubleCreamEmailSenderPort {
  
  private final JavaMailSender javaMailSender;
  private final SpringTemplateEngine springTemplateEngine;
  private final String TEMPLATE = "DoubleCreamEmail.html";
  private final String SUBJECT = "Summary of double cream inventory";
  private final ObjectMapper mapper;
  private final DoubleCreamOutputPort doubleCreamOutputPort;
  
  private final DoubleCreamEmailMapper doubleCreamEmailMapper;
  
  public EmailSenderAdapter(final JavaMailSender javaMailSender,
      final SpringTemplateEngine springTemplateEngine,
      final ObjectMapper mapper, final DoubleCreamOutputPort doubleCreamOutputPort,
      final DoubleCreamEmailMapper doubleCreamEmailMapper) {
    
    this.javaMailSender = javaMailSender;
    this.springTemplateEngine = springTemplateEngine;
    this.mapper = mapper;
    this.doubleCreamOutputPort = doubleCreamOutputPort;
    this.doubleCreamEmailMapper = doubleCreamEmailMapper;
  }
  
  @Override
  public void sendEmail(String to) {
    
    DoubleCreamDetailsEmail doubleCreamDetailsEmail = new DoubleCreamDetailsEmail();
    doubleCreamDetailsEmail.setDateOfScan(LocalDateTime.now());
    doubleCreamDetailsEmail.setAllDoubleCream(doubleCreamOutputPort.ReadAll());
    
    javaMailSender.send(buildEmail(to,
        buildEmailBody(doubleCreamDetailsEmail)));
    
  }
  
  private MimeMessage buildEmail(String to, String htmlBody) {
    
    MimeMessage message = javaMailSender.createMimeMessage();
    
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper
                                            (message);
      
      messageHelper.setTo(to);
      messageHelper.setFrom("No-Reply");
      messageHelper.setSubject(SUBJECT);
      messageHelper.setText(htmlBody, true);
      
    }catch (MessagingException messagingException){
      System.out.println(messagingException.getMessage());
    }
    
    return message;
    
  }
  
  private String buildEmailBody(DoubleCreamDetailsEmail doubleCreamDetailsEmail) {
    
    
    Map<String, Object> model = mapper.convertValue(doubleCreamDetailsEmail, Map.class);
    
    Context thymeleafContext = new Context();
    thymeleafContext.setVariables(model);
    String htmlBody = springTemplateEngine.process(TEMPLATE, thymeleafContext);
    
    return htmlBody;
    
  }
  
}
