/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

/**
 *
 * @author Seung
 */
public class interfaceG extends JFrame implements ActionListener{
   private JPanel panel;
   private JLabel email,password;
   private JTextField email_saisie;
   private JPasswordField password_saisie;
   private JButton connecter; 
   
   
   public interfaceG() {
                
                //definition image de l'ecran d'accueil
                ImageIcon image = new ImageIcon("images.png");
                JLabel img = new JLabel("", image, JLabel.CENTER);
               
                //pour la partie email du debut
                email = new JLabel();
                email.setText("email :");
                email_saisie=new JTextField(20);
                
                //partie password du debut
                password = new JLabel();
                password.setText("password :");
                password_saisie = new JPasswordField(20);
                
                //affichage bouton se connecter
                connecter = new JButton("se connecter");
                this.getContentPane().add(connecter,BorderLayout.SOUTH);
                connecter.addActionListener(this);
                
                //affichage
                panel = new JPanel();
                panel.add(img);
                panel.add(email);
                panel.add(email_saisie);
                panel.add(password);
                panel.add(password_saisie);
                
                //parametres fenetre
                this.add(panel);             
                this.setSize(250,400);
		this.setTitle("Connexion");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}	

   public void actionPerformed(ActionEvent ae){
      String email = email_saisie.getText();
      String password = password_saisie.getText();
      if (email.trim().equals("admin") && password.trim().equals("admin")){
      this.setVisible(false);
      new interfaceG2();
      }else if(email.trim().equals("etudiant") && password.trim().equals("etudiant")){
          this.setVisible(false);
          new interfaceG3();
      }
      
   }
   
   public static void main(String[] args) {
      new interfaceG();
   }
}
