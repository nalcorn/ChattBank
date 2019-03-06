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
        <title>Login</title>
    </head>
    <body>
        <h1>Login to your customer account</h1>
        <form name ="LoginForm" method ="POST" action ="loginServlet">
        <table id="t01">
            <tr>
                <td>Customer ID</td>
                <td>
                    <input type ="text" name ="idtb" />
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type ="password" name ="pwtb" />
                </td> 
            </tr>
            <tr>
                <td>
                    <input type ="submit" name ="submitbtn" value ="Login"/>
                </td>
                <td>
                    <input type ="reset" name ="clearbtn" value ="Clear"/>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>
