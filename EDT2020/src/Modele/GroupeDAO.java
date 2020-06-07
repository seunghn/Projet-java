package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class GroupeDAO extends DAO<Groupe> {
	public GroupeDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Groupe obj) {
		String req = "INSERT INTO groupe (nom,id_promo) VALUES('" + obj.getnom() +"','"+obj.getidpromo()+ "')";

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
	public boolean delete(Groupe obj) {
		String req = "DELETE FROM groupe WHERE id= " + obj.getid();

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
	public boolean update(Groupe obj) {
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
	public Groupe find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		Groupe groupe=new Groupe();
		String req = "SELECT * FROM groupe WHERE id= " + id;
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
		groupe.setid(champs[0]);
		
		groupe.setnom(champs[1]);
		groupe.setidpromo(champs[2]);
		
		

		return groupe;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Groupe> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Groupe> L = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("groupe");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM groupe";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			
			Groupe groupe=new Groupe();
			res = liste.get(i);
			String champs[] = res.split(sep);
			groupe.setid(champs[0]);
			
			groupe.setnom(champs[1]);
			groupe.setidpromo(champs[2]);
			
			L.add(groupe);

		}

		return L;
	}

	@Override
	public ArrayList<Groupe> cherche(String a, String b) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Groupe> L = new ArrayList(); // liste qu on veut rebnvoyer
		
		String req = "SELECT * FROM groupe WHERE "+a+" = '"+b+"'";
		try {
			liste = connect.gettable(req);
		} catch (SQLException w) {
			System.out.println("3Connexion Echouee : probleme SQL");
			w.printStackTrace();
		}
		for (int i = 0; i < liste.size(); i++) {
			
			Groupe groupe=new Groupe();
			res = liste.get(i);
			String champs[] = res.split(sep);
			groupe.setid(champs[0]);
			
			groupe.setnom(champs[1]);
			groupe.setidpromo(champs[2]);
			
			L.add(groupe);

		}

		return L;
	}
}
