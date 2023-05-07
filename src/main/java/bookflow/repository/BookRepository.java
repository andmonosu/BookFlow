package bookflow.repository;

import java.util.List;
import javax.persistence.EntityManager;
import bookflow.models.Book;

public class BookRepository {

	public static List<Book> getBooksBySerialNumber(Integer serialNumber, EntityManager em){
		List<Book> books = em.createQuery(
                "SELECT b FROM Book b WHERE b.bookModel.serialNumber = :serialNumber", Book.class).setParameter("serialNumber", serialNumber).getResultList();
		return books;
	}
	
	public static Integer countBooksByModel(Integer serialNumber, EntityManager em) {
		Integer count = em.createQuery(
                "SELECT b FROM Book b WHERE b.bookModel.serialNumber = :serialNumber", Book.class).setParameter("serialNumber", serialNumber).getResultList().size();
		return count;
	}
	
	public static List<Book> getBooksByBookModelWithLoan(Integer serialNumber, EntityManager em) {
		List<Book> books = em.createQuery("SELECT l.reservedBook FROM Loan l WHERE l.reservedBook.bookModel.serialNumber = :serialNumber",Book.class)
				.setParameter("serialNumber", serialNumber).getResultList();
		return books;
	}
	
	public static List<Book> getBooksByBookModelWithReserve(Integer serialNumber, EntityManager em) {
		List<Book> books = em.createQuery("SELECT r.book FROM Reserve r WHERE r.book.bookModel.serialNumber = :serialNumber",Book.class)
				.setParameter("serialNumber", serialNumber).getResultList();
		return books;
	}
}
