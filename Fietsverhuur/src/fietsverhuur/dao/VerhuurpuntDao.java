/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Verhuurpunt;
/**
 *
 * @author MaartenH
 */
public class VerhuurpuntDao {
        public static ArrayList<Verhuurpunt> getVerhuurpunten() {
		ArrayList<Verhuurpunt> resultaat = new ArrayList<Verhuurpunt>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuurpunt");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Verhuurpunt huidigVerhuurpunt = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigVerhuurpunt);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

        public static boolean doesVerhuurpuntExist(int id) {
            boolean resultaat = false;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuurpunt where verhuurpuntId = ?", new Object[] { id });
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
        
	public static Verhuurpunt getVerhuurpuntById(int id) {
		Verhuurpunt resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verhuurpunt where verhuurpuntId = ?", new Object[] { id });
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

	public static int voegVerhuurpuntToe(Verhuurpunt nieuwVerhuurpunt) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Verhuurpunt (naam, adres, stad, telefoonnummer, emailadres) VALUES (?,?,?,?,?)", new Object[] { nieuwVerhuurpunt.getNaam(), nieuwVerhuurpunt.getAdres(), nieuwVerhuurpunt.getStad(), nieuwVerhuurpunt.getTelefoonnummer(), nieuwVerhuurpunt.getEmailadres() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateVerhuurpunt(Verhuurpunt nieuwVerhuurpunt) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Verhuurpunt SET naam = ?, adres = ?, stad = ?, telefoonnummer = ?, emailadres = ? WHERE verhuurpuntId = ?", new Object[] { nieuwVerhuurpunt.getNaam(), nieuwVerhuurpunt.getAdres(), nieuwVerhuurpunt.getStad(), nieuwVerhuurpunt.getTelefoonnummer(), nieuwVerhuurpunt.getEmailadres(), nieuwVerhuurpunt.getVerhuurpuntId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderVerhuurpunt(int verhuurpuntId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Verhuurpunt WHERE verhuurpuntId = ?", new Object[] { verhuurpuntId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Verhuurpunt converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Verhuurpunt(mijnResultset.getInt("verhuurpuntId"), mijnResultset.getString("naam"), mijnResultset.getString("adres"), mijnResultset.getString("stad"), mijnResultset.getString("telefoonnummer"), mijnResultset.getString("emailadres"));
	}
}
