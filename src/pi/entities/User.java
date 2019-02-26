/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.entities;

import java.util.Objects;

/**
 *
 * @author Hrissa
 */
public class User {
    private int id;
    private String name;
    private String lastname;
    private String birthdate;
    private String adress;
    private String tel;
    private String email;
    private String profile_pic;
    private String description;
    private String type;
    private String password;
    private String username;

    public User() {
    }

    public User(int id, String name, String lastname, String birthdate, String adress, String tel, String email, String profile_pic, String description, String type, String password, String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.adress = adress;
        this.tel = tel;
        this.email = email;
        this.profile_pic = profile_pic;
        this.description = description;
        this.type = type;
        this.password = password;
        this.username = username;
    }

    public User(String name, String lastname, String birthdate, String adress, String tel, String email, String profile_pic, String description, String type, String password, String username) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.adress = adress;
        this.tel = tel;
        this.email = email;
        this.profile_pic = profile_pic;
        this.description = description;
        this.type = type;
        this.password = password;
        this.username = username;
    }

    public User(String name, String lastname, String birthdate, String adress, String tel, String email, String profile_pic, String type, String password, String username) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.adress = adress;
        this.tel = tel;
        this.email = email;
        this.profile_pic = profile_pic;
        this.type = type;
        this.password = password;
        this.username = username;
    }

    public User(String name, String lastname, String birthdate, String adress, String tel, String email, String profile_pic, String password, String username) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.adress = adress;
        this.tel = tel;
        this.email = email;
        this.profile_pic = profile_pic;
        this.password = password;
        this.username = username;
    }

    public User(int id, String name, String lastname, String birthdate, String tel, String email, String type, String password, String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.tel = tel;
        this.email = email;
        this.type = type;
        this.password = password;
        this.username = username;
    }

    

  
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.lastname);
        hash = 23 * hash + Objects.hashCode(this.birthdate);
        hash = 23 * hash + Objects.hashCode(this.adress);
        hash = 23 * hash + Objects.hashCode(this.tel);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.profile_pic);
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + Objects.hashCode(this.type);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + Objects.hashCode(this.username);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.birthdate, other.birthdate)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.profile_pic, other.profile_pic)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", birthdate=" + birthdate + ", adress=" + adress + ", tel=" + tel + ", email=" + email + ", profile_pic=" + profile_pic + ", description=" + description + ", type=" + type + ", password=" + password + ", username=" + username + '}';
    }
    
    







}

