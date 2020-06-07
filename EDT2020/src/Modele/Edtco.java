package Modele;

import java.sql.SQLException;

public class Edtco {
private static Connexion maco;
private Edtco()
{
	
	 try {
         try {
             // tentative de connexion si les 4 attributs sont remplis
             //maconnexion = new Connexion("jps", "root", "");
             maco = new Connexion("edt", "root", "");

         } catch (ClassNotFoundException cnfe) {
             System.out.println("Connexion echouee : probleme de classe");
             cnfe.printStackTrace();
         }
     } catch (SQLException e) {
         System.out.println("Connexion echouee : probleme SQL");
         e.printStackTrace();
     }
	
}
public static Connexion getco()
{
	if(maco==null)
	{new Edtco();}
	return maco;


}

}
