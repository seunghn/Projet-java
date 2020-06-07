package Modele;

public class Seance_s {
private int idseance = 0;
	
	
	private int idsalle;

	public Seance_s(int idseance,int idsalle) {
		this.idseance = idseance;
		
	
		this.idsalle=idsalle;
	}

	public Seance_s() {}

	public int getidseance() {
		return idseance;
	}
	
	

	public int getidsalle() {
		return idsalle;
	}
	
	
	public void setidseance(String s) {
		try {
			idseance = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}

	

	public void setidsalle(String s) {
		try {
			idsalle = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
}
