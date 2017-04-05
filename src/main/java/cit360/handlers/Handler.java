/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.handlers;

import java.util.HashMap;

/**
 *
 * @author Braden
 * Referenced from github/yenrab
 * https://github.com/yenrab/doing_more_with_java/blob/master/Handler.java
 */
public interface Handler {
     public void handleIt(HashMap<String, Object> data);
}
