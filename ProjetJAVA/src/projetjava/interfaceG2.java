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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class interfaceG2 extends JFrame{
  private JMenuBar barre = new JMenuBar();
  private JMenu menu1 = new JMenu("Emploi du temps");
  private JMenu menu2 = new JMenu("Rechercher");
  private JMenu menu3 = new JMenu("Mettre à jour");
  
  private JMenu menu4 = new JMenu("Affecter");
  private JMenu menu5 = new JMenu("Ajouter");
  private JMenu menu6 = new JMenu("Modifier");

  private JMenuItem sousMenu1 = new JMenuItem("Par enseignant");
  private JMenuItem sousMenu2 = new JMenuItem("Par etudiant");
  private JMenuItem sousMenu3 = new JMenuItem("Par groupe");
  private JMenuItem sousMenu4 = new JMenuItem("Par promotion");
  private JMenuItem sousMenu5 = new JMenuItem("Par salle");
  
  private JMenuItem sousMenu6 = new JMenuItem("affecter un enseignant");
  private JMenuItem sousMenu7 = new JMenuItem("affecter une seance");
  private JMenuItem sousMenu8 = new JMenuItem("affecter une salle");
  private JMenuItem sousMenu9 = new JMenuItem("ajouter une seance");
  private JMenuItem sousMenu10 = new JMenuItem("ajouter un enseingnant");
  private JMenuItem sousMenu11 = new JMenuItem("ajouter un groupe");
  private JMenuItem sousMenu12 = new JMenuItem("deplacer seance");
  private JMenuItem sousMenu13 = new JMenuItem("annuler seance");
  
  private JPanel panel,panel2,panel3,panel4,panel5,panel6;
  private JLabel recherche,recherche2,recherche3,recherche4,heure,date;
  private JTextField recherche_barre,recherche_barre2,recherche_barre3,recherche_barre4,date_barre,heure_barre;


  public interfaceG2(){
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
            recherche = new JLabel();
            recherche.setText("Nom de l'enseignant :");
            recherche_barre=new JTextField(10);
            panel = new JPanel();
          
            panel.add(recherche);
            panel.add(recherche_barre);
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            
        }
    });
    this.menu2.add(sousMenu3);
    sousMenu3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae3){
            
            panel.removeAll();
            recherche = new JLabel();
            recherche.setText("Numero de groupe :");
            recherche_barre=new JTextField(10);
            panel = new JPanel();
           
            panel.add(recherche);
            panel.add(recherche_barre);
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            
        }
    });
    this.menu2.add(sousMenu4);
    sousMenu4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae4){
            
            panel.removeAll();
            recherche = new JLabel();
            recherche.setText("Numero de promo :");
            recherche_barre=new JTextField(10);
            panel = new JPanel();
         
            panel.add(recherche);
            panel.add(recherche_barre);
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            
        }
    });
    this.menu2.add(sousMenu5);
    sousMenu5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae5){
            
            panel.removeAll();
            recherche = new JLabel();
            recherche.setText("Numero de salle :");
            recherche_barre=new JTextField(10);
            panel = new JPanel();
           
            panel.add(recherche);
            panel.add(recherche_barre);
            add(panel); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            panel.setVisible(true);
            
        }
    });

    this.menu3.add(menu4);
    this.menu3.add(menu5);
    this.menu3.add(menu6);
    
    this.menu4.add(sousMenu6);
    sousMenu6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae6){
            
            recherche = new JLabel();
            recherche.setText("nom de l'enseignant");
            recherche_barre=new JTextField(15);
            
            recherche2 = new JLabel();
            recherche2.setText("séance");
            recherche_barre2=new JTextField(15);
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu4.add(sousMenu7);
    sousMenu7.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae7){
            
            recherche = new JLabel();
            recherche.setText("numero de groupe");
            recherche_barre=new JTextField(15);
            
            recherche2 = new JLabel();
            recherche2.setText("séance");
            recherche_barre2=new JTextField(15);
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu4.add(sousMenu8);
    sousMenu8.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae8){
            
            recherche = new JLabel();
            recherche.setText("numero de salle");
            recherche_barre=new JTextField(15);
            
            recherche2 = new JLabel();
            recherche2.setText("séance");
            recherche_barre2=new JTextField(15);
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu5.add(sousMenu9);
    sousMenu9.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae9){
            
            date = new JLabel();
            date.setText("date");
            date_barre=new JTextField(10);
            
            heure = new JLabel();
            heure.setText("heure");
            heure_barre=new JTextField(10);
            
            recherche = new JLabel();
            recherche.setText("groupe");
            recherche_barre=new JTextField(10);
            
            recherche2 = new JLabel();
            recherche2.setText("enseignant");
            recherche_barre2=new JTextField(10);
            
            recherche3 = new JLabel();
            recherche3.setText("numéro de salle");
            recherche_barre3=new JTextField(10);
            
            recherche4 = new JLabel();
            recherche4.setText("cours");
            recherche_barre4=new JTextField(10);
            
            panel = new JPanel();
            panel.add(date);
            panel.add(date_barre);
            panel.add(heure);
            panel.add(heure_barre);
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            panel.add(recherche3);
            panel.add(recherche_barre3);
            panel.add(recherche4);
            panel.add(recherche_barre4);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu5.add(sousMenu10);
    sousMenu10.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae10){
            
            recherche = new JLabel();
            recherche.setText("nom de l'enseignant");
            recherche_barre=new JTextField(15);
            
            recherche2 = new JLabel();
            recherche2.setText("séance");
            recherche_barre2=new JTextField(15);
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu5.add(sousMenu11);
    sousMenu11.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae11){
           
            recherche = new JLabel();
            recherche.setText("numero de groupe");
            recherche_barre=new JTextField(15);
            
            recherche2 = new JLabel();
            recherche2.setText("séance");
            recherche_barre2=new JTextField(15);
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu6.add(sousMenu12);
    sousMenu12.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae12){
            
            recherche = new JLabel();
            recherche.setText("seance");
            recherche_barre=new JTextField(15);
            
            recherche2 = new JLabel();
            recherche2.setText("horaire");
            recherche_barre2=new JTextField(15);
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            panel.add(recherche2);
            panel.add(recherche_barre2);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    this.menu6.add(sousMenu13);
    sousMenu13.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae13){
            
            recherche = new JLabel();
            recherche.setText("seance");
            recherche_barre=new JTextField(15);
            
            
            panel = new JPanel();
            panel.add(recherche);
            panel.add(recherche_barre);
            
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    });
    
    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.barre.add(menu1);
    this.barre.add(menu2);
    this.barre.add(menu3);
    this.setJMenuBar(barre);
    this.setVisible(true);
  }

}