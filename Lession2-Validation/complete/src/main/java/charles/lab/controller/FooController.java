package charles.lab.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import charles.lab.vo.Foo;

@RestController
@RequestMapping("/foo")
public class FooController {
  @RequestMapping(value = "/getFoo",method = RequestMethod.POST)
  public String addCustomer(@Validated @RequestBody Foo foo,BindingResult bindingResult) {
    if(bindingResult.hasErrors()){
      for (FieldError fieldError : bindingResult.getFieldErrors()) {
          System.out.println("default message:" + fieldError.getDefaultMessage());
          System.out.println("object name:" + fieldError.getObjectName());
          System.out.println("code:" + fieldError.getCode());
      }
      return "fail";
  }
  return "success";

  }
}
