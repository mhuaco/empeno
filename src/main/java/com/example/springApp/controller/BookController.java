package com.example.springApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springApp.model.Book;
import com.example.springApp.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;

    @GetMapping("/all")
    public List<Book> getInventory() {
    	return service.getInventory();
    }
    @PostMapping("/withDrawal/{amount}")
    public Book withDrawal( int bookId,@PathVariable int amount){
    	
    	return service.withDrawal(bookId, amount);
    }
    @PostMapping("/deposit/{amount}")
    public Book depQuantity( int bookId,@PathVariable int amount){
    	
    	return service.depQuantity(bookId, amount);
    }
	
	@PostMapping("/save")
	public String saveBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	@GetMapping("/searchBook/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		return service.getBook(bookId);
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public List<Book> deleteBook(@PathVariable int bookId) {
		return service.removeBook(bookId);
		
	}
	
	
}
