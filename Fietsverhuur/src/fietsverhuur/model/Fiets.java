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
public class Fiets {
    private int fietsnummer;
    private String gender;
    private String fietstype;
    private int aantalVitessen;
    private String dikteBand;
    private String kleur;
    private int verhuurpuntId;

     
    public Fiets(int fietsnummer, String gender, String fietstype, int aantalVitessen, String dikteBand, String kleur, int verhuurpuntId) {
        this.fietsnummer = fietsnummer;
        this.gender = gender;
        this.fietstype = fietstype;
        this.aantalVitessen = aantalVitessen;
        this.dikteBand = dikteBand;
        this.kleur = kleur;
        this.verhuurpuntId = verhuurpuntId;
    }

    public Fiets(String gender, String fietstype, int aantalVitessen, String dikteBand, String kleur, int verhuurpuntId) {
        this(-1, gender, fietstype, aantalVitessen, dikteBand, kleur, verhuurpuntId);
    }

    public int getFietsnummer() {
        return fietsnummer;
    }

    public void setFietsnummer(int fietsnummer) {
        this.fietsnummer = fietsnummer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFietstype() {
        return fietstype;
    }

    public void setFietstype(String fietstype) {
        this.fietstype = fietstype;
    }

    public int getAantalVitessen() {
        return aantalVitessen;
    }

    public void setAantalVitessen(int aantalVitessen) {
        this.aantalVitessen = aantalVitessen;
    }

    public String getDikteBand() {
        return dikteBand;
    }

    public void setDikteBand(String dikteBand) {
        this.dikteBand = dikteBand;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public int getVerhuurpuntId() {
        return verhuurpuntId;
    }

    public void setVerhuurpuntId(int verhuurpuntId) {
        this.verhuurpuntId = verhuurpuntId;
    }
    
    @Override
    public String toString() {
        String genderstr = "Herenmodel";
        if(this.gender.equals("vrouwelijk")) {
            genderstr = "Damesmodel";
        }
        if(this.gender.equals("unisex")) {
            genderstr = "Unisexmodel";
        }
        return "Fiets " + Integer.toString(fietsnummer) + ": " + genderstr + " " + fietstype + ".";
    }
}
