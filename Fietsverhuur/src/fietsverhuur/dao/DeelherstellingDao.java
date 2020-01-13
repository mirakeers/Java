/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Deelherstelling;
/**
 *
 * @author MaartenH
 */
public class DeelherstellingDao {
        public static ArrayList<Deelherstelling> getDeelherstellingen() {
		ArrayList<Deelherstelling> resultaat = new ArrayList<Deelherstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Deelherstelling");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Deelherstelling huidigeDeelherstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeDeelherstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}


        public static ArrayList<Deelherstelling> getDeelherstellingenByHerstellingId(int id) {
		ArrayList<Deelherstelling> resultaat = new ArrayList<Deelherstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Deelherstelling where herstellingId = ?", new Object[] { id });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Deelherstelling huidigeDeelherstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeDeelherstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}
        
        public static ArrayList<Deelherstelling> getDeelherstellingenByDefectnummer(int id) {
		ArrayList<Deelherstelling> resultaat = new ArrayList<Deelherstelling>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Deelherstelling where defectnummer = ?", new Object[] { id });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Deelherstelling huidigeDeelherstelling = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeDeelherstelling);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}
        
        public static int verwijderDeelherstellingenByHerstellingId(int verhuringId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Deelherstelling WHERE herstellingId = ?", new Object[] { verhuringId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}
        
	public static int voegDeelherstellingToe(Deelherstelling nieuweDeelherstelling) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Deelherstelling (herstellingId, defectnummer) VALUES (?,?)", new Object[] { nieuweDeelherstelling.getHerstellingId(), nieuweDeelherstelling.getDefectnummer()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Deelherstelling converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Deelherstelling(mijnResultset.getInt("herstellingId"), mijnResultset.getInt("defectnummer"));
	}
}
