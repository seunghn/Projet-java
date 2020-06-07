package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class SeanceDAO extends DAO<Seance> {

	
	public SeanceDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Seance obj) {
		String req = "INSERT INTO seance (semaine,date,heure_debut,heure_fin,etat,id_cours,id_type) VALUES('" + obj.getsemaine() +"','"+obj.getdate()+"','"+obj.gethd() +"','"+obj.gethf() +"','"+obj.getetat() +"','"+obj.getidcours() +"','"+obj.getidtype()+ "')";

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
	public boolean delete(Seance obj) {
		String req = "DELETE FROM seance WHERE id= " + obj.getid();

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
	public boolean update(Seance obj) {
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
	public Seance find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Seance seance=new Seance();
		
		String req = "SELECT * FROM seance WHERE id= " + id;
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
		seance.setid(champs[0]);
		seance.setsemaine(champs[1]);
		seance.setdate(champs[2]);
		seance.sethd(champs[3]);
		seance.sethf(champs[4]);
		seance.setetat(champs[5]);
		seance.setidcours(champs[6]);
		seance.setidtype(champs[7]);
		
		
		

		return seance;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Seance> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance> L = new ArrayList(); // liste qu on veut rebnvoyer
		
		String req = "SELECT * FROM seance";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < liste.size(); i++) {
			
			Seance seance=new Seance();
			res = liste.get(i);
			String champs[] = res.split(sep);
			seance.setid(champs[0]);
			seance.setsemaine(champs[1]);
			seance.setdate(champs[2]);
			seance.sethd(champs[3]);
			seance.sethf(champs[4]);
			seance.setetat(champs[5]);
			seance.setidcours(champs[6]);
			seance.setidtype(champs[7]);
			
			
			L.add(seance);

		}
		if(liste.isEmpty())
		{
			L=null;
		}

		return L;
	}

	@Override
	public ArrayList<Seance> cherche(String semaine, String id) {
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Seance> L = new ArrayList(); // liste qu on veut rebnvoyer
		
		String req = "SELECT * FROM seance WHERE semaine = "+semaine+" AND id= "+id;
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < liste.size(); i++) {
			
			Seance seance=new Seance();
			res = liste.get(i);
			String champs[] = res.split(sep);
			seance.setid(champs[0]);
			seance.setsemaine(champs[1]);
			seance.setdate(champs[2]);
			seance.sethd(champs[3]);
			seance.sethf(champs[4]);
			seance.setetat(champs[5]);
			seance.setidcours(champs[6]);
			seance.setidtype(champs[7]);
			
			
			L.add(seance);

		}
		if(liste.isEmpty())
		{
			L=null;
		}

		return L;
	}
}
