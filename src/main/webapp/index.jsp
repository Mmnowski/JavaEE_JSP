<%@page import="com.example.servletjspdemo.domain.Movie" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Drink list</title>
</head>
<body>
<h1>Drink list</h1>
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application"/>
<form action="rentMovie.jsp">
    <%
        storage.generateMovies();
        int amount;
        for (Movie movie : storage.getAllMovies()) {
            amount = movie.getAmount();
            out.print("<p>" + movie.getTitle() + ", reż. " + movie.getDirector() + ",   " + movie.getPrice() + "zł ");
            if (amount > 0) {
                out.print("</br> <input type='checkbox' value='" + movie.getTitle() + "' name='buy'/>");
                out.print("<input type='number' value='1' name='" + movie.getTitle() + "'/>");
                out.print(" Ilosc w magazynie: " + amount);
            } else {
                out.print("</br> <button disabled>Out of stock</button>");
            }
            out.println("</p>");
        }
    %>
    <button type="submit" name="rentmovies" value="Rent">Rent chosen movies</button>
</form>
</br>
</br>
</br>
</br>
</br>
<h2>Your basket:</h2>
<%
    String basket = (String) session.getAttribute("basket");
    if(basket != null){
        out.println(basket);
        out.println("<br/>Total price: " + session.getAttribute("totalPrice") + "zł");
    }
    else{
        out.println("Your basket is empty");
    }
%>
</body>
</html>