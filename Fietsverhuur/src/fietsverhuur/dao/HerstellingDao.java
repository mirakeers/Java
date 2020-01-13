/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Herstelling;
/**
 *
 * @author MaartenH
 */
public class HerstellingDao {
        public static ArrayList<Herstelling> getHerstellingen() {
		ArrayList<Herstelling> resultaat = new ArrayList<Herstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Herstelling ORDER BY herstellingId desc");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Herstelling huidigeHerstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHerstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Herstelling getHerstellingById(int id) {
		Herstelling resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Herstelling where herstellingId = ?", new Object[] { id });
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
        
        public static ArrayList<Herstelling> getHerstellingenByMeldingsdatum(java.util.Date meldingsdatum) {
            ArrayList<Herstelling> resultaat = new ArrayList<Herstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Herstelling where meldingsdatum = ?", new Object[] { meldingsdatum });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Herstelling huidigeHerstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHerstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        public static ArrayList<Herstelling> getHerstellingenByHuurderId(int huurderId) {
            ArrayList<Herstelling> resultaat = new ArrayList<Herstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Herstelling where huurderId = ?", new Object[] { huurderId });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Herstelling huidigeHerstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHerstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Herstelling> getHerstellingenByFietsnummer(int fietsnummer) {
            ArrayList<Herstelling> resultaat = new ArrayList<Herstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Herstelling where fietsnummer = ?", new Object[] { fietsnummer });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Herstelling huidigeHerstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHerstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }

	public static int voegHerstellingToe(Herstelling nieuweHerstelling) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Herstelling (meldingsdatum, huurderId, fietsnummer) VALUES (?,?,?)", new Object[] { nieuweHerstelling.getMeldingsdatum(), nieuweHerstelling.getHuurderId(), nieuweHerstelling.getFietsnummer() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateHerstelling(Herstelling nieuweHerstelling) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Herstelling SET meldingsdatum = ?, huurderId = ?, fietsnummer = ? WHERE herstellingId = ?", new Object[] { nieuweHerstelling.getMeldingsdatum(), nieuweHerstelling.getHuurderId(), nieuweHerstelling.getFietsnummer(), nieuweHerstelling.getHerstellingId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}
        

	public static int verwijderHerstelling(int herstellingId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Herstelling WHERE herstellingId = ?", new Object[] { herstellingId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Herstelling converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Herstelling(mijnResultset.getInt("herstellingId"), mijnResultset.getDate("meldingsdatum"), mijnResultset.getInt("huurderId"), mijnResultset.getInt("fietsnummer"));
	}
}
