package com.ch.myr.service;

import charles.lab.vo.Employee;

public interface EmployeeService {
	public String validInsert(Employee e);
	
	public String validTwoInsert(Employee e1,Employee e2);
	
	public String validTwoGroup(Employee e);
}
