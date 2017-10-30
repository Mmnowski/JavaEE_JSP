<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Added new movie to the database</title>
</head>
<body>
<jsp:useBean id="movie" class="com.example.servletjspdemo.domain.Movie" scope="session" />

<jsp:setProperty name="movie" property="*" />

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />

<%
    storage.add(movie);
%>

<p>Following drink has been added to shop: </p>
<p>Title: ${movie.title} </p>
<p>Director: ${movie.director}</p>
<p>Genre: ${movie.genre}</p>
<p>Price: ${movie.price}</p>
<p>Amount: ${movie.amount}</p>
<p>
    <a href="showAllMovies.jsp">Show all movies</a>
</p>
</body>
</html>