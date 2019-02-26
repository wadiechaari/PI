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
public class Event {
    
    private int idEvent;
    private String nomResponsable;
    private String secteur;
    private int id_manifestation;

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public int getId_manifestation() {
        return id_manifestation;
    }

    public void setId_manifestation(int id_manifestation) {
        this.id_manifestation = id_manifestation;
    }

    public Event(int idEvent, String nomResponsable, String secteur, int id_manifestation) {
        this.idEvent = idEvent;
        this.nomResponsable = nomResponsable;
        this.secteur = secteur;
        this.id_manifestation = id_manifestation;
    }

}