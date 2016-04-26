<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>View Cart</h2>
        <a href="<c:url value="/create" />">WorkOut List</a><br /><br />
        <a href="<c:url value="/create?action=emptyCart" />">Empty Cart</a><br /><br />

 <%
            @SuppressWarnings("unchecked")
            Map<Integer, String> products =
                    (Map<Integer, String>)request.getAttribute("products");
            @SuppressWarnings("unchecked")
            Map<Integer, Integer> cart =
                    (Map<Integer, Integer>)session.getAttribute("cart");

            if(cart == null || cart.size() == 0)
                out.println("Your cart is empty.");
            else
            {
                for(int id : cart.keySet())
                {
                    out.println(products.get(id) + " (qty: " + cart.get(id) +
                            ")<br />");
                }
            }
        %>
        
</body>
</html>