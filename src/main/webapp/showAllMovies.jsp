<%@page import="com.example.servletjspdemo.domain.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rent a movie</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<%
  for (Movie movie : storage.getAllMovies()) {
	  out.println("<p>Title: " + movie.getTitle() + "; Director: " + movie.getDirector() + "; Genre: " + movie.getGenre() + "; Price: " + movie.getAmount() + "</p>");
  }
%>
<p>
  <a href="getMovieData.jsp">Add another movie</a>
</p>

</body>
</html>