package in.sourav.library.restservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Borrower {
	
	@Id
	@GeneratedValue
	private int id;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Copy copy;
	
	
	private String borrowerName;
	private Date borrowDate;
	
	
	public Borrower() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowerName() {
		return borrowerName;
	}


	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}


	public Date getBorrowDate() {
		return borrowDate;
	}


	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}


	public Copy getCopy() {
		return copy;
	}


	public void setCopy(Copy copy) {
		this.copy = copy;
	}


	@Override
	public String toString() {
		return "Borrower [id=" + id + ", copy=" + copy + ", borrowerName=" + borrowerName + ", borrowDate=" + borrowDate
				+ "]";
	}


}
