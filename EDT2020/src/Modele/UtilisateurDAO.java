package Modele;

import java.sql.SQLException;
import java.util.ArrayList;


public class UtilisateurDAO extends DAO<Utilisateur> {

	public UtilisateurDAO(Connexion conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode pour inserer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Utilisateur obj) {
		String req = "INSERT INTO utilisateurs (email,password,nom,prenom,droit) VALUES('" + obj.getemail() +"','"+obj.getpassword()+"','"+obj.getnom()+"','"+obj.getprenom()+"','"+obj.getdroit()+ "')";

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
	public boolean delete(Utilisateur obj) {
		String req = "DELETE FROM utilisateurs WHERE id= " + obj.getid();

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
	public boolean update(Utilisateur obj) {
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
	public Utilisateur find(int id) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		Utilisateur utilisateur = new Utilisateur();
		String req = "SELECT * FROM utilisateurs WHERE id= " + id;
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
		utilisateur.setid(champs[0]);
		utilisateur.setemail(champs[1]);
		utilisateur.setpassword(champs[2]);
		utilisateur.setnom(champs[3]);
		utilisateur.setprenom(champs[4]);
		utilisateur.setdroit(champs[5]);
		

		return utilisateur;
	}
	
	/**
	 * Méthode pour recupperer toute la table
	 * 
	 * @param obj
	 * @return boolean
	 */
	public ArrayList<Utilisateur> all() {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Utilisateur> L = new ArrayList(); // liste qu on veut rebnvoyer
		String req = "SELECT * FROM utilisateurs";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i <liste.size(); i++) {
			
			Utilisateur utilisateur = new Utilisateur();
			if(!liste.isEmpty())
			{
				res = liste.get(i);
				String champs[] = res.split(sep);
				utilisateur.setid(champs[0]);
				utilisateur.setemail(champs[1]);
				utilisateur.setpassword(champs[2]);
				utilisateur.setnom(champs[3]);
				utilisateur.setprenom(champs[4]);
				utilisateur.setdroit(champs[5]);
				L.add(utilisateur);
			}else {
				L=null;
			}
		}

		return L;
	}
	public ArrayList<Utilisateur> cherche(String mail,String password) {// EXEPTIONS
		ArrayList<String> liste;
		liste = new ArrayList<>();
		
		final String sep = ",";
		String res;
		ArrayList<Utilisateur> L = new ArrayList(); // liste qu on veut rebnvoyer
		String req = "SELECT * FROM utilisateurs WHERE email= '"+mail +"' AND password= '"+password+"'";
		try {
			liste = connect.gettable(req);
		} catch (SQLException b) {
			System.out.println("3Connexion Echouee : probleme SQL");
			b.printStackTrace();
		}
		for (int i = 0; i <liste.size(); i++) {
			
			Utilisateur utilisateur = new Utilisateur();
			
			if(!liste.isEmpty())
			{
				res = liste.get(i);
				String champs[] = res.split(sep);
				utilisateur.setid(champs[0]);
				utilisateur.setemail(champs[1]);
				utilisateur.setpassword(champs[2]);
				utilisateur.setnom(champs[3]);
				utilisateur.setprenom(champs[4]);
				utilisateur.setdroit(champs[5]);
				L.add(utilisateur);
			}else {
				L=null;
			}
			

		}

		return L;
	}
	

}