/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Zayneb
 */
public class Tickets {
    private float prix;

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_manifestation() {
        return id_manifestation;
    }

    public void setId_manifestation(int id_manifestation) {
        this.id_manifestation = id_manifestation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    private int id_manifestation;
    private String code;

    public Tickets(float prix, int id_manifestation, String code) {
        this.prix = prix;
        this.id_manifestation = id_manifestation;
        this.code = code;
    }
    
}
