<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Sleeping bag</h1>

<c:forEach var="sleepingBag" items="${sleepingBags}">
	<a href="deleteSleepingBag/${sleepingBag.id}">delete</a>
	<br>
	
	<form:form action="saveImgBag/${sleepingBag.id}?${_csrf.parameterName}=${_csrf.token}"
		method="get" enctype="multipart/form-data">
		<input type="file" name="image">
		<button>save image</button>
	</form:form>
	
	<br>
${sleepingBag.brand}
<br>
${sleepingBag.weight}
<br>
${sleepingBag.height}
<br>
${sleepingBag.price}
<hr>
</c:forEach>