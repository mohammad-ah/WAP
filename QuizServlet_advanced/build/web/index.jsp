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
        <p>your current score is <%= CorrectAnswers.getInstance().getCorrect() %> </p>
        <p>Guess the next number in sequence</p>
        <p>3, 1, 4, 5</p>
        <form method='post' action='Question1' >
            your answer: <input type="text" name="answer" size="20">
            <br>
            <input type="submit">
        </form>
    </body>
</html>