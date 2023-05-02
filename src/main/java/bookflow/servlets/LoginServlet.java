package bookflow.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookflow.models.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		User uResult = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username and u.password = :password", User.class)
				.setParameter("username", username).setParameter("password", password).getSingleResult();
		request.getRequestDispatcher("/index.jsp");
		request.getSession().setAttribute("userId", uResult.getId());
		request.getSession().setAttribute("username", uResult.getUsername());
		response.sendRedirect("index.jsp");
	}

}
