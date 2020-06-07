package Modele;

public class Salle {

	

	private int id = 0;
	
	private String nom = "";
	private int cap = 0;

	private int idsite;

	public Salle(int id, String nom,int cap,int idsite) {
		this.id = id;
		
		this.nom = nom;
		this.idsite=idsite;
		this.cap=cap;
	}

	public Salle() {}

	public int getid() {
		return id;
	}
	
	
	public String getnom() {
		return nom;
	}
	public int getidsite() {
		return idsite;
	}
	public int getcap() {
		return cap;
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
	public void setcap(String s) {
		try {
			cap = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setidsite(String s) {
		try {
			idsite = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

}
