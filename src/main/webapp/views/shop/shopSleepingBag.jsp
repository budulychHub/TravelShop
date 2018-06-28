<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="css/shop/backpack.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Sleeping bag</h1>

<c:forEach var="sleepingBag" items="${sleepingBags}">
	<figure class="snip1518">
		<div class="image">
			<img
				src="http://www.huskyeu.eu/temp/img/mi/mikro-sleeping-bag-mikro-2c-w1200-h1200-e-98992d44414de0c6baa12cfd032d3248.jpg"
				alt="sample101" />
		</div>
		<figcaption>
			<h5>Sleeping bag</h5>
			<h3>${sleepingBag.brand}</h3>
			<footer>
				<div class="date">
				${sleepingBag.price}
				</div>
				<div class="icons">
					<button>add basket</button>
				</div>
			</footer>
		</figcaption>
		<a href="#"></a>
	</figure>
</c:forEach>
