<!--=======================================================================

Class: Java III
Quarter: Spring 2016
Instructor: Ron Enz
Description:  ChattBank Lab 8
Due: 01/22/2016
Author Nicholas Alcorn


By turning in this code, I Pledge:
1. That I have completed the programming assignment independently.
2. I have not copied the code from a student or any source.
3. I have not given my code to any student.

-=======================================================================-->


<%@page import="Business.Account"%>
<%@page import="Business.Customer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Information</title>
    </head>
    <body>
        <% Customer c1 = (Customer)request.getSession().getAttribute("customer"); %>
        <h1>Account information for customer ID: <%= c1.getCustId() %></h1>
        <h1><%= c1.getCustFirstName() %> <%= c1.getCustLastName() %></h1>
        <h2><%= c1.getCustAddress() %></h2>
        <h2><%= c1.getCustEmail() %></h2>
        <table id="t01">
            <% for(int i =1; i<=c1.getCount(); i++){ %>
            <tr>
                <td>Account</td>
                <td><%= c1.getAcctNoAt(i-1) %></td>
            </tr> 
            <tr>
                <td>Type</td>
                <td><%= c1.getTypeAt(i-1) %></td>
            </tr>
            <tr>
                <td>Balance</td>
                <td><%= c1.getBalanceAt(i-1) %></td>
            </tr>
            <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
            <tr><td style="line-height:10px;" colspan=3>&nbsp;</td></tr>
            <% } %>
        </table>
    </body>
</html>
