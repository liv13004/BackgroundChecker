/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.handlers;

import cit360.client.PersonIdentity;
import cit360.model.Model;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONOutputStream;

/**
 *
 * @author Braden
 * Referenced from github/yenrab
 * https://github.com/yenrab/doing_more_with_java/blob/master/LoginHandler.java
 */
public class SaveIdentityHandler implements Handler {

    @Override
    public void handleIt(HashMap<String, Object> identityData) {
        
        String firstName = (String)identityData.get("firstName");
        String lastName = (String)identityData.get("lastName");
        //left for future reference...
        //PersonIdentity userIdentity = (PersonIdentity)identityData.get("UserIdentity");
        
                
        Model model = (Model)identityData.get("model");
        
        //left for reference:
        PersonIdentity foundIdentity = model.getIdentity(firstName, lastName);
        
        //PersonIdentity userIdentity = model.getIdentity();
       
        
        HashMap<String,Object>responseMap = new HashMap<>();
        
        if(foundIdentity != null){
            
            model.updateUser(foundIdentity);
            
        }
        
        JSONOutputStream outToClient = (JSONOutputStream)identityData.get("toClient");
        try {
            outToClient.writeObject(responseMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
