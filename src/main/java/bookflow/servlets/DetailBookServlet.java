package bookflow.servlets;

import java.io.IOException;
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
import bookflow.models.Comment;
import bookflow.models.Loan;
import bookflow.models.Reserve;
import bookflow.repository.BookModelRepository;
import bookflow.repository.BookRepository;
import bookflow.repository.CommentRepository;
import bookflow.repository.LoanRepository;
import bookflow.repository.ReserveRepository;

/**
 * Servlet implementation class DetailBookServlet
 */
public class DetailBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		BookModel bResult = null;
		List<Loan> lResults = null;
		List<Reserve> rResults = null;
		Integer numberBooks = null;
		List<Comment> cResults = null;
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			bResult = BookModelRepository.getBookById(id, em);
			numberBooks = BookRepository.countBooksByModel(bResult.getSerialNumber(), em);
			lResults = LoanRepository.getLoansByBookModel(bResult.getSerialNumber(), em);
			rResults = ReserveRepository.getReservesByBookModel(bResult.getSerialNumber(), em);
			cResults = CommentRepository.getCommentsByBookModelId(Integer.valueOf(id), em);
			request.setAttribute("book",bResult);
			request.setAttribute("count", numberBooks);
			request.setAttribute("reserves",rResults);
			request.setAttribute("loans",lResults);
			request.setAttribute("comments",cResults);
			request.setAttribute("areLoans", !lResults.isEmpty());
			request.setAttribute("areReserves", !rResults.isEmpty());
			request.setAttribute("areComments", !cResults.isEmpty());
			rd.forward(request, response);
			
		}catch(Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			request.setAttribute("mensaje",
					"Este libro no existe");
			rd.forward(request, response);
			
			
		}finally {
			em.close();
		}
		
	}


}
