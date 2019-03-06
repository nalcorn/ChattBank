<!--=======================================================================

Class: Java III
Quarter: Spring 2016
Instructor: Ron Enz
Description:  ChattBank Lab 7
Due: 01/22/2016
Author Nicholas Alcorn


By turning in this code, I Pledge:
1. That I have completed the programming assignment independently.
2. I have not copied the code from a student or any source.
3. I have not given my code to any student.

-=======================================================================-->

<%@page import="Business.Account"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Information</title>
    </head>
    <body>
        <% Account a1 = (Account)request.getSession().getAttribute("account"); %>
        
        <h1>Account Information</h1>
        <form name ="AccountLookupForm" method ="POST" action ="AccountLookupServlet">
        <table id="t02">
            <tr>
                <td>Account Number</td>
                <td>
                    <input type ="text" name ="acctNo" value=<%= a1.getAcctNo() %> />
                </td>
            </tr>
            <tr>
                <td>Customer ID</td>
                <td>
                    <input type ="text" name ="id" value=<%= a1.getCid() %> />
                </td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <input type ="text" name ="type" value=<%= a1.getType() %> />
                </td> 
            </tr>
            <tr>
                <td>Balance</td>
                <td>
                    <input type ="text" name ="balance" value=<%= a1.getBalance() %> />
                </td> 
            </tr>
            <tr>
                <td>
                    <input type ="submit" name ="lookupbtn" value ="Look Up"/>
                </td>
                <td>
                    <input type ="reset" name ="clearbtn" value ="Clear"/>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
