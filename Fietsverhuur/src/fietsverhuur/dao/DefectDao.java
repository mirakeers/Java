/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Defect;
/**
 *
 * @author MaartenH
 */
public class DefectDao {
        public static ArrayList<Defect> getDefecten() {
		ArrayList<Defect> resultaat = new ArrayList<Defect>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Defect");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Defect huidigDefect = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigDefect);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

        public static boolean doesDefectnummerExist(int id) {
            boolean resultaat = false;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Defect where defectnummer = ?", new Object[] { id });
			if (mijnResultset != null) {
                            if(mijnResultset.first()) {
                                resultaat = true;
                            }
			}
		} catch (SQLException ex) {
			//ex.printStackTrace();
		}
            return resultaat;
        }
	public static Defect getDefectById(int id) {
		Defect resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Defect where defectnummer = ?", new Object[] { id });
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

	public static int voegDefectToe(Defect nieuwDefect) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Defect (beschrijving, onkostMateriaalInEuro, duurInMin) VALUES (?,?,?)", new Object[] { nieuwDefect.getBeschrijving(), nieuwDefect.getOnkostMateriaalInEuro(), nieuwDefect.getDuurInMin() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateDefect(Defect nieuwDefect) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Defect SET beschrijving = ?, onkostMateriaalInEuro = ?, duurInMin = ? WHERE defectnummer = ?", new Object[] { nieuwDefect.getBeschrijving(), nieuwDefect.getOnkostMateriaalInEuro(), nieuwDefect.getDuurInMin(), nieuwDefect.getDefectnummer() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderDefect(int defectnummer) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Defect WHERE defectnummer = ?", new Object[] { defectnummer });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Defect converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Defect(mijnResultset.getInt("defectnummer"), mijnResultset.getString("beschrijving"), mijnResultset.getFloat("onkostMateriaalInEuro"), mijnResultset.getFloat("duurInMin"));
	}
}
