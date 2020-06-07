package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class Seance_eDAO extends DAO<Seance_e> {
	public Seance_eDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Seance_e obj) {
		String req = "INSERT INTO seance_enseignants (id_seance,id_enseignants) VALUES('" + obj.getidseance() +"','"+obj.getidenseignant()+ "')";

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
	public boolean delete(Seance_e obj) {
		String req = "DELETE FROM seance_enseignants WHERE id_seance= " + obj.getidseance();

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
	public boolean update(Seance_e obj) {////JESUIS LA
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
	public Seance_e find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Seance_e seance=new Seance_e();
	
		String req = "SELECT * FROM seance_enseignants WHERE id_seance= " + id;
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
		
		seance.setidenseignant(champs[1]);
		
		
		

		return seance;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Seance_e> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance_e> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
		String req = "SELECT * FROM seance_enseignants";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i <liste.size(); i++) {
			Seance_e seance=new Seance_e();
			
			if(liste.isEmpty())
			{
				res = liste.get(i);
				String champs[] = res.split(sep);
				seance.setidseance(champs[0]);
				
				seance.setidenseignant(champs[1]);
				
				
				L.add(seance);
			}else {
				L=null;
			}
			

		}

		return L;
	}

	@Override
	public ArrayList<Seance_e> cherche(String param, String value) {
		// TODO Auto-generated method stub
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance_e> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
		String req = "SELECT * FROM seance_enseignants WHERE "+param+ " = "+value+"";
		System.out.println(req);
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i <liste.size(); i++) {
			Seance_e seance=new Seance_e();
			
			if(!liste.isEmpty())
			{
				res = liste.get(i);
				String champs[] = res.split(sep);
				seance.setidseance(champs[0]);
				
				seance.setidenseignant(champs[1]);
				
				System.out.println(seance.getidenseignant());
				System.out.println(seance.getidseance());
				L.add(seance);
			}else {
				System.out.println("vas bien te faire foutre");
				L=null;
			}
			

		}

		return L;
	}
	
	
	
	
}
