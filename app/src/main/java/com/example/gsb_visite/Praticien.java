package com.example.gsb_visite;

import java.util.Date;

public class Praticien {
    private String nom;
    private String prenom;
    private String code_postale;
    private String tel;
    private String ville;
    private String rue;
    private String email;

    public Praticien(String nom, String prenom, String code_postale, String tel, String ville, String rue, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.code_postale = code_postale;
        this.tel = tel;
        this.ville = ville;
        this.rue = rue;
        this.email = email;
    }

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
