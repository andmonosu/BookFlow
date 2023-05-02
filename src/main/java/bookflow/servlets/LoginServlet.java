package bookflow.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookflow.models.User;
import bookflow.repository.UserRepository;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		User uResult;
		try {
			uResult = UserRepository.getUserByUsername(username,em);
			if(!password.equals(uResult.getPassword())) {
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("mensaje",
						"El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros. Por favor, revisa e inténtalo de nuevo.");
				rd.forward(request, response);
			}else {
				request.getSession().setAttribute("userId", uResult.getId());
				request.getSession().setAttribute("username", uResult.getUsername());
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("mensaje",
					"El nombre de usuario el usuario no existe");
			rd.forward(request, response);
		}
	}
}
