package bookflow.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bookflow.models.BookModel;
import bookflow.repository.BookModelRepository;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		List<BookModel> bResults;
		try {
			bResults = BookModelRepository.getBookByTitle(title,em);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("books",bResults);
			rd.forward(request, response);
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("mensaje",
					"El titulo buscado no existe no existe");
			rd.forward(request, response);
		
		}finally {
			em.close();
		
		}
	}

}
