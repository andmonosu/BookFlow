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
<c:if test="${requestScope.reserves != null}">
	<c:forEach items="${requestScope.reserves}" var="reserve">
		<h1>Reservas</h1>
		<p>Fecha de Inicio:${reserve.startDate}</p>
		<p>Fecha de Fin:${reserve.endDate}</p>
	</c:forEach>
</c:if>

<c:if test="${requestScope.reserves.size() < requestScope.count&&sessionScope.username != null}">
	<h2>Hacer una reserva</h2>
	<form action="ReserveServlet" method="post">
	<input type="hidden" id="bookId" name="bookId" value="${requestScope.book.id}">
	  <label for="startDate">Fecha de Inicio:</label>
	  <input type="date" id="startDate" name="startDate">
	  <label for="endDate">Fecha de Fin:</label>
	  <input type="date" id="endDate" name="endDate">
	  <button type="submit">Reservar</button>
	</form>
</c:if>

<c:if test="${requestScope.loans != null}">
	<c:forEach items="${requestScope.loans}" var="loan">
		<h1>Préstamos</h1>
		<p>Fecha de Inicio:${loan.startDate}</p>
		<p>Fecha de Fin:${loan.endDate}</p>
	</c:forEach>
</c:if>

<c:if test="${requestScope.loans.size() < requestScope.count&&sessionScope.username != null}">
	<h2>Realizar un préstamo</h2>
	<form action="LoanServlet" method="post">
	  <input type="hidden" id="bookId" name="bookId" value="${requestScope.book.id}">
	  <label for="endDate">Fecha de Fin:</label>
	  <input type="date" id="endDate" name="endDate">
	  <button type="submit">Pedir prestamo</button>
	  
	</form>
	</c:if>
</c:if>

	
</body>
</html>