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
public abstract class State {//STATE DESIGN PATTERN! 
    
    public abstract double makePurchase (double amount);
    
    public abstract State Validate (State st, double balance);
    
}//end State abstract class
