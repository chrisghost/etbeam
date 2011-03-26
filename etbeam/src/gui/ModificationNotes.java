package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Annee;
import models.Departement;
import models.Semestre;
import models.UE;
import bd.Facade;

public class ModificationNotes extends JFrame{

	 private JPanel container = new JPanel();
     private JTextField jtf = new JTextField("  ");
     private JLabel label = new JLabel("Note");
	private JTextField jtf1 = new JTextField("  ");;
	private JLabel label1 = new JLabel("Etudiant");
     private String etudName;
     private float note;
	
     
     public ModificationNotes(){
     
     this.setTitle("Modification d'une note");
     this.setBounds(100, 100, 778, 376);
    // this.setSize(300, 300);
    // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setLocationRelativeTo(null);

     container.setBackground(Color.white);
     container.setLayout(new GridLayout(4,1));
            
     JPanel top = new JPanel();
     
     Font police = new Font("Arial", Font.BOLD, 11);
     jtf.setFont(police);
     jtf.setPreferredSize(new Dimension(40, 30));
     jtf.setForeground(Color.BLACK);  
     
     top.add(label);
     top.add(jtf);
     top.setBounds(200, 53, 40, 20);
             
     container.add(top);
     
 JPanel top1 = new JPanel();
     
     police = new Font("Arial", Font.BOLD, 11);
     jtf1.setFont(police);
     jtf1.setPreferredSize(new Dimension(70, 30));
     jtf1.setForeground(Color.BLACK);
     
     
     top1.add(label1);
     top1.add(jtf1);
     top1.setBounds(300, 53, 70, 20);
     container.add(top1);
     
   //Bouton de validation 
	JButton valid = new JButton("Valider");
		valid.setPreferredSize(new Dimension(40, 30));
		container.add(valid);
		
     this.setContentPane(container);
     this.setVisible(true);            
     }
}


