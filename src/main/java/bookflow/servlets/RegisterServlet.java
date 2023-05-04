package bookflow.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bookflow.models.User;

import javax.persistence.*;

/**
 * Servlet implementation class UserServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Integer telephone = Integer.valueOf(request.getParameter("telephone"));
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			if (username.length() < 3 || username.length() > 50 || password.length() < 8 || telephone < 100000000
					|| telephone >= 1000000000) {
				if (username.length() < 3 || username.length() > 50) {
					request.setAttribute("username_error",
							"El nombre de usuario tiene que tener como mínimo 3 caractéres y como máximo 50");
				}
				if (password.length() < 8) {
					request.setAttribute("password_error", "La contraseña tiene que tener como mínimo 8 caractéres");
				}
				if (telephone < 100000000 || telephone >= 1000000000) {
					request.setAttribute("telephone_error", "El teléfono tiene que tener 9 dígitos");
				}
				rd.forward(request, response);
			} else {
				em.getTransaction().begin();

				User usuario = new User(username, password, telephone, email);
				em.persist(usuario);

				em.getTransaction().commit();

				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			request.setAttribute("mensaje",
					"El nombre de usuario ya está elegido");
			rd.forward(request, response);
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}
}
