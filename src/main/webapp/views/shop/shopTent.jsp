<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="css/shop/backpack.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Tent</h1>


<c:forEach var="tent" items="${tents}">
	<figure class="snip1518">
		<div class="image">
			<img
				src="http://defd230db96761500ca7-61c6d5aeae250d28854ed3e240a16b15.r17.cf3.rackcdn.com/Products/47380-190116165002301331578.jpg"
				alt="sample101" />
		</div>
		<figcaption>
			<h5>Tent</h5>
			<h3>${tent.brand}</h3>
			<footer>
				<div class="date">${tent.price}</div>
				<div class="icons">
					<button>add basket</button>
				</div>
			</footer>
		</figcaption>
		<a href="#"></a>
	</figure>
</c:forEach>