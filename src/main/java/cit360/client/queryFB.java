/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.client;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;




/**
 *
 * @author Braden
 */
public class queryFB implements Runnable {

    private String fbId = "";
    private PersonIdentity identity;
    private final String jsonInfo;// = "";
    
    public queryFB(String someId, PersonIdentity identity){
        this.fbId = someId;
        this.identity = identity;
        jsonInfo = "{\"firstName\":\"Braden\","
                 + "\"lastName\":\"Livingston\","
                 + "\"age\":30,"
                 + "\"friends\":["
                    + "{\"firstName\":\"Larry\",\"lastName\":\"Dewey\", \"friends\":[]},"
                    + "{\"firstName\":\"Eric\",\"lastName\":\"Peterson\", \"friends\":[]}"
                 + "]"
                 + "}";
    }   
    
    
    /**
     * For testing stuff...
     */
    public void testMethod(){
    }
    
    /**
     * Runnable code is executed here.
     */
    @Override
    public void run() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
      //build http url request to fb api below...
      /*  Commenting for possible later use
      URL fburl = new URL();
        HttpURLConnection fbApiConnection = (HttpURLConnection) fburl.openConnection();
        BufferedInputStream fbIOStream = new BufferedInputStream(fbApiConnection.getInputStream());
        HashMap <String, Object> fbContainer = (HashMap<String, Object>) JSONUtilities.parse(insert api method to request fb data here);
       */
      
      try {
        HashMap<String, Object> data = (HashMap<String, Object>) JSONUtilities.parse(jsonInfo);
        identity.setFbinfo(new PersonFBInfo(data));
      } catch (JSONException | ParseException ex) {
          System.out.println(ex.getMessage());
      }
    }
    
}
