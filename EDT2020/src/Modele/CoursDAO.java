package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoursDAO extends DAO<Cours> {

	public CoursDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Cours obj) {
		String req = "INSERT INTO cours (nom) VALUES('" + obj.getnom() + "')";

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
	public boolean delete(Cours obj) {
		String req = "DELETE FROM  cours WHERE id= " + obj.getid();

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
	public boolean update(Cours obj) {
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
	public Cours find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Cours cours = new Cours();
		String req = "SELECT * FROM cours WHERE id= " + id;
		System.out.println(req);
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
		cours.setid(champs[0]);
		cours.setnom(champs[1]);

		return cours;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Cours> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Cours> Lcours = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("cours");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String req = "SELECT * FROM cours";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			Cours cours = new Cours(0, "0");
			res = liste.get(i);
			String champs[] = res.split(sep);
			cours.setid(champs[0]);
			cours.setnom(champs[1]);
			Lcours.add(cours);

		}

		return Lcours;
	}

	@Override
	public ArrayList<Cours> cherche(String a, String b) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Cours> Lcours = new ArrayList(); // liste qu on veut rebnvoyer
	
		String req = "SELECT * FROM cours WHERE "+a+"= '"+b+"'";
		try {
			liste = connect.gettable(req);
		} catch (SQLException x) {
			System.out.println("3Connexion Echouee : probleme SQL");
			x.printStackTrace();
		}
		for (int i = 0; i < liste.size(); i++) {
			Cours cours = new Cours(0, "0");
			res = liste.get(i);
			String champs[] = res.split(sep);
			cours.setid(champs[0]);
			cours.setnom(champs[1]);
			Lcours.add(cours);

		}

		return Lcours;
	}

}
