package user;

import javax.persistence.*;
import javax.servlet.*;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */

public class UserListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("user.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/user.odb");
        e.getServletContext().setAttribute("emf", emf);
    }
 
    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
	
}
