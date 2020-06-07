package Modele;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {
	protected static final Connexion conn = Edtco.getco();
 
	 public static DAO getCoursDAO(){
		    return new CoursDAO(conn);
		  }
	 public static DAO getUtilisateurDAO(){
		    return new UtilisateurDAO(conn);
		  }
	 public static DAO getPromotionDAO(){
		    return new PromotionDAO(conn);
		  }
	 
	 public static DAO getGroupeDAO(){
		    return new GroupeDAO(conn);
		  }
			
	 public static DAO getEtudiantDAO(){
		    return new EtudiantDAO(conn);
		  }
	 public static DAO getTypeDAO(){
		    return new TypeDAO(conn);
		  }
	 public static DAO getEnseignantDAO(){
		    return new EnseignantDAO(conn);
		  }
	 public static DAO getSiteDAO(){
		    return new SiteDAO(conn);
		  }
	 public static DAO getSalleDAO(){
		    return new SalleDAO(conn);
		  }
	 public static DAO getSeanceDAO(){
		    return new SeanceDAO(conn);
		  }
	
	 public static DAO getSeance_eDAO(){
		    return new Seance_eDAO(conn);
		  }
	
	 public static DAO getSeance_sDAO(){
		    return new Seance_sDAO(conn);
		  }
	
	 public static DAO getSeance_gDAO(){
		    return new Seance_gDAO(conn);
		  }
	
}	
