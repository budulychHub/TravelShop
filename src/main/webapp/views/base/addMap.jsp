<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/add/add.css">



<div class="container">
	<h2>
		Add map<small>(enter data)</small>
		${exception}
	</h2>

	<form:form modelAttribute="map" action="addMap" method="post">
		<div class="group">
			<form:input path="nameLacality" />
			<span class="highlight"></span> <span class="bar"></span> <label>NameLacality</label>
		</div>

		<div class="group">
			<form:input path="scale" />
			<span class="highlight"></span> <span class="bar"></span> <label>Scale</label>
		</div>

		<div class="group">
			<form:input path="price" />
			<span class="highlight"></span> <span class="bar"></span> <label>Price</label>
		</div>

		<div id="mainselection">
			<form:select path="providers" items="${providers}" itemLabel="name"
				itemValue="id">
			</form:select>
		</div>

		<button class="action-button shadow animate green">Click</button>
	</form:form>
</div>
