package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import models.Utilisateur;
import bd.Facade;

import java.awt.color.ColorSpace;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Login extends JFrame {
	private JTextField login;
	private JTextField password;
	private EtBeamIF IF;
	private JLabel head;
	
	public Login(EtBeamIF iF) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EtBeamGui.class.getResource("/images/res/logo_trans.png")));
		setMinimumSize(new Dimension(391, 196));
		setTitle("Login");
		setResizable(false);
		this.IF = iF;
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		head = new JLabel("Veuillez vous connecter pour continuer");
		panel_1.add(head);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnChicken = new JButton("Chicken");
		panel_2.add(btnChicken);
		
		JButton btnConnection = new JButton("Connection");
		
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connect();
			}
		});
		panel_2.add(btnConnection);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(82, 12, 248, 34);
		panel_3.add(panel_4);
		
		JLabel lblLogin = new JLabel("Login");
		panel_4.add(lblLogin);
		
		login = new JTextField();
		panel_4.add(login);
		login.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(49, 52, 263, 31);
		panel_3.add(panel_5);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		panel_5.add(lblMotDePasse);
		
		password = new JTextField();
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		panel_5.add(password);
		password.setColumns(10);
		
		this.setVisible(true);
	}

	
	private void connect(){
		Utilisateur u = Facade.makeUtilisateur(login.getText(), password.getText().toCharArray());

		u.connect();

		if(u.getLogged()){
			Facade.setCurrentUser(u);
			((EtBeamGui) IF).connection();
			setVisible(false);
		}
		else{
			head.setText("Login ou mot de passe incorrect.");
			head.setForeground(new Color(255, 0, 0));
		}
	}
}
