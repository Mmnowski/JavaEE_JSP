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

<form action="addedDrink.jsp">

  Title :<input type="text" name="name" value="${movie.title}" /><br />
  Director :<input type="text" name="name" value="${movie.director}" /><br />
  Genre :<input type="text" name="name" value="${movie.genre}" /><br />
  Price :<input type="text"  name="price" value="${movie.price}" /><br />
  Amount :<input type="text"  name="amount" value="${movie.amount}" /><br />
  <input type="submit" value=" OK ">

</form>

</body>
</html>