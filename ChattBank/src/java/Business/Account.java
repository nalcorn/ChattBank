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

public class Account {
    /**Properties
    *******************************************************************/
    String driver = "jdbc:mysql://localhost:3306/ChattBankDB";
    String user = "root";
    String pass = "linux";
    String acctNo;
    String cid;
    String type;
    double balance;
    
    /*Constructors
    *******************************************************************/
    public Account(){
        
    }   
    public Account(String AcctNo, String cid, String type, double balance){
        this.acctNo = AcctNo;
        this.cid = cid;
        this.type = type;
        this.balance = balance;
    }
    
    /*Setters
    *******************************************************************/
    public void setAcctNo(String AcctNo){
        this.acctNo = AcctNo;
    }
    public void setCid(String Cid){
        this.cid = Cid;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setBalance(double balance){
        this.balance = balance;    
    }
    
    /*Getters
    *******************************************************************/
    public String getAcctNo(){
        return acctNo;
    }
    public String getCid(){
        return cid;
    }
    public String getType(){
        return type;
    }
    public double getBalance(){
        return balance;
    }
    
    /*Methods
    *******************************************************************/
    public void selectDB(String AcctNo) 
                         throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery (
                    "Select * from accounts where AcctNo like '"+AcctNo+"';");
            while(resultSet.next()){
                setAcctNo(resultSet.getString("AcctNo"));
                setCid(resultSet.getString("Cid"));
                setType(resultSet.getString("type"));
                setBalance(Double.parseDouble(resultSet.getString("balance")));
            }
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
            statement.executeUpdate("delete from customers where CustID ='"+getAcctNo()+"';");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
        setCid("");
        setType("");
        setBalance(0);
    }
    
    public void insertDB()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("insert into customers values('"+
                    getAcctNo()+"','"+getCid()+"','"+
                    getType()+"','"+getBalance()+"')");
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    public void updateDB() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection
                (driver, user, pass);
            Statement statement = con.createStatement();
            statement.executeUpdate("update accounts "+
                    "SET balance ='"+getBalance()+"'"+
                    "', acctno ='"+getAcctNo()+
                    "', type ='"+getType()+
                    "' where cid='"+getCid());
        } catch (java.sql.SQLException ex){
            throw ex;
        }finally{
            if(con != null) 
                con.close();
        }
    }
    
    public void deposit(double amt) throws ClassNotFoundException, SQLException{
        setBalance(getBalance()+amt);
        updateDB();
    }
    
    public void withdraw(double amt) throws ClassNotFoundException, SQLException{
        setBalance(getBalance()-amt);
        updateDB();
    }
    
    public String toString(){
        return"Account Number is: "+acctNo+"\n"+
              "Cid is: "+cid+"\n"+
              "type is: "+type+"\n"+
              "blanace is: "+balance+"\n";
    }
    
    public String display(){
        return toString();
    }
    
    /*Main Tester
    *******************************************************************/
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Account a1 = new Account();
        a1.selectDB("90000");
        System.out.println(a1.toString());
        Account a2 = new Account("70000","9001","SAV",1000000.23);
        System.out.println(a2.toString());
        
    }
}
