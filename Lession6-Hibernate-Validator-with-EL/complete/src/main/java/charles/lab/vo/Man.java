package charles.lab.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Man {
  @Size(min = 2, max = 14,
      message = "Name '${validatedValue}' must be between {min} and {max} characters long")
  private String name;

  @Min(value = 2, message = "There must be at least {value} seat${value > 1 ? 's' : ''}")
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
