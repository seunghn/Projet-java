package Controle;

import java.sql.SQLException;
import java.util.ArrayList;

import Modele.Cours;
import Modele.DAO;
import Modele.Enseignant;
import Modele.Etudiant;
import Modele.Factory;
import Modele.Groupe;
import Modele.Promotion;
import Modele.Salle;
import Modele.Seance;
import Modele.Seance_e;
import Modele.Seance_g;
import Modele.Seance_s;
import Modele.Site;
import Modele.Type;
import Modele.Utilisateur;

public class edt {

	private Utilisateur user;
	public  DAO<Cours> CoursDAO;
	public ArrayList<coursaff> ccaff;
	public ArrayList<String> aff ;
	public  DAO<Utilisateur> UtilisateurDAO;
	 public DAO<Enseignant> EnseignantDAO;
	 public DAO<Etudiant> EtudiantDAO;
	 public DAO<Groupe> GroupeDAO;
	 public DAO<Promotion> PromotionDAO;
	 public DAO<Salle> SalleDAO;
	 public DAO<Seance_e> Seance_eDAO;
	 public DAO<Seance_g> Seance_gDAO;
	 public DAO<Seance_s> Seance_sDAO;
	 public DAO<Seance> SeanceDAO;
	 public DAO<Site> SiteDAO;
	 public DAO<Type> TypeDAO;
	public Utilisateur getuser() {return user;}
	 public edt()
	 {
		 user=null;
		 
		 CoursDAO= Factory.getCoursDAO();
	 UtilisateurDAO= Factory.getUtilisateurDAO();
			 EnseignantDAO= Factory.getEnseignantDAO();
			EtudiantDAO= Factory.getEtudiantDAO();
		 GroupeDAO= Factory.getGroupeDAO();
		 PromotionDAO= Factory.getPromotionDAO();
			 SalleDAO= Factory.getSalleDAO();
			 Seance_eDAO= Factory.getSeance_eDAO();
		Seance_gDAO= Factory.getSeance_gDAO();
			 Seance_sDAO= Factory.getSeance_sDAO();
			 SeanceDAO= Factory.getSeanceDAO();
			 SiteDAO= Factory.getSiteDAO();
			 TypeDAO= Factory.getTypeDAO();
		 
		 
		 
	 }
	 
	
	
	public void identification(String logs)
	{
 ArrayList<Utilisateur> result = new ArrayList();
		//si l utilisateur est valideuser.setid()
 String sep=",";
 String champs[] = logs.split(sep);
 result=UtilisateurDAO.cherche(champs[0],champs[1]);
 if(result!=null)
 {
	 
	 user=result.get(0);
	 
 }else {System.out.println("connection invalide");
 user=null;
 
 }
		
		
		
		
		
		
	}
	public String shearch(String table,String param,String value)
	{
		System.out.println(param);
		System.out.println(value);
		String id="";
		if(table.equals("enseignant"))
		{
			ArrayList<Utilisateur>ut=UtilisateurDAO.all();
			if(!ut.isEmpty())
				{
				for(int i=0;i<ut.size();i++)
				{
					if(ut.get(i).getnom().contentEquals(value)) {id=String.valueOf(ut.get(i).getid());
					
					
					
					System.out.println("l id utilisateur ecuperé par ma merde"+id);}
					
				}
				
				}
		}
		if(table.equals("groupe"))
		{
			ArrayList<Groupe>ut=GroupeDAO.cherche(param, value);
			System.out.println("param  "+param+"value   "+value);
			if(!ut.isEmpty())
			{
				id=String.valueOf(ut.get(0).getid());
			}
			
		}
		if(table.equals("salle"))
		{
			ArrayList<Salle>ut=SalleDAO.cherche(param, value);
			if(!ut.isEmpty())
			{
				id=String.valueOf(ut.get(0).getid());
			}
		}
		
		return id;
	}
	
