package charles.lab.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import charles.lab.valid.group.Insert;
import charles.lab.valid.group.Update;
import charles.lab.vo.Employee;

@RestController
@RequestMapping("employee")
public class EmployeeController {
  @RequestMapping(value = "/insertemployee",method = RequestMethod.POST)
  public String insertEmployee(@Validated({Insert.class}) @RequestBody Employee e) {
    return "success";
  }
  
  @RequestMapping(value = "/updateemployee",method = RequestMethod.POST)
  public String updateEmployee(@Validated({Update.class}) @RequestBody Employee e) {
    return "success";
  }
}
