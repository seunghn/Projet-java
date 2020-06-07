package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class PromotionDAO extends DAO<Promotion> {

	
	
	public PromotionDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Promotion obj) {
		String req = "INSERT INTO promotion (nom) VALUES('" + obj.getnom()+ "')";

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
	public boolean delete(Promotion obj) {
		String req = "DELETE FROM promotion WHERE id= " + obj.getid();

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
	public boolean update(Promotion obj) {
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
	public Promotion find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Promotion promotion = new Promotion();
		String req = "SELECT * FROM promotion WHERE id= " + id;
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
		promotion.setid(champs[0]);
		
		promotion.setnom(champs[2]);
		
		

		return promotion;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Promotion> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Promotion> Lpromotion = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("promotion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM promotion";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			
			Promotion promotion = new Promotion();
			res = liste.get(i);
			String champs[] = res.split(sep);
			promotion.setid(champs[0]);
			
			promotion.setnom(champs[2]);
			Lpromotion.add(promotion);

		}

		return Lpromotion;
	}

	@Override
	public ArrayList<Promotion> cherche(String a, String b) {
		// TODO Auto-generated method stub
		return null;
	}

}
