<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="css/shop/backpack.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Map</h1>

<c:forEach var="map" items="${maps}">
	<figure class="snip1518 hover">
		<div class="image">
			<img
				src="http://astur.com.ua/components/com_mijoshop/opencart/image/cache/data/book_shop/ASSA_map_EasternGorgany_2016_p2-1000x750.jpg"
				alt="sample99" />
		</div>
		<figcaption>
			<h5>Map</h5>
			<h3>${map.nameLacality}</h3>
		</figcaption>
		<footer>
			<div class="date">${map.price}</div>
			<div class="icons">
				<button>add basket</button>
			</div>
		</footer>
		<a href="#"></a>
	</figure>
</c:forEach>