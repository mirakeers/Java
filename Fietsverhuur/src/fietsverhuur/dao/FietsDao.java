/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.dao;
import java.sql.*;
import java.util.ArrayList;

import fietsverhuur.model.Fiets;
import fietsverhuur.swing.*;
/**
 *
 * @author MaartenH
 */
public class FietsDao {
        public static ArrayList<Fiets> getFietsen() {
		ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets ORDER BY fietsnummer desc");
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
                    
			// Foutafhandeling naar keuze
		}

		return resultaat;
	}

        public static boolean doesFietsExist(int id) {
            boolean resultaat = false;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where fietsnummer = ?", new Object[] { id });
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
	public static Fiets getFietsById(int id) {
		Fiets resultaat = null;
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where fietsnummer = ?", new Object[] { id });
			if (mijnResultset != null) {
				mijnResultset.first();
				resultaat = converteerHuidigeRijNaarObject(mijnResultset);
			}
		} catch (SQLException ex) {
			//ex.printStackTrace();
		}

		return resultaat;
	}

        public static ArrayList<Fiets> getFietsenByGender(String gender) {
            ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where gender = ?", new Object[] { gender });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return resultaat;
        }
        
        public static ArrayList<Fiets> getFietsenByFietstype(String fietstype) {
            ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where fietstype = ?", new Object[] { fietstype });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return resultaat;
        }
        
        public static ArrayList<Fiets> getFietsenByVerhuurpuntId(int verhuurpuntId) {
            ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where verhuurpuntId = ?", new Object[] { verhuurpuntId });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return resultaat;
        }
        
        public static ArrayList<Fiets> getFietsenByAantalVitessen(int aantalVitessen) {
            ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where aantalVitessen = ?", new Object[] { aantalVitessen });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return resultaat;
        }
        
        public static ArrayList<Fiets> getFietsenByDikteBand(String dikteBand) {
            ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where dikteBand = ?", new Object[] { dikteBand });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return resultaat;
        }
        
        public static ArrayList<Fiets> searchFietsenByKleur(String kleur) {
            ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
		try {
			ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Fiets where kleur LIKE concat('%',?,'%');", new Object[] { kleur });
			if (mijnResultset != null) {
				while (mijnResultset.next()) {
					Fiets huidigeFiets = converteerHuidigeRijNaarObject(mijnResultset);
					resultaat.add(huidigeFiets);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}

		return resultaat;
        }
        
	public static int voegFietsToe(Fiets nieuweFiets) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Fiets (gender, fietstype, aantalVitessen, dikteBand, kleur, verhuurpuntId) VALUES (?,?,?,?,?,?)", new Object[] { nieuweFiets.getGender(), nieuweFiets.getFietstype(), nieuweFiets.getAantalVitessen(), nieuweFiets.getDikteBand(), nieuweFiets.getKleur(), nieuweFiets.getVerhuurpuntId()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int updateFiets(Fiets nieuweFiets) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Fiets SET gender = ?, fietstype = ?, aantalVitessen = ?, dikteBand = ?, kleur = ?, verhuurpuntId = ? WHERE fietsnummer = ?", new Object[] { nieuweFiets.getGender(), nieuweFiets.getFietstype(), nieuweFiets.getAantalVitessen(), nieuweFiets.getDikteBand(), nieuweFiets.getKleur(), nieuweFiets.getVerhuurpuntId(), nieuweFiets.getFietsnummer()});
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	public static int verwijderFiets(int fietsnummer) {
		int aantalAangepasteRijen = 0;
		try {
			aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Fiets WHERE fietsnummer = ?", new Object[] { fietsnummer });
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Foutafhandeling naar keuze
		}
		return aantalAangepasteRijen;
	}

	private static Fiets converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
		return new Fiets(mijnResultset.getInt("fietsnummer"), mijnResultset.getString("gender"), mijnResultset.getString("fietstype"), mijnResultset.getInt("aantalVitessen"), mijnResultset.getString("dikteBand"), mijnResultset.getString("kleur"), mijnResultset.getInt("verhuurpuntId"));
	}
}
