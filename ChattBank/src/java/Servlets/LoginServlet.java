package Servlets;

/***********************************************************************
 * lab 6
 * Class: Java III
 * Quarter: Fall 2015
 * Instructor: Ron Enz
 * Description:  ChattBank Lab
 * Due: 02/04/2016
 * @author Nicholas Alcorn
 * @version 1.0
 * 
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 * 
 ***********************************************************************/

import   Business.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
            System.out.println("servlet reached");
            
            
            String userID = request.getParameter("idtb");
            String password = request.getParameter("pwtb");
            
            Customer c1 = new Customer();
            c1.selectDB(userID);
            
            HttpSession session = request.getSession();
            session.setAttribute("customer", c1);
            
            if(c1.getCustPassword().equals(password)){
                RequestDispatcher rs = request.getRequestDispatcher("DisplayAccounts.jsp");
                rs.include(request,response);
            }else{
                RequestDispatcher rs = request.getRequestDispatcher("ErrorPage.jsp");
                rs.include(request,response);
            }
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
