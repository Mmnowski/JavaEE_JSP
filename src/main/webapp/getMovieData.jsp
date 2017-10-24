<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create an order</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<jsp:useBean id="movie" class="com.example.servletjspdemo.domain.Movie" scope="session" />

<form action="addOrder.jsp">

  First name :<input type="text" name="firstName" value="${order.firstName}" /><br />
  First name :<input type="text" name="lastName" value="${order.lastName}" /><br />
  Year of birth :<input type="text"  name="orderDay" value="${order.orderDay}" /><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>