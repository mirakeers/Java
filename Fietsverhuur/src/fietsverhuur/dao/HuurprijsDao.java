/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Huurprijs;
/**
 *
 * @author MaartenH
 */
public class HuurprijsDao {
        public static ArrayList<Huurprijs> getHuurprijzen() {
		ArrayList<Huurprijs> resultaat = new ArrayList<Huurprijs>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurprijs");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Huurprijs huidigeHuurprijs = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeHuurprijs);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

	public static Huurprijs getHuurprijsById(int id) {
		Huurprijs resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Huurprijs where huurprijsId = ?", new Object[] { id });
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

	public static int voegHuurprijsToe(Huurprijs nieuweHuurprijs) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Huurprijs (minDuurInDagen, maxDuurInDagen, fietstype, bedragPerDagInEuro) VALUES (?,?,?,?)", new Object[] { nieuweHuurprijs.getMinDuurInDagen(), nieuweHuurprijs.getMaxDuurInDagen(), nieuweHuurprijs.getFietstype(), nieuweHuurprijs.getBedragPerDagInEuro()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateHuurprijs(Huurprijs nieuweHuurprijs) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Huurprijs SET minDuurInDagen = ?, maxDuurInDagen = ?, fietstype = ?, bedragPerDagInEuro = ? WHERE huurprijsId = ?", new Object[] { nieuweHuurprijs.getMinDuurInDagen(), nieuweHuurprijs.getMaxDuurInDagen(), nieuweHuurprijs.getFietstype(), nieuweHuurprijs.getBedragPerDagInEuro(), nieuweHuurprijs.getHuurprijsId() });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderHuurprijs(int huurprijsId) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Huurprijs WHERE huurprijsId = ?", new Object[] { huurprijsId });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Huurprijs converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Huurprijs(mijnResultset.getInt("huurprijsId"), mijnResultset.getInt("minDuurInDagen"), mijnResultset.getInt("maxDuurInDagen"), mijnResultset.getString("fietstype"), mijnResultset.getFloat("bedragPerDagInEuro"));
	}
}
