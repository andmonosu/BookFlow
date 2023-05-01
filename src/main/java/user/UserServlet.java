package user;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a database connection:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle a new guest (if any):
            String name = request.getParameter("name");
            if (name != null) {
                em.getTransaction().begin();
                em.persist(new User());
                em.getTransaction().commit();
            }
 
            // Display the list of guests:
            List<User> userList = em.createQuery(
                "SELECT u FROM User u", User.class).getResultList();
            request.setAttribute("users", userList);
            request.getRequestDispatcher("/user.jsp")
                .forward(request, response);
 
        } finally {
            // Close the database connection:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
