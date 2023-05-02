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

	
</body>
</html>