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
import bookflow.models.Book;
import bookflow.repository.BookRepository;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		List<Book> bResults;
		try {
			bResults = BookRepository.getBookByTitle(title,em);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("books",bResults);
			rd.forward(request, response);
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("mensaje",
					"El titulo buscado no existe no existe");
			rd.forward(request, response);
		}
	}

}
