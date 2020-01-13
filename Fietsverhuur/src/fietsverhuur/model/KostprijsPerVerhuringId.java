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
public class KostprijsPerVerhuringId {
    private int verhuringId;
    private double kostprijs;

    public KostprijsPerVerhuringId(int verhuringId, double kostprijs) {
        this.verhuringId = verhuringId;
        this.kostprijs = kostprijs;
    }

    public int getVerhuringId() {
        return verhuringId;
    }

    public void setVerhuringId(int verhuringId) {
        this.verhuringId = verhuringId;
    }

    public double getKostprijs() {
        return kostprijs;
    }

    public void setKostprijs(double kostprijs) {
        this.kostprijs = kostprijs;
    }
    
}
