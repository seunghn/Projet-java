package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class SiteDAO extends DAO<Site> {
	public SiteDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Site obj) {
		String req = "INSERT INTO site (nom) VALUES('" + obj.getnom() +"')";

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
	public boolean delete(Site obj) {
		String req = "DELETE FROM site WHERE id= " + obj.getid();

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
	public boolean update(Site obj) {
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
	public Site find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Site site = new Site();
		
		String req = "SELECT * FROM site WHERE id= " + id;
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
		site.setid(champs[0]);
		
		site.setnom(champs[1]);
		
		

		return site;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Site> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Site> L = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("Site");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM Site";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			
			Site site = new Site();
			res = liste.get(i);
			String champs[] = res.split(sep);
			site.setid(champs[0]);
			
			site.setnom(champs[1]);
			
			
			L.add(site);

		}

		return L;
	}

	@Override
	public ArrayList<Site> cherche(String a, String b) {
		// TODO Auto-generated method stub
		return null;
	}
}
