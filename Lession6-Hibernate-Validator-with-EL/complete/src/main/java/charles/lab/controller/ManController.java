package charles.lab.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import charles.lab.vo.Man;

@RestController
@RequestMapping("/man")
public class ManController {
  @RequestMapping(value = "/insertman",method = RequestMethod.POST)
  public String insertMan(@Validated @RequestBody Man m) {
    return "success";
  }
}
