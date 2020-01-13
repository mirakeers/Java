/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.model;

import java.util.Date;

/**
 *
 * @author Myra
 */
public class Herstelling {
    private int herstellingId;
    private Date meldingsdatum;
    private int huurderId;
    private int fietsnummer;

    public Herstelling(int herstellingId, Date meldingsdatum, int huurderId, int fietsnummer) {
        this.herstellingId = herstellingId;
        this.meldingsdatum = meldingsdatum;
        this.huurderId = huurderId;
        this.fietsnummer = fietsnummer;
    }

    public Herstelling(Date meldingsdatum, int huurderId, int fietsnummer) {
        this(-1, meldingsdatum, huurderId, fietsnummer);
    }
    
    public int getHerstellingId() {
        return herstellingId;
    }

    public void setHerstellingId(int herstellingId) {
        this.herstellingId = herstellingId;
    }

    public Date getMeldingsdatum() {
        return meldingsdatum;
    }

    public void setMeldingsdatum(Date meldingsdatum) {
        this.meldingsdatum = meldingsdatum;
    }

    public int getHuurderId() {
        return huurderId;
    }

    public void setHuurderId(int huurderId) {
        this.huurderId = huurderId;
    }

    public int getFietsnummer() {
        return fietsnummer;
    }

    public void setFietsnummer(int fietsnummer) {
        this.fietsnummer = fietsnummer;
    }
    
    @Override
    public String toString() {
        return "Herstelling " + Integer.toString(herstellingId) + ": van fiets " + Integer.toString(fietsnummer) + ", door huurder " + Integer.toString(huurderId) + ".";
    }
    
}
