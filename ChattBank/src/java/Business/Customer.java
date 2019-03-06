/***********************************************************************
 * lab 5
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
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
    /*Properties
    *******************************************************************/
    String driver = "jdbc:mysql://localhost:3306/ChattBankDB";
    String user = "root";
    String pass = "linux";
    String custId;
    String CustPassword;
    String custFirstName;
    String custLastName;
    String custAddress;
    String custEmail;
    AccountList aList = new AccountList();
    int count = 0;
    
    /*Constructors
    *******************************************************************/
    public Customer(){
        custId = "";
        CustPassword = "";
        custFirstName = "";
        custLastName = "";
        custAddress =  "";
        custEmail = "";
    }
    public Customer(String ID, String password, String firstName, 
                    String lastName, String address, String email){
        custId = ID;
        CustPassword = password;
        custFirstName = firstName;
        custLastName = lastName;
        custAddress =  address;
        custEmail = email; 
    }
        
    /*Setters
    *******************************************************************/
    public void setCustId(String ID){
        custId = ID;
    }
    public void setCustPassword(String password){
        CustPassword = password;
    }
    public void setCustFirstName(String firstName){
        custFirstName = firstName;
    }
    public void setCustLastName(String lastName){
        custLastName = lastName;
    }
    public void setCustAddress(String address){
        custAddress =  address;
    }
    public void setCustEmail(String email){
        custEmail = email; 
    }
    
    /*Getters
    *******************************************************************/
    public String getCustId(){
        return custId;
    }
    public String getCustPassword(){
        return CustPassword;
    }
    public String getCustFirstName(){
        return custFirstName;
    }
    public String getCustLastName(){
        return custLastName;
    }
    public String getCustAddress(){
        return custAddress;
    }
    public String getCustEmail(){
        return custEmail;
    }
    public String getAccountList(){
        return aList.display();
    }
    public int getCount(){
        return count;
    }
    public String getAcctNoAt(int i){
        return aList.getAcctNoAt(i);
    }
    public String getCidAt(int i){
        return aList.getCidAt(i);
    }
    public String getTypeAt(int i){
        return aList.getTypeAt(i);
    }
    public double getBalanceAt(int i){
        return aList.getBalanceAt(i);
    }
    
    
    /*Methods
    *******************************************************************/
    public void selectDB(String custID) 
                         throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "Select * from customers where CustID like '"+custID+"';");
            while(resultSet.next()){
                setCustId(resultSet.getString("CustID"));
                setCustPassword(resultSet.getString("CustPassword"));
                setCustFirstName(resultSet.getString("CustFirstName"));
                setCustLastName(resultSet.getString("CustLastName"));
                setCustAddress(resultSet.getString("CustAddress"));
                setCustEmail(resultSet.getString("CustEmail"));
            }
            this.selectCustAccounts();
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    public void selectCustAccounts() throws ClassNotFoundException, SQLException{
        //System.out.println("in selectCustAccount");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery ("Select AcctNo from accounts where cid like '"+getCustId()+"';");
            while(resultSet.next()){
                Account a1 = new Account();
                a1.selectDB(resultSet.getString("AcctNo"));
                aList.addAccount(a1);
                count++;
            }
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    public void insertDB()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into customers values('"+
                    getCustId()+"','"+getCustPassword()+"','"+
                    getCustFirstName()+"','"+getCustLastName()+"','"+
                    getCustAddress()+"','"+getCustEmail()+"')");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    public void deleteDB() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("delete from customers where CustID ='"+getCustId()+"';");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
        setCustId("");
        setCustPassword("");
        setCustFirstName("");
        setCustLastName("");
        setCustAddress("");
        setCustEmail("");
    }
    
    public void updateDB() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("update customers "+
                    "set custpassword='"+getCustPassword()+"'"+
                    "', custfirstname='"+getCustFirstName()+
                    "', custlastname='"+getCustLastName()+
                    "', custaddress='"+getCustAddress()+
                    "', custemail='"+getCustEmail()+
                    "' where custID='"+getCustId());
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    public String toString(){
        String temp = aList.display();
        return"Customer ID is: "+custId+"\n"+
              "First Name is: "+custFirstName+"\n"+
              "Last Name is: "+custLastName+"\n"+
              "Address is: "+custAddress+"\n"+
              "Email ID is: "+custEmail+"\n\n"+
              temp;
    }
    
    public String display(){
        return toString();
    }
    
    /*Main Tester
    *******************************************************************/
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Customer c1 = new Customer();
        String ID = "4001";
        c1.selectDB(ID);
        System.out.println(c1.toString());
        c1.deleteDB();
        System.out.println(c1.toString());
        System.out.println();
        Customer c2 = new Customer(
                "4001", "1235", "Gary", "Indiana","123 main street","gary@indiana.com");
        System.out.println(c2.toString());
        System.out.println("--------------------------------------------------");
        
        c2.insertDB();
        Customer c3 = new Customer();
        c3.selectDB("3001");
        System.out.println(c3.toString());
    }
}
