package Modele;

public class Etudiant {

	private int idutilisateur = 0;

	private int numero;
	private int idgroupe;

	public Etudiant(int idutilisateur, int numero, int idgroupe) {
		this.idutilisateur = idutilisateur;

		this.numero = numero;
		this.idgroupe = idgroupe;
	}

	public Etudiant() {
	}

	public int getidutilisateur() {
		return idutilisateur;
	}

	public int getnumero() {
		return numero;
	}

	public int getidgroupe() {
		return idgroupe;
	}

	public void setidutilisateur(String s) {
		try {
			idutilisateur = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setnumero(String s) {
		try {
			numero = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setidgroupe(String s) {
		try {
			idgroupe = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

}
