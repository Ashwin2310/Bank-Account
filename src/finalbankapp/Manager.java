/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalbankapp;

/**
 *
 * @author Ashwin Thomas
 */

import java.io.File;
import java.io.PrintWriter;
public class Manager {
    
   private String username;//variables are declared as private
   private String password;
   private String role;
   
    public Manager (String username, String password){
        this.username = username;
        this.password = password;           
    }//end Manager Constructor
    
    public void addNewCustomer (String username, String password){
   
        File newCustomer = new File (username + ".txt");//creating a new textfile
        PrintWriter writer = null;
        try {
            writer = new PrintWriter (newCustomer.getPath(), "UTF-8");//allows for special characters with Unicode
        }//end try
        catch (Exception e){
        System.out.println ("File creation failed");
        }//end catch
            
        writer.println (username);
        writer.println (password);
        writer.println ("Customer");
        writer.println ("100");
        writer.close();     
              
    }//end addNewCustomer ()
    
    public  void deleteCustomer (String username){
        File file = new File (username + ".txt");
        
        if (file.delete())
            System.out.println ("File has been successfully deleted");
        else
            System.out.println ("File has failed to delete");
        
    }//end deleteCustomer ()
    
}//end Manager Class

    