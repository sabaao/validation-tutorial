package charles.lab.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Book {
	
	@NotNull(message="book name can't be null")
	private String name;
	
	@Max(value=500,message="price can not more than 500")
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
