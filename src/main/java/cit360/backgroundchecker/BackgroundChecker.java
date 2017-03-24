/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.backgroundchecker;

import cit360.client.FBInfo;
import cit360.client.Identity;
import cit360.client.LinkedInInfo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Braden
 */
public class BackgroundChecker {
    
    Scanner scanner = new Scanner(System.in);
    private BlockingQueue smQueue;
    private ArrayList smList;
    Identity identity = new Identity();
    
    
    
    public void promptForID(){
        System.out.println("What is the user id of the person to check: ?");
    
        String userID = scanner.next();
    }
    
    public void queryFB(){
            FBInfo fbInfo = new FBInfo();          
    }
    
    public void queryLI(){
        LinkedInInfo liInfo = new LinkedInInfo();   
    }
    
    public void sendData(){
        
    }
    
    public static void main(String args[]){
        BackgroundChecker newCheck = new BackgroundChecker();
        
        newCheck.promptForID();
        
        
    }
    
}
