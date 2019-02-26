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
public class Question {

    private int id;
    private String question;
    private int id_user;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Question() {
    }

  
    public Question(int id,String question,int id_user) {
        this.id=id;
        this.question=question;
        this.id_user=id_user;
        
    }

    public Question(String question, int id_user) {
        this.question = question;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.question);
        hash = 79 * hash + this.id_user;
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
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + ", id_user=" + id_user + '}';
    }
    
    
}
