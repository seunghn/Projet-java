package Modele;

public class Groupe {

	
	private int id = 0;
	
	private String nom = "";
	private int idpromo;

	public Groupe(int id, String nom,int idpromo) {
		this.id = id;
		
		this.nom = nom;
		this.idpromo=idpromo;
	}

	public Groupe() {}

	public int getid() {
		return id;
	}
	
	
	public String getnom() {
		return nom;
	}
	public int getidpromo() {
		return idpromo;
	}
	
	
	public void setid(String s) {
		try {
			id = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

	
	public void setnom(String s) {
		nom = s;
	}
	public void setidpromo(String s) {
		try {
			idpromo = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
}
