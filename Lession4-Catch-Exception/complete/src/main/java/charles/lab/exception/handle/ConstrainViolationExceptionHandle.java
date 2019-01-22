package charles.lab.exception.handle;

import java.util.ArrayList;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConstrainViolationExceptionHandle {

  @ExceptionHandler
  public ResponseEntity<String> handle(ConstraintViolationException exception){
    ArrayList<ConstraintViolation<?>> list = new ArrayList<>(exception.getConstraintViolations());
    ConstraintViolation c = list.stream().findFirst().get();
    String message = c.getMessage();
    String property =c.getPropertyPath().toString();
    String name = c.getConstraintDescriptor().getAnnotation().annotationType().getName();
    String result = message + " " + property + " " + name;
    
    return new ResponseEntity<String>(result, HttpStatus.OK);
  }
}
