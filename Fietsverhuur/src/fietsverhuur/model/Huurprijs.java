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
public class Huurprijs {
    private int huurprijsId;
    private int minDuurInDagen;
    private int maxDuurInDagen;
    private String fietstype;
    private double bedragPerDagInEuro;

    public Huurprijs(int huurprijsId, int minDuurInDagen, int maxDuurInDagen, String fietstype, double bedragPerDagInEuro) {
        this.huurprijsId = huurprijsId;
        this.minDuurInDagen = minDuurInDagen;
        this.maxDuurInDagen = maxDuurInDagen;
        this.fietstype = fietstype;
        this.bedragPerDagInEuro = bedragPerDagInEuro;
    }

    public int getHuurprijsId() {
        return huurprijsId;
    }

    public void setHuurprijsId(int huurprijsId) {
        this.huurprijsId = huurprijsId;
    }

    public int getMinDuurInDagen() {
        return minDuurInDagen;
    }

    public void setMinDuurInDagen(int minDuurInDagen) {
        this.minDuurInDagen = minDuurInDagen;
    }

    public int getMaxDuurInDagen() {
        return maxDuurInDagen;
    }

    public void setMaxDuurInDagen(int maxDuurInDagen) {
        this.maxDuurInDagen = maxDuurInDagen;
    }

    public String getFietstype() {
        return fietstype;
    }

    public void setFietstype(String fietstype) {
        this.fietstype = fietstype;
    }

    public double getBedragPerDagInEuro() {
        return bedragPerDagInEuro;
    }

    public void setBedragPerDagInEuro(double bedragPerDagInEuro) {
        this.bedragPerDagInEuro = bedragPerDagInEuro;
    }
    
}
