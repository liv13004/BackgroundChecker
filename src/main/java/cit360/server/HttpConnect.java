/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.server;

import cit360.client.PersonIdentity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.ParseException;

/**
 *
 * @author Braden
 */
//implement runnable to enable it to be passed into thread
public class HttpConnect implements Runnable{
   // private HashMap<String, Object> data;
    private PersonIdentity identity;
    private HashMap<String,Object> personInfo;
            
     public HttpConnect(PersonIdentity identityData){
        identity = identityData;
        
    }
    
    @Override
    public void run() {
        try {
            //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //build http url connection
            
            URL servletUrl = new URL("http://localhost:8080/BackgroundCheckerServlet");
            HttpURLConnection connection = (HttpURLConnection) servletUrl.openConnection();
            
            
            // build json input and output streams
            JSONOutputStream outStream = new JSONOutputStream(connection.getOutputStream());
            JSONInputStream inStream = new JSONInputStream(connection.getInputStream());
            
             //add information to hashmap to pass to servlet
            personInfo.put("UserIdentity", identity);
            personInfo.put("command", "writeIdentity");
        
            
            //send identity object over to be written
            outStream.writeObject(personInfo);
            
            //information received back from servlet processed below...
            personInfo = (HashMap<String, Object>) inStream.readObject();
            
        } catch (JSONException | IOException | ParseException ex) 
        {
            Logger.getLogger(HttpConnect.class.getName()).log(Level.SEVERE, null, ex);
       // } catch (IOException ex) {
          //  Logger.getLogger(HttpConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    
       
    
        }
    }    
