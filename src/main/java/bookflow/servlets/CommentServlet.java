package bookflow.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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
import bookflow.models.User;
import bookflow.repository.BookModelRepository;
import bookflow.repository.BookRepository;
import bookflow.repository.CommentRepository;
import bookflow.repository.LoanRepository;
import bookflow.repository.UserRepository;

public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookId = request.getParameter("bookId");
		String userId = request.getSession().getAttribute("userId").toString();
		String text = request.getParameter("text");
		
		if(userId!=null&&userId!="") {
			EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
			EntityManager em = emf.createEntityManager();
			BookModel bookModel = BookModelRepository.getBookById(bookId, em);
			User user = UserRepository.getUserById(userId, em);
			try {
				CommentRepository.createComment(user, bookModel, text, em);
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
