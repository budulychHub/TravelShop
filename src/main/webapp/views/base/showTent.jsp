<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>Tent</h1>



<c:forEach var="tent" items="${tents}">
<a href="deleteTent/${tent.id}">delete</a>
<br>
${tent.brand}
<br>
${tent.copacity}
<br>
${tent.weight}
<br>
${tent.price}
<hr>
</c:forEach>