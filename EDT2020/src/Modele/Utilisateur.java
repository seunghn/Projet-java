package Modele;

public class Utilisateur {

	private int id = 0;
	private String email = "";
	private String password = "";
	private String nom = "";
	private String prenom = "";
	private int droit ;

	public Utilisateur(int id, String email, String password, String nom, String prenom, int droit) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.droit = droit;

	}

	public Utilisateur() {}

	public int getid() {
		return id;
	}
	public String getemail() {
		return email;
	}
	public String getpassword() {
		return password;
	}
	public String getnom() {
		return nom;
	}
	public String getprenom() {
		return prenom;
	}
	public int getdroit() {
		return droit;
	}
	
	public void setid(String s) {
		try {
			id = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

	public void setemail(String s) {
		email = s;
	}
	public void setpassword(String s) {
		password = s;
	}
	public void setnom(String s) {
		nom = s;
	}
	public void setprenom(String s) {
		prenom = s;
	}
	public void setdroit(String s) {
		try {
			droit = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}
	}
	
}
