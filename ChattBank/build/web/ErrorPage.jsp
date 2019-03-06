<%@page import="Business.Customer"%>
<!--=======================================================================

Class: Java III
Quarter: Spring 2016
Instructor: Ron Enz
Description:  ChattBank Lab 7
Due: 01/22/2016
@author Nicholas Alcorn
@version 1.0

By turning in this code, I Pledge:
1. That I have completed the programming assignment independently.
2. I have not copied the code from a student or any source.
3. I have not given my code to any student.

-=======================================================================-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <% 
            Customer c1 = (Customer)request.getSession().getAttribute("customer");
        %>
        <h1>Error Logging in for customer ID: <%= c1.getCustId() %></h1>
        <a href="login.jsp">Login</a>
    </body>
</html>
