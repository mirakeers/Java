/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.model;

import fietsverhuur.swing.Calculate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Myra
 */
public class Verhuring {
    private int verhuringId;
    private Date begindatum;
    private int duurInDagen;
    private int huurderId;
    private int fietsnummer;
    private Date einddatum;

    public Verhuring(int verhuringId, Date begindatum, int duurInDagen, int huurderId, int fietsnummer) {
        this.verhuringId = verhuringId;
        this.begindatum = begindatum;
        this.duurInDagen = duurInDagen;
        this.huurderId = huurderId;
        this.fietsnummer = fietsnummer;
        this.einddatum = calculateEinddatum();
    }

    public Verhuring(Date begindatum, int duurInDagen, int huurderId, int fietsnummer) {
        this(-1, begindatum, duurInDagen, huurderId, fietsnummer);
    }

    public int getVerhuringId() {
        return verhuringId;
    }

    public void setVerhuringId(int verhuringId) {
        this.verhuringId = verhuringId;
    }

    public Date getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(Date begindatum) {
        this.begindatum = begindatum;
        this.einddatum = calculateEinddatum();
    }

    public int getDuurInDagen() {
        return duurInDagen;
    }

    public void setDuurInDagen(int duurInDagen) {
        this.duurInDagen = duurInDagen;
        this.einddatum = calculateEinddatum();
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

    public Date getEinddatum() {
        return einddatum;
    }

    private Date calculateEinddatum() {
        Date resultaat;
        Calendar c = Calendar.getInstance();
        c.setTime(this.begindatum);
        c.add(Calendar.DATE, this.duurInDagen);
        resultaat = c.getTime();
        return resultaat;
    }
    
    @Override
    public String toString() {
        String dagOfDagen = "dagen";
        if(this.duurInDagen == 1) {
            dagOfDagen = "dag";
        }
        return Calculate.df.format(begindatum) + ": Verhuring " + Integer.toString(verhuringId) + " door huurder " + Integer.toString(huurderId) + ": fiets " + Integer.toString(fietsnummer) + ". " + Integer.toString(duurInDagen) + " " + dagOfDagen + ".";
    }
}
