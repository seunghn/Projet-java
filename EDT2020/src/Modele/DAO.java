package Modele;

import java.util.ArrayList;

public abstract class DAO<T> {
  protected Connexion connect = null;
   
  public DAO(Connexion conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
  public abstract ArrayList<T> cherche(String a,String b);
  public abstract ArrayList<T> all();
}