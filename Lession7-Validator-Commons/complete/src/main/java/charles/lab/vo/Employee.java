package charles.lab.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import charles.lab.valid.group.Insert;
import charles.lab.valid.group.Update;

public class Employee {
  
  @NotNull(groups = {Insert.class,Update.class})
  private String name;
  
  @Min(value=18,groups= {Insert.class})
  private int age;
  
  @NotNull(groups = {Update.class})
  private String address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
  
  
}
