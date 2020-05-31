/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalbankapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;//Button, Label....
import javafx.scene.layout.*;//Stackpane, Vbox..
import javafx.geometry.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;



/**
 *
 * @author Ashwin Thomas
 */
public class ProjectGUI extends Application {
    
    Stage window;
    Manager m;
    Customer c;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Welcome to Ashwin's Bank");
        
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setVgap(30);
        grid.setHgap(30);
        
        Label Username = new Label("Username:");
        GridPane.setConstraints(Username, 0, 0);
        
        Label Password = new Label("Password:");
        GridPane.setConstraints(Password, 0, 1);
        
        Label Role = new Label("Role: (customer or manager?)");
        GridPane.setConstraints(Role, 0, 2);
        
        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);
    
        TextField passInput = new TextField();
        GridPane.setConstraints(passInput, 1, 1);

        TextField roleInput = new TextField();
        GridPane.setConstraints(roleInput, 1, 2);
        
        Button loginButton = new Button("Log In");
        //loginButton.getStyleClass().add("button");

        GridPane.setConstraints(loginButton, 1,4);
        
        Label error = new Label();
        GridPane.setConstraints(error, 0, 4);
        GridPane.setHgrow(error, Priority.ALWAYS);
        
        grid.getChildren().addAll(Username, usernameInput, Password, passInput, Role, roleInput, loginButton, error);
        Scene scene = new Scene(grid, 700, 500);
        //ProjectGUI.class.getResource("GUIColor.css").toExternalForm();
        window.setScene(scene);
        
        //manager scene
        GridPane Mgrid = new GridPane();
        Mgrid.setPadding(new Insets(15, 15, 15, 15));
        Mgrid.setVgap(30);
        Mgrid.setHgap(30);
        
        Label Mwelcome = new Label("Welcome, Manager!");
        GridPane.setConstraints(Mwelcome, 0, 0);
        
        Button logout=new Button("Logout");
        GridPane.setConstraints(logout, 0, 4);
        
        
        Button addCust=new Button("Add Customer");
        GridPane.setConstraints(addCust, 0, 2);
        
        Button delCust = new Button("Delete Customer");
        GridPane.setConstraints(delCust, 1, 2);
        
        
        
        Mgrid.getChildren().addAll(logout,addCust,delCust,Mwelcome); 
        Scene Mscene = new Scene(Mgrid,700,500);
        
                
        //Create Customer Scene
        
        GridPane MAddGrid = new GridPane();
        MAddGrid.setPadding(new Insets(15, 15, 15, 15));
        MAddGrid.setVgap(30);
        MAddGrid.setHgap(30);
        
        Label AddCustomer = new Label("Add Customer");
        GridPane.setConstraints(AddCustomer, 0, 0);
        
        Label enterUser = new Label("Enter Username:");
        GridPane.setConstraints(enterUser, 0, 1);
        
        TextField newUserInput = new TextField();
        GridPane.setConstraints(newUserInput, 1, 1);
        
        Label enterPass = new Label("Enter Password:");
        GridPane.setConstraints(enterPass, 0, 2);
        
        TextField newUserPass = new TextField();
        GridPane.setConstraints(newUserPass, 1, 2);
        
        Button addC = new Button("Add Customer");
        GridPane.setConstraints(addC,0,3);
        
        Button backToMsceneA = new Button("Go Back");
        GridPane.setConstraints(backToMsceneA, 1, 3);
        
        
        Label Merror = new Label("");
        GridPane.setConstraints(Merror, 0, 4);
        
        MAddGrid.getChildren().addAll(AddCustomer,enterUser,newUserInput,enterPass,newUserPass,addC,backToMsceneA, Merror);
        Scene MAddScene = new Scene(MAddGrid,700,500);
        
        //Delete Customer Scene
        
        GridPane delCustGrid = new GridPane();
        delCustGrid.setPadding(new Insets(15, 15, 15, 15));
        delCustGrid.setVgap(30);
        delCustGrid.setHgap(30);
        
        Label delCustLabel = new Label("Delete Customer");
        GridPane.setConstraints(delCustLabel, 0, 0);
        
        Button delCustButton = new Button("Delete Customer");
        GridPane.setConstraints(delCustButton, 0, 2);
        
        Button backToMsceneD = new Button("Go Back");
        GridPane.setConstraints(backToMsceneD, 1, 2);
        
        
        Label enterUserD = new Label("Enter Username:");
        GridPane.setConstraints(enterUserD, 0, 1);
        
        TextField newUserInputD = new TextField();
        GridPane.setConstraints(newUserInputD, 1, 1);

        Label Derror = new Label();
        GridPane.setConstraints(Derror, 0, 3);
        
        delCustGrid.getChildren().addAll(delCustLabel,delCustButton,newUserInputD,backToMsceneD,enterUserD,Derror);
        Scene delCustScene = new Scene(delCustGrid,700,500);
        
        
        
        //Customer Scene
        
        GridPane Cgrid = new GridPane();
        Cgrid.setPadding(new Insets(15, 15, 15, 15));
        Cgrid.setVgap(30);
        Cgrid.setHgap(30);
        
        Label wCustomer = new Label("Welcome Customer");
        GridPane.setConstraints(wCustomer, 0, 0);
        
        Label stateDisp = new Label();
        GridPane.setConstraints(stateDisp, 0, 1);
        
        Button Withdraw = new Button("Withdraw Money");
        GridPane.setConstraints(Withdraw, 0, 3);
        
        Button Deposit = new Button("Deposit Money");
        GridPane.setConstraints(Deposit, 1, 3);
        
        Button CheckBalance = new Button("Check Balance");
        GridPane.setConstraints(CheckBalance, 0, 5);
        
        Button makePurchase = new Button("Make Purchase");
        GridPane.setConstraints(makePurchase, 1, 5);
        
        Button Logout = new Button("Logout");
        GridPane.setConstraints(Logout, 0, 7);
        
        Cgrid.getChildren().addAll(wCustomer,Withdraw,Deposit,CheckBalance,makePurchase,Logout,stateDisp);
        Scene Cscene = new Scene(Cgrid,700,500);
        
        
        //Customer Withdraw Scene
        
        GridPane CWgrid = new GridPane();
        
        CWgrid.setPadding(new Insets(15, 15, 15, 15));
        CWgrid.setVgap(30);
        CWgrid.setHgap(30);
        
        Label CWlabel = new Label("Withdraw Money");
        GridPane.setConstraints(CWlabel, 0, 0);
        
        Label CWenter = new Label("Enter Amount: ");
        GridPane.setConstraints(CWenter, 0, 1);
        
        TextField CWamount = new TextField(); 
        GridPane.setConstraints(CWamount, 1, 1);
        
        Button CWwithdraw = new Button("Withdraw");
        GridPane.setConstraints(CWwithdraw, 0, 2);
        
        Button CWback = new Button("Go Back");
        GridPane.setConstraints(CWback, 1, 2);
        
        Label CWerror = new Label();
        GridPane.setConstraints(CWerror, 0, 3);
        
        CWgrid.getChildren().addAll(CWlabel, CWenter, CWamount, CWwithdraw, CWback, CWerror);
        Scene CWscene = new Scene(CWgrid,700, 500);
        
        //Customer Deposit Scene
        
        GridPane CDgrid = new GridPane();
        
        CDgrid.setPadding(new Insets(15, 15, 15, 15));
        CDgrid.setVgap(39);
        CDgrid.setHgap(30);
        
        Label CDlabel = new Label("Deposit Money");
        GridPane.setConstraints(CDlabel, 0, 0);
        
        Label CDenter = new Label("Enter Amount: ");
        GridPane.setConstraints(CDenter, 0, 1);
        
        TextField CDamount = new TextField(); 
        GridPane.setConstraints(CDamount, 1, 1);
        
        Button CDdeposit = new Button("Deposit");
        GridPane.setConstraints(CDdeposit, 0, 2);
        
        Button CDback = new Button("Go Back");
        GridPane.setConstraints(CDback, 1, 2);
        
        Label CDerror = new Label();
        GridPane.setConstraints(CDerror, 0, 3);
        
        CDgrid.getChildren().addAll(CDlabel, CDenter, CDamount, CDdeposit, CDback, CDerror);
        Scene CDscene = new Scene(CDgrid,700, 500);
        
        //Check Balance Scene
        
        GridPane CCBgrid = new GridPane();
        
        CCBgrid.setPadding(new Insets(15, 15, 15, 15));
        CCBgrid.setVgap(30);
        CCBgrid.setHgap(30);
        
        Label CCBlabel = new Label();
        GridPane.setConstraints(CCBlabel, 0, 1);
        
        Button CCBback = new Button("Go Back");
        GridPane.setConstraints(CCBback, 0, 3);
        
        CCBgrid.getChildren().addAll(CCBlabel,CCBback);
        Scene CCBscene = new Scene(CCBgrid,700, 500);
        
        //
        GridPane MPgrid = new GridPane();
        
        MPgrid.setPadding(new Insets(15, 15, 15, 15));
        MPgrid.setVgap(30);
        MPgrid.setHgap(30);
        
        Label MPlabel = new Label("Minimum purchase must be $50");
        GridPane.setConstraints(MPlabel, 0, 0);
        
        Label MPstate = new Label();
        GridPane.setConstraints(MPstate, 0, 1);
        
        Label MPenter = new Label("Amount of Purchase");
        GridPane.setConstraints(MPenter, 0, 2);
        
        TextField MPinput = new TextField();
        GridPane.setConstraints(MPinput, 1, 2);
        
        Button MPmakepurchase = new Button("Make Purchase");
        GridPane.setConstraints(MPmakepurchase, 0, 3);
        
        Label MPerror = new Label();
        GridPane.setConstraints(MPerror, 0, 4);
        
        Button MPback = new Button("Go Back");
        GridPane.setConstraints(MPback, 1, 3);
        
        MPgrid.getChildren().addAll(MPlabel,MPenter, MPinput, MPmakepurchase, MPerror, MPback,MPstate);
        Scene MPscene = new Scene(MPgrid,700, 500);
        
        
