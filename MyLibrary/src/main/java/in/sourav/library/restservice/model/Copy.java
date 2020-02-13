package in.sourav.library.restservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Copy {
	
	@Id
	@GeneratedValue
	private int copyId;
	private boolean available;

	//private int book_id;
	
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JsonIgnore
	private Book book;
	 
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="copy")
	private List<Borrower> borrowers;

	public Copy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}

	public Book getBook() { 
		return book; 
	}
  
	public void setBook(Book book) { 
		this.book = book;
	}
	
	

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Copy [copyId=" + copyId + ", book=" + book + ", available=" + available +  "]";
	}
	 
	
	
}
