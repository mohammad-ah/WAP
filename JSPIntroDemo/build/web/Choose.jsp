<%-- 
    Document   : Choose
    Created on : Mar 2, 2020, 2:26:06 PM
    Author     : moham
--%>

<%@page import="edu.mum.cs545.RadioState"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <title>Choose</title>
 </head>
 <body>
 <form method='post' action='ChooseServlet'>
 <p>Is JSP cool?</p>
 
 
 <%--<%! int JSPCool=1;boolean moonCheese=false;boolean JSFwayCool=false; %>--%>
 
 <!--{ RadioState.getInstance().getRadioJSPCool() ? "checked" :""}-->
 
 <input type='radio' value='1' name='radioJSPCool' <%=  RadioState.getInstance().radioJSPCool ? "checked" : "" %> ><span> Yes</span><br/>
 <input type='radio' value='0' name='radioJSPCool' <%=  RadioState.getInstance().radioJSPCool1 ? "checked" : "" %> ><span> No</span><br/>
 <input type='submit' name='btnSubmit' value='Submit'/>
 <p>Is JSF way cool?</p>
 <input type='radio' value='1' name='JSFwayCool' <%=  RadioState.getInstance().JSFwayCool ? "checked" : "" %> ><span>Yes</span><br/>
 <input type='radio' value='0' name='JSFwayCool' <%=  RadioState.getInstance().JSFwayCool1 ? "checked" : "" %> ><span>No</span><br/>
 <input type='submit' name='btnSubmit' value='Submit'/>
 <p>Is the moon made of cheese?</p>
 <input type='radio' value='1' name='moonCheese' <%=  RadioState.getInstance().moonCheese ? "checked" : "" %> ><span>Yes</span><br/>
 <input type='radio' value='0' name='moonCheese' <%=  RadioState.getInstance().moonCheese1 ? "checked" : "" %> ><span>No</span><br/>
 <input type='submit' name='btnSubmit' value='Submit'/>
 </form>
 </body>
</html>
