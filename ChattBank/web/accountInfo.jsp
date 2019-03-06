<!--=======================================================================

Class: Java III
Quarter: Spring 2016
Instructor: Ron Enz
Description:  ChattBank Lab 6
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
        <title>Account Information</title>
    </head>
    <body>
        <h1>Account Information</h1>
        <form name ="AccountLookupForm" method ="POST" action ="AccountLookupServlet">
        <table id="t02">
            <tr>
                <td>Account Number</td>
                <td>
                    <input type ="text" name ="acctNo" />
                </td>
            </tr>
            <tr>
                <td>Customer ID</td>
                <td>
                    <input type ="text" name ="id" />
                </td>
            </tr>
            <tr>
                <td>Type</td>
                <td>
                    <input type ="text" name ="type" />
                </td> 
            </tr>
            <tr>
                <td>Balance</td>
                <td>
                    <input type ="text" name ="balance" />
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
