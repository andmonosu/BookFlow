package bookflow.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import bookflow.util.State;

@Entity
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue
	private long id;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private State state;
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private Book reservedBook;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private User user;
	
	public Loan(LocalDate startDate, LocalDate endDate, State state) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


	public Book getReservedBook() {
		return reservedBook;
	}


	public void setReservedBook(Book reservedBook) {
		this.reservedBook = reservedBook;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}




