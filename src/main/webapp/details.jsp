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

					<p> <b>Sinopsis:</b> ${requestScope.book.sinopsis}</p>
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
			</div>
		</c:if>
		<div class="accion_container">
			<div class="reserve_container">
				<c:if
					test="${requestScope.reserves != null&&requestScope.areReserves}">
					<h1>Reservas</h1>
					<c:forEach items="${requestScope.reserves}" var="reserve">
						<p><b>Reserva de:</b> ${reserve.reservedUsers.username}</p>
						<p><b>Ejemplar:</b> ${reserve.book.numCopy}</p>
						<p><b>Fecha de Inicio:</b> ${reserve.startDate}</p>
						<p><b>Fecha de Fin:</b> ${reserve.endDate}</p>
					</c:forEach>
				</c:if>
	
				<c:if test="${sessionScope.username != null}">
					<h2>Hacer una reserva</h2>
					<form action="ReserveServlet" method="post">
						<input type="hidden" id="bookId" name="bookId"
							value="${requestScope.book.id}"> <label for="startDate">Fecha
							de Inicio:</label> <input type="date" id="startDate" name="startDate" class="form-control">
						<label for="endDate">Fecha de Fin:</label> <input type="date"
							id="endDate" name="endDate" class="form-control"> <input type="submit" class="btn btn-primary">
					</form>
				</c:if>
			</div>
			<div class="loan_container">
				<c:if test="${requestScope.loans != null&&requestScope.areLoans}">
					<h1>Préstamos</h1>
					<c:forEach items="${requestScope.loans}" var="loan">
						<p><b>Reserva de:</b> ${loan.user.username}</p>
						<p><b>Ejemplar:</b> ${loan.reservedBook.numCopy}</p>
						<p><b>Fecha de Inicio:</b> ${loan.startDate}</p>
						<p><b>Fecha de Fin:</b> ${loan.endDate}</p>
					</c:forEach>
				</c:if>
	
				<c:if test="${sessionScope.username != null}">
					<h2>Realizar un préstamo</h2>
					<form action="LoanServlet" method="post">
						<input type="hidden" id="bookId" name="bookId"
							value="${requestScope.book.id}"> <label for="endDate">Fecha
							de Fin:</label> <input type="date" id="endDate" name="endDate" class="form-control"> <input
							type="submit" class="btn btn-primary">
	
					</form>
				</c:if>
			</div>
			<div class="comment_container">
				<c:if test="${sessionScope.username != null}">
					<h2>Comentar</h2>
					<form action="CommentServlet" method="post" class="comment_form">
						<input type="hidden" id="bookId" name="bookId"
							value="${requestScope.book.id}">
						<textarea name="text" class="form-control" id="comment_box"></textarea>
						<button type="submit" class="btn btn-primary">Enviar</button>
					</form>
				</c:if>
				<c:if
					test="${requestScope.comments != null&&requestScope.areComments}">
					<h1>Comentarios</h1>
					<div class="comments">
						<c:forEach items="${requestScope.comments}" var="comment">
							<h3>${comment.user.username}</h3>
							<p class="comment_text">${comment.text}</p>
						</c:forEach>
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
</body>
</html>