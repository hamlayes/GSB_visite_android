package com.example.gsb_visite;

import java.io.Serializable;

public class Praticien implements Serializable {
    private String nom;
    private String prenom;
    private String code_postale;
    private String tel;
    private String ville;
    private String rue;
    private String email;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