//-----------------------------x----------------------------
//Login Scene
        loginButton.setOnAction((ActionEvent event) -> {
            if("manager".equals(roleInput.getText())){
                if("admin".equals(usernameInput.getText())&&"admin".equals(passInput.getText())){
                    
                    System.out.println("pass");
                    window.setScene(Mscene);
                    m = new Manager("admin","admin");
                    error.setText("");
                }
                
                else{
                    
                    error.setText("Invalid Login Credentials");
                }
                                
            }//end manager segment 
            String userInput;            
            userInput = usernameInput.getText();//previously generated textfields
            if (userExists(userInput)) {
                File checkFile = new File("" + userInput + ".txt");
                Scanner read = null;//starts of by reading nothing 
                try {
                    read = new Scanner(checkFile);
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                }
                read.nextLine();//this is where the username would usually be, but we have that value
                String pass = read.nextLine();
                if ((passInput.getText()).equals(pass) && "customer".equals(roleInput.getText())) {
                    read.nextLine();
                    Double balance = Double.valueOf(read.nextLine());
                    c = new Customer(userInput, pass, balance, checkFile);
                    stateDisp.setText("Level: " + c.getLevel());
                    window.setScene(Cscene);
                    error.setText("");
                } else {
                    error.setText("Invalid Login Credentials");
                }
            } else {
                error.setText("Invalid Login Credentials");
            }
        });
        
        
        //Manager home
        logout.setOnAction((ActionEvent event) -> {
            window.setScene(scene);
        });
        
        addCust.setOnAction((ActionEvent event) -> {
            window.setScene(MAddScene);
        });
        
        delCust.setOnAction((ActionEvent event) -> {
            window.setScene(delCustScene);
        });
        
        //Manager add scene
        addC.setOnAction((ActionEvent event) -> {
            if(userExists(newUserInput.getText())){
                Merror.setText("Username already exists");
            }
            
            else{
                m.addNewCustomer(newUserInput.getText(), newUserPass.getText());
                Merror.setText("");
                window.setScene(Mscene);
            }
        });
        
        backToMsceneA.setOnAction((ActionEvent event) -> {
            window.setScene(Mscene);
        });
        
        //Manager delete scene
        delCustButton.setOnAction((ActionEvent event) -> {
            if(userExists(newUserInputD.getText())){
                m.deleteCustomer(newUserInputD.getText());
                window.setScene(Mscene);
                Derror.setText("");
            }
            else{
                Derror.setText("Username does not exist");
            }
            
        });
        
        backToMsceneD.setOnAction((ActionEvent event) -> {
            window.setScene(Mscene);
        });
        
        //Customer Scene
        Withdraw.setOnAction((ActionEvent event) ->{
            window.setScene(CWscene);
        });
        
        Deposit.setOnAction((ActionEvent event) ->{
            window.setScene(CDscene);
        });
        
        CheckBalance.setOnAction((ActionEvent event) ->{
            window.setScene(CCBscene);
            CCBlabel.setText("Your Balance is: $" + c.getBalance());
        });
        
        Logout.setOnAction((ActionEvent event) ->{
            window.setScene(scene);
            c.Logout();
        });
        
        makePurchase.setOnAction((ActionEvent event) -> {
            
            if(c.getLevel().equals("Silver")){
                MPstate.setText("Silver: $20 Fee");
            }
            else if(c.getLevel().equals("Gold")){
                MPstate.setText("Gold: $10 Fee");
            }
            else{
                MPstate.setText("Platinum: No Fee");
            }
            window.setScene(MPscene);
            MPerror.setText("");
            
        });
        
        //Withdraw Scene
        CWwithdraw.setOnAction((ActionEvent event) ->{
            
            if(c.withdrawMoney(CWamount.getText())){
                window.setScene(Cscene);
                stateDisp.setText("Level: " + c.getLevel());
                CWerror.setText("");
            }
            else{
                CWerror.setText("Invalid Request");
            }    
        });
        
        CWback.setOnAction((ActionEvent event) -> {
            window.setScene(Cscene);
        });
        
        
        //Deposit Scene
        CDdeposit.setOnAction((ActionEvent event) ->{
            
            if(c.depositMoney(CDamount.getText())){
                window.setScene(Cscene);
                stateDisp.setText("Level: " + c.getLevel());
                CDerror.setText("");
            }
            else{
                CDerror.setText("Invalid Request");
            }    
        });
        
        CDback.setOnAction((ActionEvent event) -> {
            window.setScene(Cscene);
        });
        
        //Check Balance Scene
        
        CCBback.setOnAction((ActionEvent event) -> {
            window.setScene(Cscene);
        });
        
        //Make purchase scene
       
        MPmakepurchase.setOnAction((ActionEvent event) -> {
           if(c.makePurchase(MPinput.getText())){
               window.setScene(Cscene);
               stateDisp.setText("Level: " + c.getLevel());
               MPerror.setText("");
           }
           else{
               MPerror.setText("Invalid Request");
           }
            
        });
        
        MPback.setOnAction((ActionEvent event) -> {
            window.setScene(Cscene);
        });
        
        
        primaryStage.show();
    }
    
    
    public boolean userExists(String Username){
      File user;
      
         user = new File(Username+".txt");
          
         boolean exists = user.exists();
          
         return exists;
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}