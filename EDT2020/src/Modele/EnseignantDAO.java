package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnseignantDAO extends DAO<Enseignant> {
	public EnseignantDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Enseignant obj) {
		String req = "INSERT INTO enseignant (id_utilisateur,id_cours) VALUES('" + obj.getidutilisateur() +"','"+obj.getidcours()+ "')";

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
	public boolean delete(Enseignant obj) {
		String req = "DELETE FROM enseignant WHERE id_utilisateur= " + obj.getidutilisateur();

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
	public boolean update(Enseignant obj) {
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
	public Enseignant find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Enseignant enseignant=new Enseignant ();
		
		String req = "SELECT * FROM enseignant WHERE id= " + id;
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
		enseignant.setidutilisateur(champs[0]);
		enseignant.setidcours(champs[1]);
		return enseignant;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Enseignant> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Enseignant> L = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("enseignant");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM enseignant";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			
			Enseignant enseignant=new Enseignant ();
			res = liste.get(i);
			String champs[] = res.split(sep);
			enseignant.setidutilisateur(champs[0]);
			enseignant.setidcours(champs[1]);
			
			L.add(enseignant);

		}

		return L;
	}

	@Override
	public ArrayList<Enseignant> cherche(String a, String b) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Enseignant> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
		String req = "SELECT * FROM enseignant WHERE "+a+"='"+b+"'";
		try {
			liste = connect.gettable(req);
		} catch (SQLException v) {
			System.out.println("3Connexion Echouee : probleme SQL");
			v.printStackTrace();
		}
		for (int i = 0; i < liste.size(); i++) {
			
			Enseignant enseignant=new Enseignant ();
			res = liste.get(i);
			String champs[] = res.split(sep);
			enseignant.setidutilisateur(champs[0]);
			enseignant.setidcours(champs[1]);
			
			L.add(enseignant);

		}

		return L;
	}
}
