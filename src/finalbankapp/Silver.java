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
public class Silver extends State {//inheritance 
    
    @Override 
    public double makePurchase (double amount){
        return amount + 20;//transactional fee
    }//end makePurchase
    
    @Override 
    public State Validate (State st, double balance){
        if (balance < 10000)
            return st;
        
        else if (balance < 20000)
            return new Gold();
        
           return new Platinum ();
        
    }//end Validate
    
}
