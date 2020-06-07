package Modele;

public class Cours {

	
	private int id=0;
	private String nom="";
	public Cours(int id,String nom)
	{
		this.id=id;
	this.nom=nom;
	
	}
	public Cours() {}
	public int getid() {return id;}
	public String getnom() {return nom;}
	public void setid(String s) {
		try {id=Integer.parseInt(s);}catch(NumberFormatException e) {}
		
		}
	public void setnom(String s ) {nom=s;}
}
