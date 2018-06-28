<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="css/shop/backpack.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Backpack</h1>

<c:forEach var="backpack" items="${backpacks}">
	<figure class="snip1518">
		<div class="image">
			<img
				src="http://d1kcl3yiuixneo.cloudfront.net/wp-content/uploads/osprey-talon-33-green-travel-backpack.jpg"
				alt="sample101" />
		</div>
		<figcaption>
			<h5>Backpack</h5>
			<h3>${backpack.brand}</h3>
			<footer>
				<div class="date">${backpack.price}</div>
				<div class="icons">

					<form:form action="buyBackpack/${backpack.id}" method="get">

						<button>add basket</button>
					</form:form>
					<%-- <form:form action="pageBackpack/${backpack.id}" method="get"> 
						<button>information</button>
					</form:form>  --%>

				</div>
			</footer>
		</figcaption>

	</figure>
</c:forEach>

<br>
<%-- 
<c:set var="currentPage" value="${backpacks.number}"/>
<c:set var="totalPages" value="${totalPages-1}"/>


<c:if test="${currentPage != 0}">
    <a href="/pageable/${backpacks.number-1}/5">previous</a>
</c:if>


<c:forTokens var="page" items="${pages}" delims="-">
    <a href="/pageable/${page}/5">${page}</a>
</c:forTokens>


<c:if test="${currentPage < totalPages}">
    <a href="/pageable/${backpacks.number+1}/5">next</a>
</c:if> --%>





<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>