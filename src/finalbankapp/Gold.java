/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalbankapp;

/**
 *
 * @author ashwi
 */
public class Gold extends State {//inheritance 
    
    @Override 
    public double makePurchase (double amount){
        return amount + 10;//transactional fee
    }//end makePurchase
    
    @Override 
    public State Validate (State st, double balance){
        if (balance < 10000)
            return new Silver();
        
        else if (balance < 20000)
            return st;
        
            return new Platinum ();
        
    }//end Validate
    
}