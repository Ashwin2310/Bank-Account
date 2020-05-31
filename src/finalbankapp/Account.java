package finalbankapp;

//@author Ashwin Thomas

public class Account {
    
	private double balance;

	Account() {
            balance = 100.00;//start of with an initial $100
            
	}//end default Constructor
        public Account (double balance){
            this.balance = balance;
        }//end Account constructor
        
        public double getBalance (){
            return balance;
        }//end getBalance
        
        public void setBalance (double balance){
            this.balance = balance;
        }//end setBalance
        
}//end Account class 