package bookflow.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookflow.models.Book;
import bookflow.models.Loan;
import bookflow.models.Reserve;
import bookflow.models.User;
import bookflow.repository.BookRepository;
import bookflow.repository.LoanRepository;
import bookflow.repository.ReserveRepository;
import bookflow.repository.UserRepository;

/**
 * Servlet implementation class LoanServlet
 */
public class LoanServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		
		String bookId = request.getParameter("bookId");
		String userId = request.getSession().getAttribute("userId").toString();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		Book book = BookRepository.getBookById(bookId, em);
		User user = UserRepository.getUserById(userId, em);
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			Loan loan = LoanRepository.createLoan(user, book, LocalDate.parse(startDate), LocalDate.parse(endDate), em);
			request.setAttribute("loan",
					loan);
			rd.forward(request, response);
		}catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			request.setAttribute("mensaje",
					"Este libro no existe");
			rd.forward(request, response);
		}finally {
			em.close();
		}
		
		
	}
}
