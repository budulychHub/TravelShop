<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/add/add.css">

<div class="container">
	<h2>
		Add provider<small>(enter data)</small>
		${exception}
	</h2>

	<form:form modelAttribute="provider" action="addProvider" method="post">
		<div class="group">
			<form:input path="name" />
			<span class="highlight"></span> <span class="bar"></span> <label>Name</label>
		</div>

		<div class="group">
			<form:input path="email" type="email"/>
			<span class="highlight"></span> <span class="bar"></span> <label>Email</label>
		</div>

		<div class="group">
			<form:input path="phone" />
			<span class="highlight"></span> <span class="bar"></span> <label>Phone</label>
		</div>

		<button class="action-button shadow animate green">Click</button>
	</form:form>
</div>