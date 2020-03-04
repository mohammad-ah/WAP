<%-- 
    Document   : result
    Created on : Dec 8, 2019, 6:24:31 PM
    Author     : Dalia
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="item" items="${styles}">
            <br/>
            <c:out value="try: ${item}"/>
        </c:forEach>
    </body>
</html>
