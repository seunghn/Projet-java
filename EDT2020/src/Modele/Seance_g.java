package Modele;

public class Seance_g {

	
private int idseance = 0;
	
	
	private int idgroupe;

	public Seance_g(int idseance,int idgroupe) {
		this.idseance = idseance;
		
	
		this.idgroupe=idgroupe;
	}

	public Seance_g() {}

	public int getidseance() {
		return idseance;
	}
	
	

	public int getidgroupe() {
		return idgroupe;
	}
	
	
	public void setidseance(String s) {
		try {
			idseance = Integer.parseInt(s);
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
