<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,bookflow.models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <style><%@include file="./css/style_login.css"%></style>
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>BookFlow-Login</title>
    </head>
    
    
    
    <body class="body">
     <c:if test="${requestScope.mensaje != null}">
     	<div class="alert alert-danger" role="alert">
		 	${requestScope.mensaje}
		</div>
	</c:if>
    
    <form class="login_form" method="post" action="LoginServlet">
    	<div class="register_logo">
			<img class="image_register" src="./img/hombre.png" alt="Logo">
		</div>
    	<div class="mb-2">
		     <label>Nombre de usuario:</label>
	  		<input type="text" name="user" required><br>
	  	</div>
	  	<div class="mb-2">
		     <label>Contraseña:</label>
	  		<input type="password" name="password" required><br>
	  	</div>
	  <button class="btn btn-outline-primary" type="submit">Iniciar Sesión</button>
	 
	</form> 
    </body>
</html>