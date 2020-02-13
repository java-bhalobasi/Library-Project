package in.sourav.library.restservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.sourav.library.restservice.model.Borrower;
import in.sourav.library.restservice.repository.BookRepository;
import in.sourav.library.restservice.repository.BorrowerRepository;
import in.sourav.library.restservice.repository.CopyRepository;

@RestController
public class BorrowerController {
	
	@Autowired
	private BorrowerRepository BorrowDetails;
	
	@Autowired
	private CopyRepository copyRepository;
	
	@Autowired
	private BookRepository bookRepository;
	


	
	@GetMapping("/library/borrower/{userId}/borrowedBooks")
	public List<Borrower> borrowedByMe(@PathVariable String userId) {
		
		List<Borrower> borrowedBooks = (ArrayList<Borrower>)BorrowDetails.findByBorrowerName(userId);
		System.out.println("borrowedBooks = "+ borrowedBooks);
		return borrowedBooks;
	}
	
	
	
}
