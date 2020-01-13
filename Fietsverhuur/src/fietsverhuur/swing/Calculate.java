/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;

import fietsverhuur.dao.*;
import fietsverhuur.model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Myra
 */
public class Calculate {
    
    public static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    // From http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    public static String roundAndAddZeroes(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        
        String resultaat = Double.toString(tmp / factor);
        if(!resultaat.contains(".") && places != 0) {
            resultaat += ".";
            for(int i = 0; i < places; i++) {
                resultaat += "0";
            }
        } else {
            while(places + 1 > resultaat.length() - resultaat.indexOf('.')) {
                resultaat +="0";
            }
        }
        return resultaat;
    }
    
    public static double calculateVerhuringKostprijs(int duur, int fietsnummer) {
        double resultaat = 0;
        Fiets fiets = FietsDao.getFietsById(fietsnummer);
        ArrayList<Huurprijs> huurprijzen = HuurprijsDao.getHuurprijzen();
        for (Huurprijs huurprijs : huurprijzen) {
            if(fiets.getFietstype().equals(huurprijs.getFietstype()) && duur >= huurprijs.getMinDuurInDagen() && duur <= huurprijs.getMaxDuurInDagen()) {
                resultaat = huurprijs.getBedragPerDagInEuro() * duur;
            }
        }
        return resultaat;
    }
    
    public static String calculateEinddatum(String begindatumstr, int duur) {
        try {
            String resultaat;
            Date begindatum = df.parse(begindatumstr);
            Calendar c = Calendar.getInstance();
            c.setTime(begindatum);
            c.add(Calendar.DATE, duur);
            resultaat = df.format(c.getTime());
            return resultaat;
        } catch (ParseException ex) {
            return "";
        }
    }
    
    public static double calculateHerstellingKostprijs(ArrayList<Integer> defectnummerlist) {
        double resultaat = 0;
        for(int defectnummer : defectnummerlist) {
            Defect currentDefect = DefectDao.getDefectById(defectnummer);
            resultaat += currentDefect.getKostprijs();
        }
        return resultaat;
    }
}
