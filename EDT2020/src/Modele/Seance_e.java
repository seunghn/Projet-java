package Modele;

public class Seance_e {
	private int idseance = 0;
	
	
	private int idenseignant;

	public Seance_e(int idseance,int idenseignant) {
		this.idseance = idseance;
		
	
		this.idenseignant=idenseignant;
	}

	public Seance_e() {}

	public int getidseance() {
		return idseance;
	}
	
	

	public int getidenseignant() {
		return idenseignant;
	}
	
	
	public void setidseance(String s) {
		try {
			idseance = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

	

	public void setidenseignant(String s) {
		try {
			idenseignant = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
}
