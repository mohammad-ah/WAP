<%-- 
    Document   : Question4
    Created on : Mar 2, 2020, 9:41:56 PM
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
        <p>your current score is <%= CorrectAnswers.getInstance().getCorrect() %></p>
        <p>Guess the next number in sequence</p>
        <p>2, 3, 5, 7, 11</p>
        <form method='post' action='Question4' >
            your answer: <input type="text" name="answer" size="20">
            <br>
            <input type="submit">
        </form>
        
        <%
                session.setAttribute("status", ""); 
            %>
       <form method="get" action='Question4'>
            
            <input type="submit" name="hint" value="Hint">
        </form>
        
        <p>${status}</p>
    </body>
</html>
