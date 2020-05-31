/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalbankapp;

/**
 * Summary : This is a mutable class (the level can be changed) and implements  all the functions that the customer can do with this program
 * 
 * Abstraction function : AF(c) = c.customerInfo.username + c.customerInfo.password + c.account.getBalance + c.getLevel
 * 
 * Rep Invariant : RI (c) = c.customerInfo != NULL && (first 2 lines of c.customerInfo)!=null c.account != NULL && c.level != null
 * 
 * @author Ashwin Thomas
 */

//Importing files
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {
    private final Account account;
    private final File customerInfo; 
    private State level;
    
    //Effects : Customer is created and a level is assigned based on the available balance
    //Requires :  the customerInfo and balance cannot be null
    
    public Customer (String username, String password, double balance, File customerInfo){
    
            if (balance < 10000)
            this.level = new Silver ();
        else if (balance < 20000)
            this.level = new Gold ();
        else
            this.level = new Platinum();
        
        
            this.account = new Account (balance);
            this.customerInfo = customerInfo;
        
        
    }//end Customer constructor
    
    //Effects : Checks if the given string is positive. If yes, then the value is added to the account balance
    //(method is boolean, so it returns true)
    
    //Requires : Instance variable balance is modified along with new level change
    
    public boolean depositMoney (String amount){
        
        double depositAmount;
        
        try{
            depositAmount = Double.valueOf(amount);//returns the double value of a string object
        }//end try
        catch (NumberFormatException e){
            return false;
        }//end catch
        
        if (depositAmount < 0)
            return false; //must be positive value
        
        this.account.setBalance (this.getBalance() + depositAmount);
        this.level = this.level.Validate(this.level, this.getBalance());
        return true;
                
    }//end depositMoney ()
    
    //Effects : Checks if the given string is a valid request. If yes, then the value is subtracted to the account balance 
    //(method is boolean, so it returns true)
    
    //Requires : Instance variable balance is modified along with new level change
    
    public boolean withdrawMoney (String amount){
        
        double withdrawAmount;
        
        try{
            withdrawAmount = Double.valueOf(amount);//returns the double value of a string object
        }//end try
        catch (NumberFormatException e){
            return false;
        }//end catch
        
        if (withdrawAmount < this.getBalance()){
        this.account.setBalance (this.getBalance() - withdrawAmount);
        this.level = this.level.Validate(this.level, this.getBalance());
        return true;
        }//end if
        
        return false;
                
    }//end withdrawMoney ()
    
    //Effects : Returns the balance of the bank account
    //Requires : this.account != null and this.account.balance != null
    public double getBalance (){
        return this.account.getBalance();
    }
    
    //Effects : Returns the string representation of a given level
    //Requires : this.level != null
    public String getLevel (){
        if (this.level instanceof Silver)
        return ("Silver");
        else if (this.level instanceof Gold)
        return ("Gold");
        
        return ("Platinum");
    }//end getLevel ()
    
    
    //Effects: Checks if the purchase amount (in String format) is valid. If yes, then it is subtracted from the account number
    //Modifies : The "balance" instance variable is modified along with new level changes
    public boolean makePurchase (String amount){
        
        double purchaseAmount;
        
        try{
            purchaseAmount = Double.valueOf(amount);//returns the double value of a string object
        }//end try
        catch (NumberFormatException e){
            return false;
        }//end catch
        
        if (purchaseAmount < 50)//all purchases should be above $50
            return false;
        
        purchaseAmount = this.level.makePurchase (purchaseAmount);
        
        if (purchaseAmount <= this.account.getBalance()){
        this.account.setBalance (this.getBalance() - purchaseAmount);
        this.level = this.level.Validate(this.level, this.getBalance());
        return true;
        }//end if
       
        return false;
                
    }//end makePurchase ()
    
    //Effects : New balances is added to the customer file
    //Modifies : the customer file is modified (this.customerInfo)
    public void Logout(){
        Scanner readFile = null; 
        try{
            readFile = new Scanner (this.customerInfo);
        }//end try
        catch (FileNotFoundException e){
        System.out.println ("File failed to read");          
        }//end catch       
        
        String username = readFile.nextLine ();
        String password = readFile.nextLine ();
        readFile.nextLine ();
        readFile.close();
        
        PrintWriter writer = null;
        try{
            writer = new PrintWriter (this.customerInfo.getPath(), "UTF-8");
        }//end try
        catch (Exception e){
            System.out.println ("Failed to read file");
        }//end catch
             
        writer.println (username);
        writer.println (password);
        writer.println ("Customer");
        writer.println (this.account.getBalance());
        writer.close();
               
    }//end Logout
    
      //TO STRING AND REP OK METHODS
    
   //Effects : String representation of a customer is returned
    
    @Override
    public String toString(){
         Scanner readFile = null; 
        try{
            readFile = new Scanner (this.customerInfo);
        }//end try
        catch (FileNotFoundException ex){
        System.out.println ("File failed to read");          
        }//end catch       
        
        String username = readFile.nextLine ();
        String password = readFile.nextLine ();
        
        return "Username: " +username+ ", Password: "+password+", Account Balance: "+this.account.getBalance() + ", Level: "+ this.getLevel();
    }//end toString ()
    
    //Effects : Rep OK checks if the class has proper representation
    
    public boolean repOK (){
        if (this.customerInfo == null)
            return false;
        
        Scanner readFile = null; 
        try{
            readFile = new Scanner (this.customerInfo);
        }//end try
        catch (FileNotFoundException ex){
        System.out.println ("File failed to read");          
        }//end catch       
        
        String username = readFile.nextLine ();
        String password = readFile.nextLine ();
        
        if(username != null && password != null && this.level != null && this.account!= null){
          return true;
        }//end if
        
        return false;
    }//end repOK ()
    
    
}//end Customer class
