<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <link rel="stylesheet" href="css/login/registration.css">


<div class="container">
  <h2>Sing Up<small>(enter data)</small></h2>
  
  <form:form action="loginprocesing" method="post">
    <div class="group">      
     <input name="username" type="text"/>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Name</label>
    </div>

    <div class="group">      
      <input name="password" type="password"/>
      <span class="highlight"></span>
      <span class="bar"></span>
      <label>Password</label>
    </div>
    
    <button class="action-button shadow animate green">Click</button>
  </form:form>
</div>