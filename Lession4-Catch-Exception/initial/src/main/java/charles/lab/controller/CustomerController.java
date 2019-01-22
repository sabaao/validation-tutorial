package charles.lab.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import charles.lab.vo.Customer;

@RestController
@RequestMapping("/")
public class CustomerController {
  @RequestMapping(value = "/customer",method = RequestMethod.POST)
  public Customer addCustomer(@RequestBody Customer c) {
    return c;
  }
}
