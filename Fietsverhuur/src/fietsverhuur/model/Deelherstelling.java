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
public class Deelherstelling {
    private int herstellingId;
    private int defectnummer;

    public Deelherstelling(int herstellingId, int defectnummer) {
        this.herstellingId = herstellingId;
        this.defectnummer = defectnummer;
    }

    public int getDefectnummer() {
        return defectnummer;
    }

    public void setDefectnummer(int defectnummer) {
        this.defectnummer = defectnummer;
    }

    public int getHerstellingId() {
        return herstellingId;
    }

    public void setHerstellingId(int herstellingId) {
        this.herstellingId = herstellingId;
    }
    
    
}
