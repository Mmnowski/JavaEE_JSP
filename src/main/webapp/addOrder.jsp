<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodano zamówienie</title>
</head>
<body>
<jsp:useBean id="order" class="com.example.servletjspdemo.domain.Order" scope="session" />

<jsp:setProperty name="order" property="*" /> 

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />

<% 
  storage.add(order);
%>

<p>Created a new order: </p>
<p>First name: ${order.firstName} </p>
<p>First name: ${order.lastName} </p>
<p>Year of birth: <jsp:getProperty name="order" property="orderDay"></jsp:getProperty></p>
<p>
  <a href="showAllOrders.jsp">Show all orders</a>
</p>
</body>
</html>