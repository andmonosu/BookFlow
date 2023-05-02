<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.username != null}">
	<h1>${sessionScope.username}</h1>
</c:if>

<a href="login.jsp">
	<button type="submit">Iniciar Sesión</button>
</a>

<a href="register.jsp">
	<button>Registrarse</button>
</a>

<form id="populateForm" action="DBServlet" method="post">
            <button id="id_searchBtn" type="submit" name="populateBtn">Poblar
                BD</button>
        </form>