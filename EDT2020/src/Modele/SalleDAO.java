package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalleDAO extends DAO<Salle> {

	
	public SalleDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Salle obj) {
		String req = "INSERT INTO salle (nom,cap,id_site) VALUES('" + obj.getnom() +"','"+obj.getcap()+"','"+obj.getidsite()+ "')";

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
	public boolean delete(Salle obj) {
		String req = "DELETE FROM salle WHERE id= " + obj.getid();

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
	public boolean update(Salle obj) {
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
	public Salle find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Salle salle = new Salle ();
		
		String req = "SELECT * FROM salle WHERE id= " + id;
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
		salle.setid(champs[0]);
		salle.setnom(champs[1]);
		salle.setcap(champs[2]);
		salle.setidsite(champs[3]);
		

		return salle;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Salle> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Salle> L = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("salle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM salle";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			Salle salle = new Salle ();
			res = liste.get(i);
			String champs[] = res.split(sep);
			salle.setid(champs[0]);
			salle.setnom(champs[1]);
			salle.setcap(champs[2]);
			salle.setidsite(champs[3]);
			
			L.add(salle);

		}

		return L;
	}

	@Override
	public ArrayList<Salle> cherche(String a, String b) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Salle> L = new ArrayList(); // liste qu on veut rebnvoyer
	
		String req = "SELECT * FROM salle WHERE "+a+" ='"+b+"'";
		System.out.println(req);
		try {
			liste = connect.gettable(req);
		} catch (SQLException z) {
			System.out.println("3Connexion Echouee : probleme SQL");
			z.printStackTrace();
		}
		for (int i = 0; i < liste.size(); i++) {
			Salle salle = new Salle ();
			res = liste.get(i);
			String champs[] = res.split(sep);
			salle.setid(champs[0]);
			salle.setnom(champs[1]);
			salle.setcap(champs[2]);
			salle.setidsite(champs[3]);
			
			L.add(salle);

		}

		return L;
	}
}
