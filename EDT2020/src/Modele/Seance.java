package Modele;

import java.text.SimpleDateFormat;

public class Seance {

	
	private int id = 0;
	private int semaine;
	private String date;
	private String hd;

	private String hf;
	private int etat = 0;
	private int idcours = 0;
	private int idtype = 0;

	

	public Seance(int id,int semaine,String date,String hd,String hf,int etat,int idcours,int idtype) {
		this.id = id;
		this.semaine=semaine;
		this.date=date;
		this.hd=hd;
		this.hf=hf;
		this.etat=etat;
		this.idcours=idcours;
		this.idtype=idtype;

	}

	public Seance() {}

	public int getid() {
		return id;
	}
	public int getsemaine() {
		return semaine;
	}
	public String getdate() {
		return date;
	}
	public String gethd() {
		return hd;
	}
	public String gethf() {
		return hf;
	}
	public int getetat() {
		return etat;
	}
	public int getidcours() {
		return idcours;
	}
	public int getidtype() {
		return idtype;
	}
	
	
	public void setid(String s) {
		try {
			id = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setsemaine(String s) {
		try {
			semaine = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setetat(String s) {
		try {
			etat = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setidcours(String s) {
		try {
			idcours = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setidtype(String s) {
		try {
			idtype = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}

	}
	public void setdate(String s) {date=s;}
	public void sethd(String s) {hd=s;}
	public void sethf(String s) {hf=s;}

	
	
}
