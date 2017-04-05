/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.ParseException;
import cit360.appControllers.MainAppController;
//import cit360.handlers.Handler;
import cit360.handlers.*;
import cit360.model.Model;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Braden
 * referenced init function from github/yenrab
 * https://github.com/yenrab/doing_more_with_java/blob/master/StoreServlet.java
 */
public class BackgroundCheckerServlet extends HttpServlet {
    
    //experimenting below, not used...
    //JSONOutputStream outStream;
    //JSONInputStream inStream;
    
    private HashMap<String, Object> servletHMap;
    private String command;
    private Model model = new Model();
    
     
    
    MainAppController appController = new MainAppController();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     public void init(){
            //Create handler request options
        
            appController.MapCommand("writeIdentity", new SaveIdentityHandler());
            appController.MapCommand("readIdentity", new ReadIdentityHandler());
            
//associate them with model layer for data storage
            model = new Model();
        
    }
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BackgroundCheckerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BackgroundCheckerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
           
    }
        catch(Exception JSONException){
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /*
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (JSONException | ParseException ex) {
            Logger.getLogger(BackgroundCheckerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
              
            JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
            JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());

            //HashMap<String, Object> dataMap = (HashMap) inFromClient.readObject();
            servletHMap = (HashMap<String, Object>) inFromClient.readObject();
            
            command = servletHMap.get("command").toString();
            
            //Barneys version below, left for reference-comparison:
            //String aCommand = (String) dataMap.get("command");
                     
            appController.HandleRequest(command, servletHMap);
            
            // Insert the model into servletHMa[.
            servletHMap.put("model", model);

            // Send the request to the Application Controller.
            appController.HandleRequest((String) servletHMap.get("command"), servletHMap);
            
            
            // Capture response, and associate with a new return stream.
            JSONOutputStream streamToClient = new JSONOutputStream(response.getOutputStream());

            // Write the object to the output stream.
            streamToClient.writeObject(servletHMap);
            
            
            try {
                processRequest(request, response);
            } catch (JSONException | ParseException ex) {
                Logger.getLogger(BackgroundCheckerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (JSONException | ParseException ex) {
            Logger.getLogger(BackgroundCheckerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet to facilitate incoming and outgoing JSON Requests";
    }// </editor-fold>

}
