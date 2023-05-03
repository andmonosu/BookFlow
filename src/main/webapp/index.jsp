<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    <style><%@include file="./css/style_index.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Bookflow</title>
    </head>

<body class="body">

<header class="header">
	<nav class="navbar bg-body-tertiary">
		<div class="header_logo">
		<img class="image_logo" src="./img/logo.png" alt="Logo">
		</div>

		<div class="header_content">
		<c:if test="${sessionScope.username != null}">
				<div class="profile-content">
					<div>
						<img class="profile_logo" src="./img/profile.png" alt="Logo">
					</div>
				    <p>${sessionScope.username}</p>
				</div>
				<form id="populateForm" action="LogoutServlet" method="post">
				      <button class="btn btn-outline-danger type="submit">Cerrar Sesión</button>
				</form>
				<form id="populateForm" action="DBServlet" method="post">
		            	<button class="btn btn-secondary" id="id_searchBtn" type="submit" name="populateBtn">Poblar DB	
		               	</button>
		        </form>
				
				  
				
		</c:if>

		<c:if test="${sessionScope.username == null}">
		    <a href="login.jsp">
		        <button class="btn btn-outline-primary" id="login_button">Iniciar Sesión</button>
		    </a>
		
		    <a href="register.jsp">
		        <button class="btn btn-outline-success" id="register_button">Registrarse</button>
		    </a>
		    <form id="populateForm" action="DBServlet" method="post">
		            <button class="btn btn-secondary" id="id_searchBtn" type="submit" name="populateBtn">Poblar
		                BD</button>
		    </form>
		</c:if>
				
		
		<c:if test="${requestScope.mensaje != null}">
				<h1>${requestScope.mensaje}</h1>
		</c:if>
			</div>
	</nav>
</header>
<form class="index_form" method="post" action="SearchServlet">

	<img class="image_logo" src="./img/libro.png" alt="Logo">	
	 <label>Buscar libro por título:</label>
	 <input type="text" name="title" required><br>
	 <button class="btn btn-outline-success" type="submit">Buscar</button>
</form> 
	<c:forEach items="${requestScope.books}" var="book">	
		<a href="/BookFlow/DetailBookServlet?id=${book.id}">
			<img alt="" src="${book.urlImage}"> 
			<p> ${book.title}</p>
		</a><br>
	</c:forEach>
	    </body>
</html>