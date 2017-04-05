/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.backgroundchecker;

import cit360.client.PersonFBInfo;
import cit360.client.PersonIdentity;
import cit360.client.PersonLinkedInInfo;
import cit360.client.queryFB;
import cit360.server.HttpConnect;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Braden
 */
public class BackgroundChecker {

    private Scanner scanner = new Scanner(System.in);
    private BlockingQueue bcQueue;
//    private ArrayList identityList;
    private PersonIdentity identity = new PersonIdentity();

    public void promptForID() {
        System.out.println("What is the facebook user id of the person to check: ?");
        String fbuserID = scanner.next();
        identity.setFbid(fbuserID);
        System.out.println("What is the LinkedIn user id of the person to check: ?");
        String liuserID = scanner.next();
        identity.setLiid(liuserID);

    }

//accidentally created, not needed
    public void clientQueryFB() {
        queryFB myQuery = new queryFB("1", identity);
        Thread newThread = new Thread(myQuery);
        newThread.start();
    }

    //accidentally created, not needed
    public void queryLI() {

        PersonLinkedInInfo liInfo = new PersonLinkedInInfo();
        identity.setLiinfo(liInfo);
    }
    
    //calls new http connection as runnable to send threaded data to server
    public void sendIdentityToRunnableToSendToServlet() {
    // start method with runnable, which calls servlet
        HttpConnect newCommunication = new HttpConnect(identity);
        Thread newThread = new Thread(newCommunication);
        newThread.start();

    }

    public static void main(String args[]) {
        BackgroundChecker newCheck = new BackgroundChecker();

        // Get the id from the user.
        newCheck.promptForID();
        
        // Query the API for data tied to the ID.
        newCheck.clientQueryFB();
        
        //Associate FB data found with identity
        
        
        // Send the data found to the Servlet to be stored.
        newCheck.sendIdentityToRunnableToSendToServlet();
        
        //get response from server
        

    }

}
