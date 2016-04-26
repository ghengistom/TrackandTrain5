<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WorkOut List</title>
</head>
<body>

<h2>Product List</h2>
        <a href="<c:url value="/create?action=viewCart" />">View Cart</a><br /><br />
        <%
            @SuppressWarnings("unchecked")
            Map<Integer, String> products =
                    (Map<Integer, String>)request.getAttribute("products");

            for(int id : products.keySet())
            {
                %><a href="<c:url value="/create">
                    <c:param name="action" value="addToCart" />
                    <c:param name="productId" value="<%= Integer.toString(id) %>"/>
                </c:url>"><%= products.get(id) %></a><br /><%
            }
        %>

</body>
</html>



