package Modele;

import java.sql.SQLException;
import java.util.ArrayList;

public class TypeDAO extends DAO<Type> {

	
	public TypeDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Type obj) {
		String req = "INSERT INTO type_cours (nom) VALUES('" +obj.getnom()+ "')";

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
	public boolean delete(Type obj) {
		String req = "DELETE FROM type_cours WHERE id= " + obj.getid();

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
	public boolean update(Type obj) {
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
	public Type find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
	
		Type type=new Type();
		String req = "SELECT * FROM type_cours WHERE id= " + id;
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
		type.setid(champs[0]);
		
		type.setnom(champs[1]);
		
		

		return type;
	}
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Type> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		int nb = 0;
		final String sep = ",";
		String res;
		ArrayList<Type> L = new ArrayList(); // liste qu on veut rebnvoyer
		// recuperation nombre ligne
		try {
			nb = connect.nbligne("type_cours");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String req = "SELECT * FROM type_cours";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i < nb; i++) {
			

			Type type=new Type();
			res = liste.get(i);
			String champs[] = res.split(sep);
			type.setid(champs[0]);
			
			type.setnom(champs[1]);
			
			
			L.add(type);

		}

		return L;
	}

	@Override
	public ArrayList<Type> cherche(String a, String b) {
		// TODO Auto-generated method stub
		return null;
	}

}
