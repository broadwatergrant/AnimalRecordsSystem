package com.grantbroadwater.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.grantbroadwater.AnimalRecordsSystem;
import com.grantbroadwater.staff.Staff;
import com.grantbroadwater.staff.StaffMember;
import com.grantbroadwater.util.Log;

public class SignInPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage logo;

	public SignInPanel() {		
		// Main Panel
		super();
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Frame
		AnimalRecordsSystem.getFrame().removeMenuBar();
		
		// Logo
		try {
			logo = ImageIO.read(new File(AnimalRecordsSystem.homeDirecotry+"\\resources\\logo.png"));
		} catch (Exception e) {
			new Log("Unable to load image");
		}
		
		// Name Label
				JLabel lblN = new JLabel("Name: ");
				lblN.setFont(new Font(lblN.getFont().getName(), Font.PLAIN, 16));
				lblN.setSize(195, 20);
				lblN.setLocation(404,100);
				add(lblN);
				
				// Name text box
				final JTextField tbN = new JTextField();
				tbN.setFont(new Font(tbN.getFont().getName(), Font.PLAIN, 14));
				tbN.setSize(300, 30);
				tbN.setLocation(404,125);
				tbN.setHorizontalAlignment(JTextField.RIGHT);
				tbN.setText("");
				add(tbN);
				
				// Password Label
				JLabel lblP = new JLabel("Password: ");
				lblP.setFont(new Font(lblP.getFont().getName(), Font.PLAIN, 16));
				lblP.setSize(195, 20);
				lblP.setLocation(404,185);
				add(lblP);
				
				// Password text box
				final JPasswordField tbP = new JPasswordField();
				tbP.setFont(new Font(tbP.getFont().getName(), Font.PLAIN, 14));
				tbP.setSize(300, 30);
				tbP.setLocation(404,210);
				tbP.setHorizontalAlignment(JTextField.RIGHT);
				tbP.setText("");
				add(tbP);
				
				
		// Sign In Button
		JButton btnL = new JButton("Sign In");
		btnL.setFont(new Font(btnL.getFont().getName(), Font.PLAIN, 14));
		btnL.setSize(80, 25);
		btnL.setLocation(650, 320);
		btnL.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String n = tbN.getText();
				String p = new String(tbP.getPassword());
				signInAttempt(n.toUpperCase().trim(), p.toUpperCase().trim());
			}
		});
		add(btnL);
	}
	
	public void signInAttempt(String name, String p){
		if(name.equals("") || p.equals("")){
			JOptionPane.showMessageDialog(null, "Pease complete all fields");
			return;
		}
		Staff staff = AnimalRecordsSystem.getStaff();
		for(String key : staff.getKeySet()){
			StaffMember sm = staff.getStaffMemberWithPin(key);
			if(sm != null){
				if(sm.getName().equalsIgnoreCase(name)
						|| sm.getFirstName().equalsIgnoreCase(name)
						|| sm.getLastName().equalsIgnoreCase(name)){
					
					if(sm.getPin().equals(p)){
						AnimalRecordsSystem.signUserIn(sm);
						return;
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "User not recognized", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "User not recognized", "Error", JOptionPane.WARNING_MESSAGE);
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(logo, 0, 0, 379, 758, null);
	}
	
}
