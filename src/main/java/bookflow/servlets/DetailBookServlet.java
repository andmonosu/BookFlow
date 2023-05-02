package bookflow.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookflow.models.Book;
import bookflow.repository.BookRepository;

/**
 * Servlet implementation class DetailBookServlet
 */
public class DetailBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		Book bResult;
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			bResult = BookRepository.getBookById(id, em);
			request.setAttribute("book",bResult);
			rd.forward(request, response);
			
		}catch(Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
			request.setAttribute("mensaje",
					"Este libro no existe");
			rd.forward(request, response);
			
			
		}finally {
			em.close();
		}
		
	}


}
