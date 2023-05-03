package bookflow.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import bookflow.models.Book;
import bookflow.models.Loan;
import bookflow.models.Reserve;
import bookflow.models.User;

public class ReserveRepository {

	public static void createReserve(User user, Book book, LocalDate startDate, LocalDate endDate, EntityManager em) {
		em.getTransaction().begin();
		Reserve reserve = new Reserve(LocalDate.now(), startDate, endDate);
		reserve.setReservedUsers(user);
		reserve.setBook(book);
		em.persist(reserve);
		em.getTransaction().commit();
	}
	
	public static Reserve getReserveByBookId(String bookId, EntityManager em) {
		Reserve reserve = em.createQuery("SELECT r FROM Reserve r WHERE r.book.id = :bookId",Reserve.class)
				.setParameter("bookId", Integer.parseInt(bookId)).getSingleResult();
		return reserve;
	}
	
	public static List<Reserve> getReservesByBookModel(Integer serialNumber, EntityManager em) {
		List<Reserve> loan = em.createQuery("SELECT r FROM Reserve r WHERE r.book.bookModel.serialNumber = :serialNumber",Reserve.class)
				.setParameter("serialNumber", serialNumber).getResultList();
		return loan;
	}
}
