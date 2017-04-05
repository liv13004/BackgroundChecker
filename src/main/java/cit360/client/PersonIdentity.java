/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.client;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Braden
 */
public class PersonIdentity implements Serializable {
    
    private String fbid = "";
    private String liid = "";
    
    private int age = 0;
    private String firstName = "";
    private String lastName = "";
    private PersonFBInfo[] friends;
    private PersonFBInfo fbinfo;
    private PersonLinkedInInfo liinfo;

        
    public PersonIdentity() {
    
   
}
    
    public PersonIdentity(int someAge, String someFirstName, String someLastName, PersonFBInfo[] someFriends){
        
        this.age = someAge;
        this.firstName = someFirstName;
        this.lastName = someLastName;
        this.friends = someFriends;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
        public String getFbid() {
        return fbid;
    }

    public void setFbid(String fbid) {
        this.fbid = fbid;
    }

    public String getLiid() {
        return liid;
    }

    public void setLiid(String liid) {
        this.liid = liid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public PersonFBInfo getFbinfo() {
        return fbinfo;
    }

    public void setFbinfo(PersonFBInfo fbinfo) {
        this.fbinfo = fbinfo;
    }

    public PersonLinkedInInfo getLiinfo() {
        return liinfo;
    }

    public void setLiinfo(PersonLinkedInInfo liinfo) {
        this.liinfo = liinfo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.fbid);
        hash = 97 * hash + Objects.hashCode(this.liid);
        hash = 97 * hash + this.age;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.fbinfo);
        hash = 97 * hash + Objects.hashCode(this.liinfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonIdentity other = (PersonIdentity) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.fbid, other.fbid)) {
            return false;
        }
        if (!Objects.equals(this.liid, other.liid)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.fbinfo, other.fbinfo)) {
            return false;
        }
        if (!Objects.equals(this.liinfo, other.liinfo)) {
            return false;
        }
        return true;
    }



    

    
    
    
}
