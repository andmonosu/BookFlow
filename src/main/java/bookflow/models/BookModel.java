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
public class BookModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue
	private long id;
	
	private String title;

	private String author;
	
	private String editorial;
	
	private LocalDate pubDate;
	
	private Integer pagesNumber;
	
	private Integer serialNumber;
	
	private String urlImage;

	public BookModel(String title, String author, String editorial, LocalDate pubDate, Integer pagesNumber,
			Integer serialNumber, String urlImage) {
		super();
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.pubDate = pubDate;
		this.pagesNumber = pagesNumber;
		this.serialNumber = serialNumber;
		this.urlImage = urlImage;
	}

	public BookModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public Integer getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(Integer pagesNumber) {
		this.pagesNumber = pagesNumber;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}
	
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
