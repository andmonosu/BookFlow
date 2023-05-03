<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>

<body>
<c:if test="${sessionScope.username != null}">
	<h1>${sessionScope.username}</h1>
	<form id="populateForm" action="LogoutServlet" method="post">
            <button type="submit">Cerrar Sesión</button>
        </form>
</c:if>

<c:if test="${sessionScope.username == null}">
	<a href="login.jsp">
		<button>Iniciar Sesión</button>
	</a>
	
	<a href="register.jsp">
		<button>Registrarse</button>
	</a>
</c:if>


<form id="populateForm" action="DBServlet" method="post">
	<button type="submit" name="populateBtn">Poblar BD</button>
</form>

<c:if test="${requestScope.mensaje != null}">
		<h1>${requestScope.mensaje}</h1>
	</c:if>

<form method="post" action="SearchServlet">
	 <label>Buscar libro por título:</label>
	 <input type="text" name="title" required><br>
	 <button type="submit">Buscar</button>
</form> 
	<c:forEach items="${requestScope.books}" var="book">	
		<a href="/BookFlow/DetailBookServlet?id=${book.id}">
			<img alt="" src="${book.urlImage}"> 
			<p> ${book.title}</p>
		</a><br>
	</c:forEach>
	    </body>
</html>