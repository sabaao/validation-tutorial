package charles.lab.exception.handle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import charles.lab.util.ValidatorUtils;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandle {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handle(MethodArgumentNotValidException ex){
    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();
    FieldError f = fieldErrors.stream().findFirst().get();
    String errorCode = ValidatorUtils.getErrorCode("", f.getField(),f.getCode());
    
    return new ResponseEntity(errorCode,HttpStatus.BAD_GATEWAY);
  }
}
