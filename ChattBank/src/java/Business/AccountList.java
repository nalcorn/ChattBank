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

import java.util.ArrayList;
import java.util.List;


public class AccountList {
   /*Properties
    *******************************************************************/
    List<Account> list = new ArrayList<>();
    int count;
    
    /*Constructors
    *******************************************************************/
    public void AccountList(){
        count = 0;
    }
    
    /*Setters
    *******************************************************************/
    public void setCount(){
        count = list.size();
    }
        
    /*Getters
    *******************************************************************/
    public int getCount(){
        return list.size();
    }
    public String getAcctNoAt(int i){
        return list.get(i).getAcctNo();
    }
    public String getCidAt(int i){
        return list.get(i).getCid();
    }
    public String getTypeAt(int i){
        return list.get(i).getType();
    }
    public double getBalanceAt(int i){
        return list.get(i).getBalance();
    }
    
    /*Methods
    *******************************************************************/
    public void addAccount(Account acctObj){
        list.add(acctObj);
        count++;
    }
    
    public void removeAccount(Account acctObj){
        list.remove(acctObj);
        count--;
    }
    
    public String toString(){
        String temp = "";
        for (int i = 0; i < list.size(); i++){
            temp += list.get(i).display();
            temp += "\n";
        }
        return temp;
    }
    
    public String display(){
        return toString();
    }
    
    /*Main Tester
    *******************************************************************/
}
