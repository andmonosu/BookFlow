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

@Entity
public class Reserve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue
	private long id;
	
	private LocalDate reserveDate;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private  Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private User reservedUsers;

	public Reserve(LocalDate reserveDate, LocalDate startDate, LocalDate endDate) {
		super();
		this.reserveDate = reserveDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
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

	public User getReservedUsers() {
		return reservedUsers;
	}

	public void setReservedUsers(User reservedUsers) {
		this.reservedUsers = reservedUsers;
	}
}
