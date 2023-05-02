package bookflow.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import bookflow.models.Book;
import bookflow.models.Loan;
import bookflow.models.Reserve;
import bookflow.models.User;
import bookflow.util.State;

public class LoanRepository {

	public static Loan createLoan(User user, Book book, LocalDate startDate, LocalDate endDate, EntityManager em) {
		em.getTransaction().begin();
		Loan loan = new Loan(LocalDate.now(), endDate, State.IN_PROCESS);
		loan.setUser(user);
		loan.setReservedBook(book);
		em.persist(loan);
		em.getTransaction().commit();
		return loan;
	}
}
