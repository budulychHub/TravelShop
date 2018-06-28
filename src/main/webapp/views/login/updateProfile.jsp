<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Update profile</h1>


<hr>
<h3>Update</h3>

<form:form action="updateProfile" method="post">
	<input type="text" name="name" value="${user.name}">
	<input type="text" name="email" value="${user.email}">
	<input type="text" name="password">
	<button>save updates</button>
</form:form>
<hr>
<h3>Img</h3>
<h3>${exception}</h3>


<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input type="file" name="image">
	<button>save image</button>
</form:form>



