package Modele;

public class Type {
	
	
	

	private int id = 0;
	
	private String nom = "";
	

	public Type(int id, String nom) {
		this.id = id;
		
		this.nom = nom;
		
	}

	public Type() {}

	public int getid() {
		return id;
	}

	
	public String getnom() {
		return nom;
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
	

}
