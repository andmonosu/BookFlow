package bookflow.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String userId = request.getSession().getAttribute("userId").toString();
		if(userId!=null&&userId!="") {
			request.getSession().removeAttribute("userId");
			request.getSession().removeAttribute("username");
			
			response.sendRedirect("index.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			request.setAttribute("mensaje",
					"Antes de realizar esta acción inicia sesión");
			rd.forward(request, response);
		}
     }

}
