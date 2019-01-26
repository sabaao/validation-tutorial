package charles.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ch.myr.service.EmployeeService;

import charles.lab.valid.group.Insert;
import charles.lab.valid.group.Update;
import charles.lab.vo.Employee;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/insertemployee", method = RequestMethod.POST)
	public String insertEmployee(@Validated({ Insert.class }) @RequestBody Employee e) {
		return "success";
	}

	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	public String updateEmployee(@Validated({ Update.class }) @RequestBody Employee e) {
		return "success";
	}

	@RequestMapping(value = "/myrvalidated/validInsert/fail")
	public String myrvalidatedValidInsertFail() {
		Employee e = new Employee();
		return service.validInsert(e);
	}
	
	@RequestMapping(value = "/myrvalidated/validInsert/success")
	public String myrvalidatedValidInsertSuccss() {
		Employee e = new Employee();
		e.setName("charles");
		e.setAge(20);
		return service.validInsert(e);
	}
	
	@RequestMapping(value = "/myrvalidated/validTwoInsert/fail")
	public String myrvalidatedvalidTwoInsertFail() {
		Employee e = new Employee();
		e.setName("charles");
		e.setAge(20);
		
		Employee e2 = new Employee();
		return service.validTwoInsert(e, e2);
	}
	
	@RequestMapping(value = "/myrvalidated/validTwoInsert/success")
	public String myrvalidatedvalidTwoInsertSuccess() {
		Employee e = new Employee();
		e.setName("charles");
		e.setAge(20);
		
		Employee e2 = new Employee();
		e2.setName("charles");
		e2.setAge(20);
		return service.validTwoInsert(e, e2);
	}
	
	@RequestMapping(value = "/myrvalidated/validTwoGroup/fail")
	public String myrvalidatedvalidTwoGroupFail() {
		Employee e = new Employee();
		e.setName("charles");
		e.setAge(20);
		return service.validTwoGroup(e);
	}
	
	@RequestMapping(value = "/myrvalidated/validTwoGroup/success")
	public String myrvalidatedvalidTwoGroupSuccess() {
		Employee e = new Employee();
		e.setName("charles");
		e.setAge(20);
		e.setAddress("taipei");
		return service.validTwoGroup(e);
	}
}
