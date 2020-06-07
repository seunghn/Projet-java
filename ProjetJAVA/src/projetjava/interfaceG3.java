/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

/**
 *
 * @author Seung
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class interfaceG3 extends JFrame{
  private JMenuBar barre = new JMenuBar();
  private JMenu menu1 = new JMenu("Emploi du temps");
  private JMenu menu2 = new JMenu("Rechercher");

  private JMenuItem sousMenu1 = new JMenuItem("Par enseignant");
  private JMenuItem sousMenu2 = new JMenuItem("Par etudiant");
  private JMenuItem sousMenu3 = new JMenuItem("Par groupe");
  private JMenuItem sousMenu4 = new JMenuItem("Par promotion");
  private JMenuItem sousMenu5 = new JMenuItem("Par salle");

  private JPanel panel;
  private JLabel recherche,recherche2,recherche3,recherche4,recherche5;
  private JTextField recherche_barre,recherche_barre2,recherche_barre3,recherche_barre4,recherche_barre5;
  private JTable tableau;
  private JFrame frame;
  
  public interfaceG3(){
    this.setSize(1000, 600);
    this.setTitle("emploi du temps");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    //On initialise nos menus      
    this.menu2.add(sousMenu1);
    sousMenu1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae1){
            
            recherche = new JLabel();
            recherche.setText("Nom de l'etudiant :");
            recherche_barre=new JTextField(10);
            panel = new JPanel();
            panel.add(recherche);
            validate();
            panel.add(recherche_barre);
         
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu2.add(sousMenu2);
    sousMenu2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae2){
            panel.removeAll();
            recherche2 = new JLabel();
            recherche2.setText("Nom de l'enseignant :");
            recherche_barre2=new JTextField(10);
            panel = new JPanel();
            panel.add(recherche2);
            validate();
            panel.add(recherche_barre2);
           
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu2.add(sousMenu3);
    sousMenu3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae3){
            panel.removeAll();
            recherche3 = new JLabel();
            recherche3.setText("Numero de groupe :");
            recherche_barre3=new JTextField(10);
            panel = new JPanel();
            panel.add(recherche3);
            validate();
            panel.add(recherche_barre3);
            
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu2.add(sousMenu4);
    sousMenu4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae4){
            panel.removeAll();
            recherche4 = new JLabel();
            recherche4.setText("Numero de promo :");
            recherche_barre4=new JTextField(10);
            panel = new JPanel();
            panel.add(recherche4);
            validate();
            panel.add(recherche_barre4);
            
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu2.add(sousMenu5);
    sousMenu5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae5){
            panel.removeAll();
            recherche5 = new JLabel();
            recherche5.setText("Numero de salle :");
            recherche_barre5=new JTextField(10);
            panel = new JPanel();
            panel.add(recherche5);
            validate();
            panel.add(recherche_barre5);
            
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });


    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.barre.add(menu1);
        menu1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae6){
             frame=new JFrame();
            
             
      Object[][] horaire = {   
      {"8.00-9.00","","","","",""},
      {"9.00-10.00","","","","",""},
      {"10.00-11.00","","","","",""},
      {"11.00-12.00","","","","",""},
      {"12.00-13.00","","","","",""},
      {"13.00-14.00","","","","",""},
      {"14.00-15.00","","","","",""},
      {"15.00-16.00","","","","",""},
      {"16.00-17.00","","","","",""},
      {"17.00-18.00","","","","",""},
      {"18.00-19.00","","","","",""},
      {"19.00-20.00","","","","",""},
      {"20.00-21.00","","","","",""},
      };

    String  jour[] = {"LUNDI", "MARDI", "MERCREDI", "JEUDI", "VENDREDI", "SAMEDI"};
    JTable tableau = new JTable(horaire, jour);
    
    getContentPane().add(new JScrollPane(tableau));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            
        }
    });
    
    this.barre.add(menu2);
    this.setJMenuBar(barre);
    this.setVisible(true);
  }

   
}