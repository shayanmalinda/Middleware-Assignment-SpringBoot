package com.shayanmalinda.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shayanmalinda.springboot.entity.Book;
import com.shayanmalinda.springboot.exception.ResourceNotFoundException;
import com.shayanmalinda.springboot.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	// get all books' details
	@GetMapping
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
				
	}
	
	// get book details by book id
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable (value="id") long bookId) {
		return this.bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with book id :"+bookId));
	}
		
	// create a new book
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return this.bookRepository.save(book);
	}


	// update book details
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable ("id") long bookId) {
		Book existingBook =  this.bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with book id :"+bookId));
		existingBook.setisbn(book.getisbn());
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCount(book.getCount());
		return this.bookRepository.save(existingBook);
	}
	
	// delete book by book id
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable ("id") long bookId) {
		Book existingBook =  this.bookRepository.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with book id :"+bookId));
		this.bookRepository.delete(existingBook);
		return ResponseEntity.ok().build();
	}
}
