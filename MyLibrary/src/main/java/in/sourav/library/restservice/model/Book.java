package in.sourav.library.restservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private int bookId;
	
	@Size(min = 4, message="Name should have at least 4 characters")
    private String name;
	
	@Size(min = 4, message="Author should have at least 4 characters")
    private String author;
    
	
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "book") 
    private List<Copy> copies;
	 
    
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookId() {
		return bookId;
	}
	public void setBook_id(int id) {
		this.bookId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Copy> getCopies() {
		return copies;
	}
	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}
	public void setBookId(int id) {
		this.bookId = id;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + bookId + ", name=" + name + ", author=" + author + "]";
	}
	
	
    
}
