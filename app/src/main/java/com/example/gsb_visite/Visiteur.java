package com.example.gsb_visite;

import java.util.ArrayList;
import java.util.Date;

public class Visiteur{
    private String nom;
    private String prenom;
    private String visiteurId;
    private String tel;
    private Date date_embauche;
    private String email;
    private String password;
    private ArrayList<Praticien> porteFeuille;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Praticien> getPorteFeuille() {
        return porteFeuille;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }

    private String token;

    public String getVisiteurId() {
        return visiteurId;
    }

    public void setVisiteurId(String visiteurId) {
        this.visiteurId = visiteurId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Visiteur(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
