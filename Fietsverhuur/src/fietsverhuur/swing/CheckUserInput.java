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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author Myra
 */

public class CheckUserInput {
    public static boolean isStringInteger(String str) {
        return str.matches("^\\d+$");
    }
    public static boolean isStringDouble(String str) {
        return str.matches("[+-]?([0-9]*[.])?[0-9]+");
    }
    
    public static boolean isDateParsable(String datumStr, javax.swing.JLabel foutmeldingLabel) {
        try {
           Date datum = Calculate.df.parse(datumStr);
           foutmeldingLabel.setText(" ");
           return true;
        } catch (ParseException ex) {
           foutmeldingLabel.setText("Vul a.u.b. een geldige datum in (dd/mm/yyyy)");
           return false;
        }
    
    }
    public static Date parseDate(String datumStr) {
        try {
            Date datum = Calculate.df.parse(datumStr);
            return datum;
        } catch (ParseException ex) {
            Logger.getLogger(CheckUserInput.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static boolean doesFietsnummerExist(String fietsnummer, javax.swing.JLabel foutmeldingLabel) {
        if(isStringInteger(fietsnummer)) {
            if(FietsDao.doesFietsExist(Integer.parseInt(fietsnummer))) {
                foutmeldingLabel.setText(" ");
                return true;
            } else {
                foutmeldingLabel.setText("Dit fietsnummer werd niet teruggevonden.");
                return false;
            }
        } else {
            foutmeldingLabel.setText("Vul a.u.b. een geldig fietsnummer in.");
            return false;
        }
    }
    public static boolean doesHuurderIdExist(String huurderid, javax.swing.JLabel foutmeldingLabel) {
        if(isStringInteger(huurderid)) {
            if(HuurderDao.doesHuurderExist(Integer.parseInt(huurderid))) {
                foutmeldingLabel.setText(" ");
                return true;
            } else {
                foutmeldingLabel.setText("Deze huurder werd niet teruggevonden.");
                return false;
            }
        } else {
            foutmeldingLabel.setText("Vul a.u.b. een geldige huurderId in.");
            return false;
        }
    }
    public static boolean doesVerhuurpuntIdExist(String verhuurpuntId, javax.swing.JLabel foutmeldingLabel) {
        if(isStringInteger(verhuurpuntId)) {
            if(VerhuurpuntDao.doesVerhuurpuntExist(Integer.parseInt(verhuurpuntId))) {
                foutmeldingLabel.setText(" ");
                return true;
            } else {
                foutmeldingLabel.setText("Dit verhuurpunt werd niet teruggevonden.");
                return false;
            }
        } else {
            foutmeldingLabel.setText("Vul a.u.b. een geldige verhuurpuntId in.");
            return false;
        }
    }
     public static boolean doesDefectnummerExist(String defectnummer, javax.swing.JLabel foutmeldingLabel) {
        if(isStringInteger(defectnummer)) {
            if(DefectDao.doesDefectnummerExist(Integer.parseInt(defectnummer))) {
                foutmeldingLabel.setText(" ");
                return true;
            } else {
                foutmeldingLabel.setText("Dit defect werd niet teruggevonden.");
                return false;
            }
        } else {
            foutmeldingLabel.setText("Vul a.u.b. een geldig defectnummer in.");
            return false;
        }
    }
    public static boolean doDefectnummersExist(ArrayList<Integer> defectnummerlist, javax.swing.JLabel foutmeldingLabel) {
        for(int defectnummer : defectnummerlist) {
            if(!DefectDao.doesDefectnummerExist(defectnummer)) {
                foutmeldingLabel.setText("Eén of meerdere defectnummers werden niet teruggevonden.");
                return false;
            }
        }
        foutmeldingLabel.setText(" ");
        return true;
    }
    
    public static boolean isDefectenStringValid(String str, javax.swing.JLabel foutmeldingLabel) {
        if(!str.equals("")) {
            String strZonderSpaties = str.replace(" ", "");
            String strZonderKommasEnSpaties = str.replace(" ", "").replace(",", "");
            
            if(!isStringInteger(strZonderSpaties)) {
                if(isStringInteger(strZonderKommasEnSpaties)) {
                    if(strZonderSpaties.charAt(strZonderSpaties.length()-1) == ',') {
                        foutmeldingLabel.setText("Eindig de defectIds a.u.b. niet met een komma.");
                        return false; 
                    } else {
                        foutmeldingLabel.setText(" ");
                        return true;
                    }
                } else {
                    foutmeldingLabel.setText("Vul a.u.b. geldige defectIds in, scheidt deze met een komma.");
                    return false;
                }
            } else {
                if(isStringInteger(str)) {
                    foutmeldingLabel.setText(" ");
                    return true;
                }
                foutmeldingLabel.setText("Scheid a.u.b. de defectIds met een komma.");
                return false;
            }
        } else {
            return false;
        }
    }
    
    public static ArrayList<Integer> convertDefectenstringNaarArrayList(String str) {
        ArrayList<Integer> resultaat = new ArrayList<Integer>();
        str = str.replace(" ", "");
        while(str.contains(",")) {
            int defectnummer = Integer.parseInt(str.substring(0, str.indexOf(",")));
            resultaat.add(defectnummer);
            str = str.substring(str.indexOf(",") + 1);
        }
        int defectnummer = Integer.parseInt(str);
        resultaat.add(defectnummer);
        return resultaat;
    }
    
    public static String convertArrayListNaarDefectenstring(ArrayList<Integer> defectnummerlist) {
        String resultaat = "";
        for(int defectnummer : defectnummerlist) {
            resultaat += Integer.toString(defectnummer);
            resultaat += ", ";
        }
        resultaat = resultaat.substring(0, resultaat.length() - 2);
        return resultaat;
    }
    
    public static boolean isDuurValid(String duur, javax.swing.JLabel foutmeldingLabel) {
        if(duur.equals("")) {
            foutmeldingLabel.setText("Vul a.u.b. alle velden in.");
            return false;
        }
        if(isStringInteger(duur)) {
            if(Integer.parseInt(duur) > 0 && Integer.parseInt(duur) < 366) {
                foutmeldingLabel.setText(" ");
                return true;
            } else {
                foutmeldingLabel.setText("Vul a.u.b een duur in tussen 1 en 365 dagen.");
                return false;
            }
        } else {
            foutmeldingLabel.setText("Vul a.u.b een geldige duur in.");
            return false;
        }
    }
    public static boolean isNameValid(String str, javax.swing.JLabel foutmeldingLabel) {
        if(str.matches(".*\\d+.*")) {
            foutmeldingLabel.setText("Controleer a.u.b. de spelling van uw naam.");
            return false;
        } else {
            foutmeldingLabel.setText(" ");
            return true;
        }
    }
}
