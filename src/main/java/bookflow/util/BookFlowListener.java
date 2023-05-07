package bookflow.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.*;


public class BookFlowListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent e) {
		com.objectdb.Enhancer.enhance("bookflow.models.*");
		com.objectdb.Enhancer.enhance("bookflow.servlets.*");
		Map<String, String> properties = new HashMap<String, String>();
		  properties.put("javax.persistence.jdbc.user", "admin");
		  properties.put("javax.persistence.jdbc.password", "admin");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb://localhost:6136/data.odb",properties);
        e.getServletContext().setAttribute("emf", emf);
    }
 
	@Override
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
	
}
