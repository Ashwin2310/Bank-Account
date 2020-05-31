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
public class Platinum extends State {//inheritance 
    
    @Override 
    public double makePurchase (double amount){
        return amount; //no transactional fee
    }//end makePurchase
    
    @Override 
    public State Validate (State st, double balance){
        if (balance < 10000)
            return new Silver();
        
        else if (balance < 20000)
            return new Gold();
        
            return st;        
    }//end Validate
    
}