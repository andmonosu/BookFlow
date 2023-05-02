package bookflow.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import bookflow.models.Book;

public class BookRepository {

	public static List<Book> getBookByTitle(String title, EntityManager em){
		List<Book> books = em.createQuery(
                "SELECT b FROM Book b", Book.class).getResultList();
		List<Book> res = new ArrayList<Book>();
		for(int i=0;i<books.size();i++) {
			Book book = books.get(i); 
			if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				res.add(book);
			}
		}
		return res;
	}
	
}
