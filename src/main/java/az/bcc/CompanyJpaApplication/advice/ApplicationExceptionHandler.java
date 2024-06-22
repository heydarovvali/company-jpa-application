package az.bcc.CompanyJpaApplication.advice;

import az.bcc.CompanyJpaApplication.entity.Message;
import az.bcc.CompanyJpaApplication.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Message> handleNotFoundException(NotFoundException exception){
    return ResponseEntity.status(404).body(new Message(exception.getMessage()));

  }
}
