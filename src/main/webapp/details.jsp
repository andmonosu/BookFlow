<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<style>
<%@include file="./css/style_details.css"%>
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<title>Bookflow</title>
</head>

<body class="body">
	<c:if test="${requestScope.mensaje != null}">
		<h1>${requestScope.mensaje}</h1>
	</c:if>
	<c:if test="${requestScope.book != null}">
		<header class="header">
			<nav class="navbar bg-body-tertiary">
				<div class="header_logo">
					<img class="image_logo" src="./img/logo.png" alt="Logo">
				</div>

				<div class="header_content">
					<a href="index.jsp">
						<button class="btn btn-outline-primary" id="index_button">Volver</button>
					</a>

				</div>
			</nav>
		</header>


		<c:if test="${requestScope.book != null}">

			<div class="title">
				<h1>${requestScope.book.title}</h1>
			</div>
			<div class="container">
				<img class="card_image" alt="" src="${requestScope.book.urlImage}">
				<div class="container_info">

					<p>Aqui va la sinopsis</p>
					<p>
						El autor del libro es: <b>${requestScope.book.author}</b>
					</p>
					<p>
						La editorial de ${requestScope.book.title} es: <b>${requestScope.book.editorial}</b>
					</p>
					<p>
						El libro fue publicado el <b>${requestScope.book.pubDate}</b>
					</p>
					<p>
						Total de páginas: <b>${requestScope.book.pagesNumber}</b>
					</p>
					<p>
						El número identificativo de este libro es: <b>${requestScope.book.serialNumber}</b>
					</p>

				</div>
		</c:if>
		</div>
		<div class="accion_container">
			<c:if
				test="${requestScope.reserves != null&&requestScope.areReserves}">
				<h1>Reservas</h1>
				<c:forEach items="${requestScope.reserves}" var="reserve">
					<p>Fecha de Inicio:${reserve.startDate}</p>
					<p>Fecha de Fin:${reserve.endDate}</p>
				</c:forEach>
			</c:if>

			<c:if test="${sessionScope.username != null}">
				<h2>Hacer una reserva</h2>
				<form action="ReserveServlet" method="post">
					<input type="hidden" id="bookId" name="bookId"
						value="${requestScope.book.id}"> <label for="startDate">Fecha
						de Inicio:</label> <input type="date" id="startDate" name="startDate">
					<label for="endDate">Fecha de Fin:</label> <input type="date"
						id="endDate" name="endDate"> <input type="submit">
				</form>
			</c:if>
			<c:if test="${requestScope.loans != null&&requestScope.areLoans}">
				<h1>Préstamos</h1>
				<c:forEach items="${requestScope.loans}" var="loan">
					<p>Fecha de Inicio:${loan.startDate}</p>
					<p>Fecha de Fin:${loan.endDate}</p>
				</c:forEach>
			</c:if>

			<c:if test="${sessionScope.username != null}">
				<h2>Realizar un préstamo</h2>
				<form action="LoanServlet" method="post">
					<input type="hidden" id="bookId" name="bookId"
						value="${requestScope.book.id}"> <label for="endDate">Fecha
						de Fin:</label> <input type="date" id="endDate" name="endDate"> <input
						type="submit">

				</form>
			</c:if>
			<c:if test="${sessionScope.username != null}">
				<form action="CommentServlet" method="post">
					<input type="hidden" id="bookId" name="bookId"
						value="${requestScope.book.id}">
					<textarea name="text"></textarea>
					<button type="submit">Enviar</button>
				</form>
			</c:if>
			<c:if
				test="${requestScope.comments != null&&requestScope.areComments}">
				<h1>Comentarios</h1>
				<c:forEach items="${requestScope.comments}" var="comment">
					<p>${comment.text}</p>
				</c:forEach>
			</c:if>
	</c:if>
</body>
</html>