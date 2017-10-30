<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Added a drink</title>
</head>
<body>
<jsp:useBean id="movie" class="com.example.servletjspdemo.domain.Movie" scope="session"/>
<jsp:setProperty name="movie" property="*"/>
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application"/>

<%
  String availableMovie[] = request.getParameterValues("buy");
  Double totalPrice = (Double) session.getAttribute("totalPrice");
  if (totalPrice == null) {
    totalPrice = 0.0;
  }
  String basket = (String) session.getAttribute("basket");
  if (basket == null) {
    basket = "";
  }
  for (String chosenMovie : availableMovie) {
    int amount = Integer.parseInt(request.getParameter(chosenMovie));
    if (amount < 1){
      out.println("<h2>Can't buy " + chosenMovie + ", you tried to buy more then in stock or 0</h2>");
      continue;
    }
    Double price = storage.rentMovie(chosenMovie, amount);
    if(price == 0.0){
      out.println("<h2>Can't buy " + chosenMovie + ", you tried to buy more then in stock</h2>");
      continue;
    }
    totalPrice += amount * price;
    basket += amount + " x " + chosenMovie + " " + amount * price + " zł<br/>";
    out.println("<h2>You bought " + amount + " x " + chosenMovie + "</h2>");
  }
  session.setAttribute("basket", basket);
  session.setAttribute("totalPrice", totalPrice);
%>

<p>
  <a href="index.jsp">Show all drinks</a>
</p>
</body>
</html>