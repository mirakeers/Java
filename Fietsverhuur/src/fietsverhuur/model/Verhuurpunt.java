/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.model;

/**
 *
 * @author Myra
 */
public class Verhuurpunt {
    private int verhuurpuntId;
    private String naam;
    private String adres;
    private String stad;
    private String telefoonnummer;
    private String emailadres;

    public Verhuurpunt(int verhuurpuntId, String naam, String adres, String stad, String telefoonnummer, String emailadres) {
        this.verhuurpuntId = verhuurpuntId;
        this.naam = naam;
        this.adres = adres;
        this.stad = stad;
        this.telefoonnummer = telefoonnummer;
        this.emailadres = emailadres;
    }

    public int getVerhuurpuntId() {
        return verhuurpuntId;
    }

    public void setVerhuurpuntId(int verhuurpuntId) {
        this.verhuurpuntId = verhuurpuntId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }
    
    
}
