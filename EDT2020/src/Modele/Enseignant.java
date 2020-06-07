package Modele;

public class Enseignant {

	
private int idutilisateur= 0;
	
	private String nom = "";
	private int idcours;

	public Enseignant(int idutilisateur,int idcours) {
		this.idutilisateur = idutilisateur;
		
		
		this.idcours=idcours;
	}

	public Enseignant() {}

	public int getidutilisateur() {
		return idutilisateur;
	}
	
	
	
	public int getidcours() {
		return idcours;
	}
	
	
	public void setidutilisateur(String s) {
		try {
			idutilisateur = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

	
	public void setidcours(String s) {
		try {
			idcours = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
}
