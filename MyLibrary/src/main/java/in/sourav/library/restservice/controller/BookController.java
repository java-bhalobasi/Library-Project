package in.sourav.library.restservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.sourav.library.restservice.exception.ResourceNotFoundException;
import in.sourav.library.restservice.model.Book;
import in.sourav.library.restservice.repository.BookRepository;
import in.sourav.library.restservice.repository.BorrowerRepository;
import in.sourav.library.restservice.repository.CopyRepository;

@RestController
public class BookController {
	
	@Autowired
	private BorrowerRepository BorrowDetails;
	
	@Autowired
	private CopyRepository copyRepository;
	
	@Autowired
	private BookRepository bookRepository;
	

	/**
	 * Add new book
	 * 
	 * @param newBook
	 * @return
	 */
	@PostMapping("/library/book")
	public ResponseEntity<Object> addNewBook(@Valid @RequestBody Book newBook) {
		
		Book savedBook = bookRepository.save(newBook);
		URI createdUri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{bookId}").buildAndExpand(savedBook.getBookId())
						.toUri();
		
		return ResponseEntity.created(createdUri).build();
	}
	
	/**
	 * List of all books in the Library
	 * @param 
	 * @return
	 */
	@GetMapping("/library/allBooks")
	public List<Book> findAllBooks() {
		
		List<Book> books = bookRepository.findAll();
		System.out.println(books);
		return books;
	}
	
	/**
	 * Find books by Id
	 * @param bookId
	 * @return
	 */
	@GetMapping("/library/book/{bookId}")
	public Resource<Book> findById(@PathVariable int bookId) {
		
		Optional<Book> optBook = bookRepository.findById(bookId);
		//Resource<Book> userResource = book.get();
		if(!optBook.isPresent()) {
			throw new ResourceNotFoundException("id-"+bookId);
		}
		
		
		Book book = optBook.get();
		//all books
		Resource<Book> resource = new Resource<Book>(book);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllBooks());
		resource.add(linkTo.withRel("all-books"));
		return resource;
	}
	
	/**
	 * Find books by Name. Partial name also works
	 * @param bookName
	 * @return
	 */
	@GetMapping("/library/bookByName/{bookName}")
	public List<Book> findByName(@PathVariable String bookName) {
		
		List<Book> books = bookRepository.findByNameContaining(bookName);
		//Book book = optBook.get();
		if(books.isEmpty()) {
			throw new ResourceNotFoundException("Name-"+bookName);
		}
		//all books
		
		return books;
	}
	
	
}
