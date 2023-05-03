package bookflow.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import bookflow.models.Book;
import bookflow.models.BookModel;

public class BookModelRepository {

	public static List<BookModel> getBookByTitle(String title, EntityManager em){
		List<BookModel> books = em.createQuery(
                "SELECT b FROM BookModel b", BookModel.class).getResultList();
		List<BookModel> res = new ArrayList<BookModel>();
		for(int i=0;i<books.size();i++) {
			BookModel book = books.get(i); 
			if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				res.add(book);
			}
		}
		return res;
	}
	
	public static BookModel getBookById(String id, EntityManager em){
		BookModel res = em.createQuery("SELECT b FROM BookModel b WHERE b.id = :id",BookModel.class).setParameter("id", Integer.parseInt(id)).getSingleResult();
		return res;
		
	}
	
}
