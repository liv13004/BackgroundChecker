/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.appControllers;

import cit360.handlers.Handler;
import java.util.HashMap;

/**
 *
 * @author Braden
 * referenced from github/yenrab
 * https://github.com/yenrab/doing_more_with_java/blob/master/ApplicationController.java
 */
public class MainAppController {
    
    
    
    private final HashMap<String,Handler> handlerMap = new HashMap();
    
    //Another way of building HashMap, may not use it...
    //private final HashMap<String, Object> handlerMap;
        
   
    public void MapCommand(String command, Handler someHandler){
        // Insert the valid command into handleMap.
        handlerMap.put(command, someHandler);
    }
    
    public void HandleRequest(String aCommand, HashMap<String,Object> commandHMap){
        
        Handler someHandler = (Handler) handlerMap.get(aCommand);
        if (someHandler != null){
            someHandler.handleIt(commandHMap);
        }
    }
}
