package bookflow.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookflow.models.Book;
import bookflow.models.BookModel;
import bookflow.models.Loan;
import bookflow.models.Reserve;
import bookflow.models.User;
import bookflow.repository.BookModelRepository;
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
		
		String bookId = request.getParameter("bookId");
		String userId = request.getSession().getAttribute("userId").toString();
		String endDate = request.getParameter("endDate");
		
		if(userId!=null&&userId!="") {
			EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
			EntityManager em = emf.createEntityManager();
			BookModel bookModel = BookModelRepository.getBookById(bookId, em);
			List<Book> books = BookRepository.getBooksBySerialNumber(bookModel.getSerialNumber(), em);
			List<Book> booksWithLoan = BookRepository.getBooksByBookModelWithLoan(bookModel.getSerialNumber(), em);
			Book book = null;
			if (books.size()>=booksWithLoan.size()&&!booksWithLoan.isEmpty()) {
				for(int i=0;i<books.size();i++) {
					book = books.get(i);
					if(!booksWithLoan.contains(book)) {
						break;
					}
				}
			}else if(booksWithLoan.isEmpty()) {
				book = books.get(0);
			}
			User user = UserRepository.getUserById(userId, em);
			
			try {
				LoanRepository.createLoan(user, book, LocalDate.now(), LocalDate.parse(endDate), em);
				response.sendRedirect("/BookFlow/DetailBookServlet?id="+bookId);
			}catch (Exception e) {
				RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
				request.setAttribute("mensaje",
						"Este libro no existe");
				rd.forward(request, response);
			}finally {
				em.close();
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			request.setAttribute("mensaje",
					"Antes de realizar esta acción inicia sesión");
			rd.forward(request, response);
		}
	}
}
