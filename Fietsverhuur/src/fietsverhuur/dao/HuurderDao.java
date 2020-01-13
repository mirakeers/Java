/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Huurder;
/**
 *
 * @author MaartenH
 */
public class HuurderDao {
        public static ArrayList<Huurder> getHuurders() {
		ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder ORDER BY huurderId desc");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

        public static boolean doesHuurderExist(int id) {
            boolean resultaat = false;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where huurderId = ?", new Object[] { id });
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
        
	public static Huurder getHuurderById(int id) {
		Huurder resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where huurderId = ?", new Object[] { id });
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
        public static ArrayList<Huurder> searchHuurdersByNaam(String voornaam, String achternaam) {
            ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder WHERE voornaam like concat('%',?,'%') AND achternaam like concat('%',?,'%');", new Object[] { voornaam , achternaam});
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        public static ArrayList<Huurder> searchHuurdersByVoornaam(String voornaam) {
            ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where voornaam like concat('%',?,'%');", new Object[] { voornaam });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Huurder> searchHuurdersByAchternaam(String achternaam) {
            ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where achternaam LIKE concat('%',?,'%');", new Object[] { achternaam });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Huurder> searchHuurdersByStad(String stad) {
            ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where stad LIKE concat('%',?,'%');", new Object[] { stad });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
        public static ArrayList<Huurder> searchHuurdersByTelefoonnummer(String telefoonnummer) {
            ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where telefoonnummer LIKE concat('%',?,'%');", new Object[] { telefoonnummer });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }

        public static ArrayList<Huurder> searchHuurdersByEmailadres(String emailadres) {
            ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurder where emailadres LIKE concat('%',?,'%');", new Object[] { emailadres });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurder huidigeHuurder = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurder);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
	public static int voegHuurderToe(Huurder nieuweHuurder) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Huurder (voornaam, achternaam, adres, stad, telefoonnummer, emailadres) VALUES (?,?,?,?,?,?)", new Object[] { nieuweHuurder.getVoornaam(), nieuweHuurder.getAchternaam(), nieuweHuurder.getAdres(), nieuweHuurder.getStad(), nieuweHuurder.getTelefoonnummer(), nieuweHuurder.getEmailadres() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateHuurder(Huurder nieuweHuurder) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Huurder SET voornaam = ?, achternaam = ?, adres = ?, stad = ?, telefoonnummer = ?, emailadres = ? WHERE huurderId = ?", new Object[] { nieuweHuurder.getVoornaam(), nieuweHuurder.getAchternaam(), nieuweHuurder.getAdres(), nieuweHuurder.getStad(), nieuweHuurder.getTelefoonnummer(), nieuweHuurder.getEmailadres(), nieuweHuurder.getHuurderId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderHuurder(int huurderId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Huurder WHERE huurderId = ?", new Object[] { huurderId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Huurder converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Huurder(mijnResultset.getInt("huurderId"), mijnResultset.getString("voornaam"), mijnResultset.getString("achternaam"), mijnResultset.getString("adres"), mijnResultset.getString("stad"), mijnResultset.getString("telefoonnummer"), mijnResultset.getString("emailadres"));
	}
}
