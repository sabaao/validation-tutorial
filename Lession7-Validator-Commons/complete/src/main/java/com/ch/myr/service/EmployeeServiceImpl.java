package com.ch.myr.service;

import org.springframework.stereotype.Service;

import com.ch.myr.validator.annotations.MyrValidated;

import charles.lab.valid.group.Insert;
import charles.lab.valid.group.Update;
import charles.lab.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@MyrValidated({Insert.class})
	@Override
	public String validInsert(Employee e) {
		return "success";
	}
	
	@MyrValidated({Insert.class})
	@Override
	public String validTwoInsert(Employee e1, Employee e2) {
		return "success";
	}
	
	@MyrValidated({Insert.class,Update.class})
	@Override
	public String validTwoGroup(Employee e) {
		return "success";
	}

}
