package bookflow.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id@GeneratedValue
	private long id;
	
	private String text;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private BookModel bookModel;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	private User user;

	public Comment(String text) {
		super();
		this.text = text;
	}
	
	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
