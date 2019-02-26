/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author NOUIRA Nesrine
 */
public class Manifestation {
 private int id_manifestation;
    private String nom;
    
    private String description;
    private String photo;
    private Date date_debut;
    
    private Date date_fin;
     private String lieu;
    private int nombreplaces;
    private int idclub;
    public int getId_manifestation() {
        return id_manifestation;
    }

    public void setId_manifestation(int id_manifestation) {
        this.id_manifestation = id_manifestation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNombreplaces() {
        return nombreplaces;
    }

    public void setNombreplaces(int nombreplaces) {
        this.nombreplaces = nombreplaces;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

   
   
    

    public Manifestation(int id_manifestation, String nom, String description, String photo, Date date_debut, String lieu, int nombreplaces, int idclub, Date date_fin) {
        this.id_manifestation = id_manifestation;
        this.nom = nom;
        this.description = description;
        this.photo = photo;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.lieu = lieu;
        this.nombreplaces = nombreplaces;
        this.idclub = idclub;
    }
   
    
    

}