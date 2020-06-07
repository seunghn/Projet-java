package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class Seance_gDAO extends DAO<Seance_g> {
	public Seance_gDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Seance_g obj) {
		String req = "INSERT INTO seance_groupe (id_seance,id_groupe) VALUES('" + obj.getidseance() +"','"+obj.getidgroupe()+ "')";

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
	public boolean delete(Seance_g obj) {
		String req = "DELETE FROM seance_groupe WHERE id_seance= " + obj.getidseance();

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
	public boolean update(Seance_g obj) {////JESUIS LA
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
	public Seance_g find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Seance_g seance=new Seance_g();
	
		String req = "SELECT * FROM seance_groupe WHERE id_seance= " + id;
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
		
		seance.setidgroupe(champs[1]);
		
		
		

		return seance;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Seance_g> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance_g> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
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
			Seance_g seance=new Seance_g();
			res = liste.get(i);
			String champs[] = res.split(sep);
			seance.setidseance(champs[0]);
			
			seance.setidgroupe(champs[1]);
			
			
			L.add(seance);

		}

		return L;
	}

	@Override
	public ArrayList<Seance_g> cherche(String param, String value) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance_g> L = new ArrayList(); // liste qu on veut rebnvoyer
		
	
		String req = "SELECT * FROM seance_groupe WHERE "+param+"='"+value+"'";
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
			Seance_g seance=new Seance_g();
			res = liste.get(i);
			String champs[] = res.split(sep);
			seance.setidseance(champs[0]);
			
			seance.setidgroupe(champs[1]);
			
			
			L.add(seance);

		}

		return L;
	}
	
	
	
	
}
