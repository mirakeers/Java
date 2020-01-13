/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Verhuring;
/**
 *
 * @author MaartenH
 */
public class VerhuringDao {
        public static ArrayList<Verhuring> getVerhuringen() {
		ArrayList<Verhuring> resultaat = new ArrayList<Verhuring>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring ORDER BY verhuringId desc");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuring huidigeVerhuring = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeVerhuring);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Verhuring getVerhuringById(int id) {
		Verhuring resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring where verhuringId = ?", new Object[] { id });
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
        
        public static ArrayList<Verhuring> getVerhuringenByBegindatum(java.util.Date begindatum) {
            ArrayList<Verhuring> resultaat = new ArrayList<Verhuring>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring where begindatum = ?", new Object[] { begindatum });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuring huidigeVerhuring = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeVerhuring);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Verhuring> getVerhuringenByEinddatum(java.util.Date einddatum) {
            ArrayList<Verhuring> resultaat = new ArrayList<Verhuring>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring where DATE_ADD(begindatum, INTERVAL duurInDagen DAY) = ?", new Object[] { einddatum });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuring huidigeVerhuring = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeVerhuring);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Verhuring> getVerhuringenByHuurderId(int huurderId) {
            ArrayList<Verhuring> resultaat = new ArrayList<Verhuring>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring where huurderId = ?", new Object[] { huurderId });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuring huidigeVerhuring = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeVerhuring);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Verhuring> getVerhuringenByFietsnummer(int fietsnummer) {
            ArrayList<Verhuring> resultaat = new ArrayList<Verhuring>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring where fietsnummer = ?", new Object[] { fietsnummer });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuring huidigeVerhuring = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeVerhuring);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Verhuring> getVerhuringenByDuurInDagen(int minduur, int maxduur) {
            ArrayList<Verhuring> resultaat = new ArrayList<Verhuring>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuring where duurInDagen BETWEEN ? AND ?", new Object[] { minduur, maxduur });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuring huidigeVerhuring = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeVerhuring);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }

	public static int voegVerhuringToe(Verhuring nieuweVerhuring) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Verhuring (begindatum, duurInDagen, huurderId, fietsnummer) VALUES (?,?,?,?)", new Object[] { nieuweVerhuring.getBegindatum(), nieuweVerhuring.getDuurInDagen(), nieuweVerhuring.getHuurderId(), nieuweVerhuring.getFietsnummer() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateVerhuring(Verhuring nieuweVerhuring) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Verhuring SET begindatum = ?, duurInDagen = ?, huurderId = ?, fietsnummer = ? WHERE verhuringId = ?", new Object[] { nieuweVerhuring.getBegindatum(), nieuweVerhuring.getDuurInDagen(), nieuweVerhuring.getHuurderId(), nieuweVerhuring.getFietsnummer(), nieuweVerhuring.getVerhuringId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderVerhuring(int verhuringId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Verhuring WHERE verhuringId = ?", new Object[] { verhuringId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Verhuring converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Verhuring(mijnResultset.getInt("verhuringId"), mijnResultset.getDate("begindatum"), mijnResultset.getInt("duurInDagen"), mijnResultset.getInt("huurderId"), mijnResultset.getInt("fietsnummer"));
	}
}
