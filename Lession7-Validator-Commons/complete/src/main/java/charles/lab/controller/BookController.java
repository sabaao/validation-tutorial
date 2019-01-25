package charles.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ch.myr.service.BookService;
import com.ch.myr.validator.annotations.MyrValidated;

import charles.lab.vo.Book;
import charles.lab.vo.Customer;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/getBookSuccess")
	public String success() {
		Book b = new Book();
		b.setName("bookname");
		b.setPrice(399);
		return bookService.valid(b);
	}
	
	@RequestMapping("/getBookFail")
	public String fail() {
		Book b = new Book();
		return bookService.valid(b);
	}
}
