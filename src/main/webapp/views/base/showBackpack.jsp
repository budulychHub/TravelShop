<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<h1>Backpack</h1>

<c:forEach var="backpack" items="${backpacks}">
<a href="deleteBackpack/${backpack.id}">delete</a>
<br>
${backpack.brand}
<br>
<i>
${backpack.volume}L
<br>
${backpack.weight}kg
<br>
${backpack.price}ua
</i>
<hr>
</c:forEach>
<hr>