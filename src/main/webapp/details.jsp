<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>BookFlow</title>
    </head>

<body>
<c:if test="${requestScope.mensaje != null}">
		<h1>${requestScope.mensaje}</h1>
	</c:if>
<c:if test="${requestScope.book != null}">

<p>${requestScope.book.title}</p>
</c:if>

<c:if test="${requestScope.reserve != null}">
	<h1>Reservas</h1>
	<p>Fecha de Inicio:${requestScope.reserve.startDate}</p>
	<p>Fecha de Fin:${requestScope.reserve.endDate}</p>
</c:if>

<c:if test="${requestScope.reserve == null}">
	<h2>Hacer una reserva</h2>
	<form action="ReserveServlet" method="post">
	  <label for="startDate">Fecha de Inicio:</label>
	  <input type="date" id="startDate" name="startDate">
	  <label for="endDate">Fecha de Fin:</label>
	  <input type="date" id="endDate" name="endDate">
	  <input type="submit">
	</form>
</c:if>

	
</body>
</html>