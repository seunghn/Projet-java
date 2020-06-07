package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class Seance_sDAO extends DAO<Seance_s> {
	public Seance_sDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Seance_s obj) {
		String req = "INSERT INTO seance_salle (id_seance,id_salle) VALUES('" + obj.getidseance() +"','"+obj.getidsalle()+ "')";

		try {
			connect.executeUpdate(req);
		} catch (SQLException e) {
			System.out.println("Connexion echouee : probleme SQL");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean delete(Seance_s obj) {
		String req = "DELETE FROM seance_salle WHERE id_seance= " + obj.getidseance();

		try {
			connect.executeUpdate(req);
		} catch (SQLException e) {
			System.out.println("Connexion echouee : probleme SQL");
			e.printStackTrace();
		}
		

		return false;
	}

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean update(Seance_s obj) {////JESUIS LA
		delete(obj);
		create(obj);

		return false;
	}

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public Seance_s find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Seance_s seance=new Seance_s();
	
		String req = "SELECT * FROM seance_salle WHERE id_seance= " + id;
		final String sep = ",";
		String res;
	
		try {
			liste = connect.gettable(req);
		} catch (SQLException e) {
			System.out.println("Connexion echouee : probleme SQL");
			e.printStackTrace();
		}
	
		res = liste.get(0);
		String champs[] = res.split(sep);
		seance.setidseance(champs[0]);
		
		seance.setidsalle(champs[1]);
		
		
		

		return seance;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Seance_s> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance_s> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
		String req = "SELECT * FROM seance_groupe";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		
		if(liste.isEmpty())
		{
			L=null;
		}
		for (int i = 0; i <liste.size(); i++) {
			Seance_s seance=new Seance_s();
			res = liste.get(i);
			String champs[] = res.split(sep);
			seance.setidseance(champs[0]);
			
			seance.setidsalle(champs[1]);
			
			
			L.add(seance);

		}

		return L;
	}

	@Override
	public ArrayList<Seance_s> cherche(String param, String value) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance_s> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
		String req = "SELECT * FROM seance_salle WHERE "+param+"='"+value+"'";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		
		if(liste.isEmpty())
		{
			L=null;
		}
		for (int i = 0; i <liste.size(); i++) {
			Seance_s seance=new Seance_s();
			res = liste.get(i);
			String champs[] = res.split(sep);
			seance.setidseance(champs[0]);
			
			seance.setidsalle(champs[1]);
			
			
			L.add(seance);

		}

		return L;
	}
	
	
	
	
}