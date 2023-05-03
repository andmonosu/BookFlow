package bookflow.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import bookflow.models.Book;
import bookflow.models.Loan;
import bookflow.models.Reserve;
import bookflow.models.User;
import bookflow.util.State;

public class LoanRepository {

	public static void createLoan(User user, Book book, LocalDate startDate, LocalDate endDate, EntityManager em) {
		em.getTransaction().begin();
		Loan loan = new Loan(LocalDate.now(), endDate, State.IN_PROCESS);
		loan.setUser(user);
		loan.setReservedBook(book);
		em.persist(loan);
		em.getTransaction().commit();
	}
	
	public static Loan getLoanByBookId(String bookId, EntityManager em) {
		Loan loan = em.createQuery("SELECT l FROM Loan l WHERE l.reservedBook.id = :bookId",Loan.class)
				.setParameter("bookId", Integer.parseInt(bookId)).getSingleResult();
		return loan;
	}
	
	public static List<Loan> getLoansByBookModel(Integer serialNumber, EntityManager em) {
		List<Loan> loan = em.createQuery("SELECT l FROM Loan l WHERE l.reservedBook.bookModel.serialNumber = :serialNumber",Loan.class)
				.setParameter("serialNumber", serialNumber).getResultList();
		return loan;
	}
	
	
}
