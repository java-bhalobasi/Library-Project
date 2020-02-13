package in.sourav.library.restservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.sourav.library.restservice.model.Copy;
import in.sourav.library.restservice.repository.CopyRepository;

@RestController
public class CopyController {
	
	@Autowired
	private CopyRepository copyRepository;
	
	
	
	/**
	 * List of Books available to Borrow		
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/library/books/availableToBorrow", method=RequestMethod.GET)
	public Map<String, String> availableBooks(ModelMap model) {
		
		
		List<Copy> availableCopies = (ArrayList<Copy>)copyRepository.findByAvailable(true);
		Map<String, String> books = new HashMap();
		for(Copy copy:availableCopies) {
			
			System.out.println("Opening New Book issue page == " + copy.getBook());
			books.put(copy.getBook().getName(),copy.getBook().getAuthor());
		}
		model.put("availableCopies",books);
		System.out.println("After setting model");
		return books;
	}
	
	
	
}
