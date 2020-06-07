package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class EtudiantDAO extends DAO<Etudiant>{

	
	public EtudiantDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Etudiant obj) {
		String req = "INSERT INTO etudiant (id_utilisateur,numero,id_groupe) VALUES('" + obj.getidutilisateur() +"','"+obj.getnumero()+"','"+obj.getidgroupe()+ "')";

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
	public boolean delete(Etudiant obj) {
		String req = "DELETE FROM etudiant WHERE id_utilisateur= " + obj.getidutilisateur();

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
	public boolean update(Etudiant obj) {
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
	public Etudiant find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		
		Etudiant etudiant=new Etudiant();
		String req = "SELECT * FROM etudiant WHERE id_utilisateur= " + id;
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
		etudiant.setidutilisateur(champs[0]);
		etudiant.setnumero(champs[1]);
		etudiant.setidgroupe(champs[2]);
		
		
		
		

		return etudiant;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Etudiant> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Etudiant> L = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("etudiant");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM etudiant";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			
			Etudiant etudiant=new Etudiant();
			res = liste.get(i);
			String champs[] = res.split(sep);
			etudiant.setidutilisateur(champs[0]);
			etudiant.setnumero(champs[1]);
			etudiant.setidgroupe(champs[2]);
			
			
			L.add(etudiant);

		}

		return L;
	}

	@Override
	public ArrayList<Etudiant> cherche(String a, String b) {
		// TODO Auto-generated method stub
		return null;
	}
}
