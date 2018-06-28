<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/login/profile.css">



<h1>User page</h1>

<figure class="snip0057 red">
	<figcaption>
		<h2>
			User: <span>${user.name}</span>
		</h2>
		<p>"Experts from outdoor equipment Mission We inspire people to
			travel. We believe that the more active people travel, so they are
			happier."</p>
		<h2></h2>
	</figcaption>
	<div class="image">
		<%-- <img src="${user.pathImage}" alt="sample4" /> --%>
		<img src="https://comandaportret.files.wordpress.com/2010/07/house_mare_orig.jpg" alt="sample4" />
	</div>
	<div class="position">${user.email}</div>
</figure>



<form:form action="updateProfile" method="get">
	<button>update profile</button>
</form:form>


<br>

<h3>Commodity</h3>

<c:forEach var="backpack" items="${user.backpacks}">
		<h3>${backpack.brand}</h3>
${backpack.volume} L    ${backpack.price}
<hr>
</c:forEach>


