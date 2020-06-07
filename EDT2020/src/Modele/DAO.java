package Modele;

import java.util.ArrayList;

public abstract class DAO<T> {
  protected Connexion connect = null;
   
  public DAO(Connexion conn){
    this.connect = conn;
  }
   
  /**
  * M�thode de cr�ation
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * M�thode de mise � jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * M�thode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
  public abstract ArrayList<T> cherche(String a,String b);
  public abstract ArrayList<T> all();
}