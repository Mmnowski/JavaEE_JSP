<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodano filmy</title>
</head>
<body>
<jsp:useBean id="movie" class="com.example.servletjspdemo.domain.Movie" scope="session" />

<jsp:setProperty name="movie" property="*" /> 

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />

<% 
  storage.add(movie);
%>

<p>Created a new movie order: </p>
<p>Title: ${movie.Title} </p>
<p>Director: ${movie.Director} </p>  
<p>First name: ${movie.Genre} </p>
<p>Price: ${movie.Ammount} </p>    
<p>
  <a href="showAllMovies.jsp">Show all orders</a>
</p>
</body>
</html>