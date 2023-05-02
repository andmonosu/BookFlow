<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,bookflow.models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>
    
    <c:if test="${requestScope.mensaje != null}">
		<h1>${requestScope.mensaje}</h1>
	</c:if>
    
    <body>
    <form method="post" action="LoginServlet">
	  <label>Nombre de usuario:</label>
	  <input type="text" name="user" required><br>
	  <label>Contraseña:</label>
	  <input type="password" name="password" required><br>
	  <button type="submit">Iniciar Sesión</button>
	</form> 
    </body>
</html>