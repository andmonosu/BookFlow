<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,bookflow.models.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>
    
    <body>
    <form method="post" action="RegisterServlet">
	  <label>Nombre de usuario:</label>
	  <input type="text" name="user" required><br>
	  <label>Correo electr�nico:</label>
	  <input type="text" name="email" required><br>
	  <label>Contrase�a:</label>
	  <input type="password" name="password" required><br>
	  <label>Direcci�n:</label>
	  <input type="text" name="direccion" required><br>
	  <label>Tel�fono:</label>
	  <input type="text" name="telephone" required><br>
	  <button type="submit">Registrarse</button>
	</form> 
    </body>
</html>