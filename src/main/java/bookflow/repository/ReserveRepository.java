package bookflow.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import bookflow.models.Book;
import bookflow.models.Reserve;
import bookflow.models.User;

public class ReserveRepository {

	public static Reserve createReserve(User user, Book book, LocalDate startDate, LocalDate endDate, EntityManager em) {
		em.getTransaction().begin();
		Reserve reserve = new Reserve(LocalDate.now(), startDate, endDate);
		reserve.setReservedUsers(user);
		reserve.setBook(book);
		em.persist(reserve);
		em.getTransaction().commit();
		return reserve;
	}
}
