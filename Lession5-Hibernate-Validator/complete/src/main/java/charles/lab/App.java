package charles.lab;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class App 
{
    public static void main( String[] args )
    {
    	User user = new User();
    	user.setWorking(true);
    	user.setAboutMe("Its all about me!");
    	user.setAge(50);
    	
    	//please valid user here
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	
    	Set<ConstraintViolation<User>> violations = validator.validate(user);
    	for(ConstraintViolation<User> violation:violations) {
    		System.out.println("message:" + violation.getMessage());
    		System.out.println("property path:" + violation.getPropertyPath().toString());
    		System.out.println("name:" + violation.getConstraintDescriptor().getAnnotation().annotationType().getName());
    	}
    }
}
