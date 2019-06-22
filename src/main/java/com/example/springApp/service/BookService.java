package com.example.springApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springApp.dao.BookRepository;
import com.example.springApp.model.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public String saveBook(Book book) {
		repository.save(book);
		return "book save with id " + book.getBookId();
	}

	public Book getBook(int bookId) {
		return repository.findById(bookId).orElse(null);
	}

	public List<Book> removeBook(int bookId) {
		repository.deleteById(bookId);
		return repository.findAll();
	}

	public List<Book> getInventory() {
		return repository.findAll();
	}

	public Book withDrawal(int bookId, int quantity) {

		for (int i = 0; i < getInventory().size(); i++) {

			Book B = getInventory().get(i);

			if (B.getBookId() == bookId) {
				int instock = B.getAmount() - quantity;
				B.setAmount(instock);
				repository.save(B);

			}
		}
		return repository.findById(bookId).orElse(null);

	}
	public Book depQuantity(int bookId, int quantity) {

		for (int i = 0; i < getInventory().size(); i++) {

			Book B = getInventory().get(i);

			if (B.getBookId() == bookId) {
				int instock = B.getAmount() + quantity;
				B.setAmount(instock);
				repository.save(B);

			}
		}
		return repository.findById(bookId).orElse(null);

	}

}
