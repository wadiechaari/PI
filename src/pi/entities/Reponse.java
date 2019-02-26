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
public class Reponse {

    private int id;
    private int id_user;
    private int id_q;
    private String reponse;
    public Reponse() {
    }

    
    
    
    
    public Reponse(int id, int id_user, int id_q, String reponse) {
        this.id=id;
        this.id_user=id_user;
        this.id_q=id_q;
        this.reponse=reponse;
        
    }

    public Reponse(int id_user, int id_q, String reponse) {
        this.id_user = id_user;
        this.id_q = id_q;
        this.reponse = reponse;
    }

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_q() {
        return id_q;
    }

    public String getReponse() {
        return reponse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_q(int id_q) {
        this.id_q = id_q;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.id_user;
        hash = 97 * hash + this.id_q;
        hash = 97 * hash + Objects.hashCode(this.reponse);
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
        final Reponse other = (Reponse) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_q != other.id_q) {
            return false;
        }
        if (!Objects.equals(this.reponse, other.reponse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", id_user=" + id_user + ", id_q=" + id_q + ", reponse=" + reponse + '}';
    }
    
    
}
