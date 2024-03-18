package com.example.gsb_visite;

import java.util.Date;

public class Visiteur {
    private String nom;
    private String prenom;
    private String visiteurId;
    private String tel;
    private Date date_embauche;
    private String email;
    private String password;
    private String token;

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
