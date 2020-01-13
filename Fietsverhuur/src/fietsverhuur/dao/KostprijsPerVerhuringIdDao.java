/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.KostprijsPerVerhuringId;
/**
 *
 * @author MaartenH
 */
public class KostprijsPerVerhuringIdDao {
        public static ArrayList<KostprijsPerVerhuringId> getKostprijzenPerVerhuringId() {
		ArrayList<KostprijsPerVerhuringId> resultaat = new ArrayList<KostprijsPerVerhuringId>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT v.verhuringId, h.bedragPerDagInEuro * v.duurInDagen AS kostprijs" +
                        " FROM Verhuring v" +
                        " JOIN Huurprijs h ON v.duurInDagen BETWEEN h.minDuurInDagen AND h.maxDuurInDagen" +
                        " JOIN Fiets f ON v.fietsnummer = f.fietsnummer" +
                        " WHERE f.fietstype = h.fietstype;");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					KostprijsPerVerhuringId huidigeKostprijsPerVerhuringId = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeKostprijsPerVerhuringId);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}
        
        public static KostprijsPerVerhuringId getKostprijzenPerVerhuringIdByVerhuringId(int id) {
		KostprijsPerVerhuringId resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT v.verhuringId, h.bedragPerDagInEuro * v.duurInDagen AS kostprijs" +
                        " FROM Verhuring v" +
                        " JOIN Huurprijs h ON v.duurInDagen BETWEEN h.minDuurInDagen AND h.maxDuurInDagen" +
                        " JOIN Fiets f ON v.fietsnummer = f.fietsnummer" +
                        " WHERE f.fietstype = h.fietstype AND v.verhuringId = ?;", new Object[] { id });
			if (mijnResultset != null) {
				mijnResultset.first();
				resultaat = converteerHuidigeRijNaarObject(mijnResultset);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}
        
        public static ArrayList<KostprijsPerVerhuringId> getKostprijzenPerVerhuringIdByKostprijs(double minkostprijs, double maxkostprijs) {
            ArrayList<KostprijsPerVerhuringId> resultaat = new ArrayList<KostprijsPerVerhuringId>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT v.verhuringId, h.bedragPerDagInEuro * v.duurInDagen AS kostprijs" +
                        " FROM Verhuring v" +
                        " JOIN Huurprijs h ON v.duurInDagen BETWEEN h.minDuurInDagen AND h.maxDuurInDagen" +
                        " JOIN Fiets f ON v.fietsnummer = f.fietsnummer" +
                        " WHERE f.fietstype = h.fietstype AND h.bedragPerDagInEuro * v.duurInDagen BETWEEN ? AND ?", new Object[] { minkostprijs, maxkostprijs });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					KostprijsPerVerhuringId huidigeKostprijsPerVerhuringId = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeKostprijsPerVerhuringId);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
	
	private static KostprijsPerVerhuringId converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new KostprijsPerVerhuringId(mijnResultset.getInt("verhuringId"), mijnResultset.getDouble("kostprijs"));
	}
}
