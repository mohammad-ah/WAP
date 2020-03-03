<%-- 
    Document   : Result
    Created on : Mar 2, 2020, 9:42:46 PM
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
        <p>You have completed the Number Quiz, with a score of <%= CorrectAnswers.getInstance().getCorrect() %> out of 5</p>
    </body>
</html>

