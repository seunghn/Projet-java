package Vue;

import java.util.ArrayList;
import java.util.Scanner;

public class Aff {
	//Scanner sc = new Scanner(System.in);
	//System.out.println("entrez 1 pour question 4, 2 pour question 5");
	//choix = sc.nextInt();
	
	public String getlogs()
	{
		String logs;
		Scanner sc = new Scanner(System.in);
		System.out.println("email?");
		logs=sc.next()+",";
		System.out.println("mdp?");
		logs=logs+ sc.next();
		
		return logs;
	}
	public int choix(int droit)
	{
		int choix;
		Scanner sc = new Scanner(System.in);
		System.out.print("0 pou consulter votre edt ");
		if(droit ==1 || droit ==2)
		{
			System.out.print("1 pou consulter un  edt ");
			
		}
		if(droit==1)
		{
			System.out.print("2 pour mettre a jour la bdd ");
			
		}
		System.out.print("3pour se deconnecter ");
		System.out.print("4 pour quitter ");
		choix=sc.nextInt();
		return choix;
	}
}
