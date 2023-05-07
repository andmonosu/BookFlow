package bookflow.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue
	private long id;
	
	private Integer numCopy;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private BookModel bookModel;

	public Book(Integer numCopy) {
		super();
		this.numCopy = numCopy;
	}

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumCopy() {
		return numCopy;
	}

	public void setNumCopy(Integer numCopy) {
		this.numCopy = numCopy;
	}

	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
	}
}
