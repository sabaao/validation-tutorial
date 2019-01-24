package charles.lab.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * this is customer class.
 * @author charles
 *
 */
public class Customer {
  private String name;
  
  private int age;

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
  
  
}