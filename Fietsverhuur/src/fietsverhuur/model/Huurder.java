/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.model;

/**
 *
 * @author MaartenH
 */
public class Huurder {
    private int huurderId;
    private String voornaam;
    private String achternaam;
    private String adres;
    private String stad;
    private String telefoonnummer;
    private String emailadres;

    public Huurder(int huurderId, String voornaam, String achternaam, String adres, String stad, String telefoonnummer, String emailadres) {
        this.huurderId = huurderId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.stad = stad;
        this.telefoonnummer = telefoonnummer;
        this.emailadres = emailadres;
    }

    public Huurder(String voornaam, String achternaam, String adres, String stad, String telefoonnummer, String emailadres) {
        this(-1, voornaam, achternaam, adres, stad, telefoonnummer, emailadres);
    }
    
    public int getHuurderId() {
        return huurderId;
    }

    public void setHuurderId(int huurderId) {
        this.huurderId = huurderId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
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

    @Override
    public String toString() {
        return "Huurder " + huurderId + ": " + voornaam + " " + achternaam;
    }
    
           
}
