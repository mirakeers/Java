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
public class Defect {
    private int defectnummer;
    private String beschrijving;
    private double onkostMateriaalInEuro;
    private double duurInMin;
    private double kostprijs;

    public Defect(int defectnummer, String beschrijving, double onkostMateriaalInEuro, double duurInMin) {
        this.defectnummer = defectnummer;
        this.beschrijving = beschrijving;
        this.onkostMateriaalInEuro = onkostMateriaalInEuro;
        this.duurInMin = duurInMin;
        this.kostprijs =  this.duurInMin * 0.25 + this.onkostMateriaalInEuro;
    }

    public int getDefectnummer() {
        return defectnummer;
    }

    public void setDefectnummer(int defectnummer) {
        this.defectnummer = defectnummer;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getOnkostMateriaalInEuro() {
        return onkostMateriaalInEuro;
    }

    public void setOnkostMateriaalInEuro(double onkostMateriaalInEuro) {
        this.onkostMateriaalInEuro = onkostMateriaalInEuro;
        this.kostprijs =  this.duurInMin * 0.25 + this.onkostMateriaalInEuro;
    }

    public double getDuurInMin() {
        return duurInMin;
    }

    public void setDuurInMin(double duurInMin) {
        this.duurInMin = duurInMin;
        this.kostprijs =  this.duurInMin * 0.25 + this.onkostMateriaalInEuro;
    }

    public double getKostprijs() {
        return kostprijs;
    }
    
    
}
