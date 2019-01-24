package charles.lab.exception.handle;

import java.util.ArrayList;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import charles.lab.util.ValidatorUtils;

@ControllerAdvice
public class ConstrainViolationExceptionHandle {

  @ExceptionHandler
  public ResponseEntity<String> handle(ConstraintViolationException exception){
    ArrayList<ConstraintViolation<?>> list = new ArrayList<>(exception.getConstraintViolations());
    ConstraintViolation c = list.stream().findFirst().get();
    String message = c.getMessage();
    String property =c.getPropertyPath().toString();
    String name = ValidatorUtils.getClassName(c.getConstraintDescriptor().getAnnotation().annotationType().getName());
    String result = ValidatorUtils.getErrorCode("", property, name);
    
    return new ResponseEntity<String>(result, HttpStatus.OK);
  }
}
