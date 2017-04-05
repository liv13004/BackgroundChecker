/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.client;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Braden
 */
public class PersonFBInfo implements Serializable, SocialMedia {

    private Integer anos;
    private String nombre;
    private String apellido;
    private PersonFBInfo amigos[];

    private Double anosDouble;

    public PersonFBInfo() {

    }

    public Integer getAnos() {
        return anos;
    }

    public void setAnos(Integer anos) {
        this.anos = anos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public PersonFBInfo[] getAmigos() {
        return amigos;
    }

    public void setAmigos(PersonFBInfo[] amigos) {
        this.amigos = amigos;
    }

    public Double getAnosDouble() {
        return anosDouble;
    }

    public void setAnosDouble(Double anosDouble) {
        this.anosDouble = anosDouble;
    }

    public PersonFBInfo(HashMap<String, Object> data) {
       anos = Integer.parseInt(data.get("age").toString());
       nombre = data.get("firstName").toString();
       apellido = data.get("lastName").toString();
       amigos = (PersonFBInfo[]) data.get("friends");
    }
    
    
}
