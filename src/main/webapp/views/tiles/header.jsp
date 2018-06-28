<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="css/header.css">


<sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
	
<sec:authorize access="!hasRole('ROLE_ADMIN')">
	<form:form action="profile" method="get">
		<button>profile</button>
	</form:form>
</sec:authorize>

</sec:authorize>

<sec:authorize access="!isAuthenticated()">

	<form:form action="loginpage" method="get">
		<button>login</button>
	</form:form>
	
	<form:form action="registration" method="get">
		<button>registration</button>
	</form:form>

</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	
	<form:form action="base" method="get">
		<button>admin</button>
	</form:form>
	
</sec:authorize>
<br>
<sec:authentication property="name" />


<nav id="nav-1">
	<a class="link-1" href="index">Home</a> <a class="link-1" href="shop">Shop</a>
	<a class="link-1" href="contact">About us</a> <a class="link-1"
		href="aboutus">Contact</a>
</nav>

<a href="basket"><span><i class="shopping-cart"></i></span></a>

