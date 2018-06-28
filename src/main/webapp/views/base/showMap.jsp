<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>Map</h1>

<c:forEach var="map" items="${maps}">
<a href="deleteMap/${map.id}">delete</a>
<br>
${map.nameLacality}
<br>
${map.scale}
<br>
${map.price}
<hr>
</c:forEach>



