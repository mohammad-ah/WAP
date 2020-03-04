<%-- 
    Document   : BeerSelect
    Created on : Dec 8, 2019, 6:52:41 PM
    Author     : Dalia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1 align="center">Beer Selection Page</h1>
        <form method="POST" action="BeerServlet">
            Select beer characteristics
            <p>Color: 
                <select name="color" size="1">
                    <option value="light"> light </option>
                    <option value="amber"> amber </option>
                    <option value="brown"> brown </option>
                    <option value="dark"> dark </option>
                </select>
            </p>
            <br/><br/>
            <center>
                <input type="submit" />
            </center>
        </form>
    </body>
</html>
