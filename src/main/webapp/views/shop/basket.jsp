<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<h1>Basket</h1>
<br><br>
<h2>Backpack</h2>
<hr>
<c:forEach var="backpack" items="${backpacks}">

	<h3>${backpack.brand}</h3>
${backpack.volume} L    ${backpack.price}

	<form:form action="deleteFromOrder/${backpack.id}" method="get">
		<button>delete</button>
	</form:form>

	<sec:authorize access="isAuthenticated()">
	<sec:authorize access="!hasRole('ROLE_ADMIN')">
	<form:form action="getOrder/${backpack.id}" method="get">
		<button>get</button>
	</form:form>
	</sec:authorize>
	</sec:authorize>
	
	<hr>
</c:forEach>


