<%-- 
    Document   : index
    Created on : Mar 2, 2020, 9:40:31 PM
    Author     : moham
--%>

<%@page import="mum.cs472.CorrectAnswers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>The number Quiz</h1>
        <p><%= CorrectAnswers.getInstance().getError() %></p>
        <form method='post' action='Question1' name="form">
            Your Age:<input type="text" name="age" size="5"><br><br>

            <p>your current score is <%= CorrectAnswers.getInstance().getCorrect() %> </p>
            <p>Guess the next number in sequence</p>
            <p>3, 1, 4, 5</p>
        
            your answer: <input type="text" name="answer" size="20">
            <br>
            <input type="submit"><br>
        </form>
            
       
       <%
                session.setAttribute("status", ""); 
            %>
       <form method="get" action='Question1'>
            
            <input type="submit" name="hint" value="Hint">
        </form>
        
        <p>${status}</p>
        
        
        
       
    </body>
</html>