	public void deconnection()
	{user=null;}
	public void get(int semaine,String param,String val)
	{
		ArrayList<coursaff> liste=new ArrayList();
		String profs="";
		String salles="";
		String groupes="";
		String type="";
		String cours="";
		//paréam c est soit  groupe soit salles soit prof
		if(param.equals("id_groupe"))
		{
			ArrayList<Seance_g>lsg=new ArrayList();
			lsg=Seance_gDAO.cherche(param, val);
			ArrayList<Seance>ls=new ArrayList();//ma liste de seances
			for(int i=0;i<lsg.size();i++)
			{
				ls.add(SeanceDAO.cherche(String.valueOf(semaine), String.valueOf(lsg.get(i).getidseance())).get(0));
			}
			//donc la j ai ma liste de seance
			//pour chque cours
			for(int i=0;i<ls.size();i++)
			{
				cours="";
				type="";
				groupes="";
				salles="";
				profs="";
				//on recup le sprof
				ArrayList<Seance_e>lse=new ArrayList();
				System.out.println("id de la seance"+ls.get(i).getid());
				lse=Seance_eDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				System.out.println("taille de lse"+lse.size());
				//on recup le salles
				ArrayList<Seance_s>lss=new ArrayList();
				lss=Seance_sDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				lsg=Seance_gDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				for(int j=0;j<lse.size();j++)
				{
					profs=profs+UtilisateurDAO.find(lse.get(j).getidenseignant()).getnom()+" "+UtilisateurDAO.find(lse.get(j).getidenseignant()).getprenom()+",";
				}
				for(int j=0;j<lss.size();j++)
				{
					salles=salles+SalleDAO.find(lss.get(j).getidsalle()).getnom()+",";
				}
				for(int j=0;j<lsg.size();j++)
				{
					groupes=groupes+GroupeDAO.find(lsg.get(j).getidgroupe()).getnom()+",";
				}
				type=TypeDAO.find(ls.get(i).getidtype()).getnom();
				cours=CoursDAO.find(ls.get(i).getidcours()).getnom();
				
				coursaff cc =new coursaff(ls.get(i).getdate(),ls.get(i).gethd(),ls.get(i).gethd(),cours,type,profs,groupes,salles);
				liste.add(cc);
			}
			
		}
		if(param.equals("id_salle"))
		{
			ArrayList<Seance_s>lss=new ArrayList();
			lss=Seance_sDAO.cherche(param, val);
			ArrayList<Seance>ls=new ArrayList();//ma liste de seances
			for(int i=0;i<lss.size();i++)
			{
				ls.add(SeanceDAO.cherche(String.valueOf(semaine), String.valueOf(lss.get(i).getidseance())).get(0));
			}
			//donc la j ai ma liste de seance
			
			//pour chque cours
			for(int i=0;i<ls.size();i++)
			{
				cours="";
				type="";
				groupes="";
				salles="";
				profs="";
				//on recup le sprof
				ArrayList<Seance_e>lse=new ArrayList();
				//System.out.println("id de la seance"+ls.get(i).getid());
				lse=Seance_eDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				//System.out.println("taille de lse"+lse.size());
				ArrayList<Seance_g>lsg=new ArrayList();
				lss=Seance_sDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				lsg=Seance_gDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				
				for(int j=0;j<lse.size();j++)
				{
					profs=profs+UtilisateurDAO.find(lse.get(j).getidenseignant()).getnom()+" "+UtilisateurDAO.find(lse.get(j).getidenseignant()).getprenom()+",";
				}
				for(int j=0;j<lss.size();j++)
				{
					salles=salles+SalleDAO.find(lss.get(j).getidsalle()).getnom()+",";
				}
				for(int j=0;j<lsg.size();j++)
				{
					groupes=groupes+GroupeDAO.find(lsg.get(j).getidgroupe()).getnom()+",";
				}
				type=TypeDAO.find(ls.get(i).getidtype()).getnom();
				cours=CoursDAO.find(ls.get(i).getidcours()).getnom();
				
				coursaff cc =new coursaff(ls.get(i).getdate(),ls.get(i).gethd(),ls.get(i).gethd(),cours,type,profs,groupes,salles);
				liste.add(cc);
			}
		}
		if(param.equals("id_enseignant"))
		{
			ArrayList<Seance_e>lse=new ArrayList();
			lse=Seance_eDAO.cherche(param, val);
			ArrayList<Seance>ls=new ArrayList();//ma liste de seances
			for(int i=0;i<lse.size();i++)
			{
				ls.add(SeanceDAO.cherche(String.valueOf(semaine), String.valueOf(lse.get(i).getidseance())).get(0));
			}
			//donc la j ai ma liste de seance
			
			//pour chque cours
			for(int i=0;i<ls.size();i++)
			{
				cours="";
				type="";
				groupes="";
				salles="";
				profs="";
				//on recup le sprof
				ArrayList<Seance_s>lss=new ArrayList();
				//System.out.println("id de la seance"+ls.get(i).getid());
				lss=Seance_sDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				//System.out.println("taille de lse"+lse.size());
				ArrayList<Seance_g>lsg=new ArrayList();
				lss=Seance_sDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				lsg=Seance_gDAO.cherche("id_seance", String.valueOf(ls.get(i).getid()));
				
				for(int j=0;j<lse.size();j++)
				{
					profs=profs+UtilisateurDAO.find(lse.get(j).getidenseignant()).getnom()+" "+UtilisateurDAO.find(lse.get(j).getidenseignant()).getprenom()+",";
				}
				for(int j=0;j<lss.size();j++)
				{
					salles=salles+SalleDAO.find(lss.get(j).getidsalle()).getnom()+",";
				}
				for(int j=0;j<lsg.size();j++)
				{
					groupes=groupes+GroupeDAO.find(lsg.get(j).getidgroupe()).getnom()+",";
				}
				type=TypeDAO.find(ls.get(i).getidtype()).getnom();
				cours=CoursDAO.find(ls.get(i).getidcours()).getnom();
				
				coursaff cc =new coursaff(ls.get(i).getdate(),ls.get(i).gethd(),ls.get(i).gethd(),cours,type,profs,groupes,salles);
				liste.add(cc);
			}
		}
		
		
		ccaff= liste;
		
		
		
	}
	
	
	
}
