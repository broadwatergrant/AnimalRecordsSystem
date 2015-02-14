package com.grantbroadwater.gui;

import java.awt.Color;

import javax.swing.*;

import com.grantbroadwater.AnimalRecordsSystem;
import com.grantbroadwater.staff.Staff;
import com.grantbroadwater.staff.StaffMember;

import java.awt.*; 
import java.awt.event.*;

public class SetUpPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlStaff;

	public SetUpPanel() {
		super();
		
		// Panel
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Staff Members(info text) label
		JLabel lbl_currStaff = new JLabel("Current Staff");
		setFont(new Font(lbl_currStaff.getFont().getName(), Font.PLAIN, 16));
		lbl_currStaff.setSize(195, 20);
		lbl_currStaff.setLocation(5,1);
		add(lbl_currStaff);
		
		// Staff Panel
				pnlStaff = new JPanel();
				pnlStaff.setLayout(null);
				pnlStaff.setBackground(new Color(224, 224, 224));
				pnlStaff.setSize(200, 579);
				pnlStaff.setLocation(0, 21);
				pnlStaff.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				fillStaffPanel();
				add(pnlStaff);
				
				// New Staff Member (info text) label
				JLabel lbl_nSM = new JLabel("New Staff Member");
				lbl_nSM.setFont(new Font(lbl_nSM.getFont().getName(), Font.PLAIN, 16));
				lbl_nSM.setSize(500, 20);
				lbl_nSM.setLocation(250,0);
				add(lbl_nSM);
				
				// First Name (info text) label
				JLabel lbl_fN = new JLabel("First Name:");
				lbl_fN.setFont(new Font(lbl_fN.getFont().getName(), Font.PLAIN, 14));
				lbl_fN.setSize(500, 20);
				lbl_fN.setLocation(300,80);
				add(lbl_fN);
				
				// First Name text box
				final JTextField tb_fN = new JTextField();
				tb_fN.setFont(new Font(tb_fN.getFont().getName(), Font.PLAIN, 14));
				tb_fN.setSize(300, 30);
				tb_fN.setLocation(300,110);
				tb_fN.setText("");
				add(tb_fN);
				
				// Last Name (info text) label
				JLabel lbl_lN = new JLabel("Last Name:");
				lbl_lN.setFont(new Font(lbl_lN.getFont().getName(), Font.PLAIN, 14));
				lbl_lN.setSize(500, 20);
				lbl_lN.setLocation(300,180);
				add(lbl_lN);
				
				// Last Name text box
				final JTextField tb_lN = new JTextField();
				tb_lN.setFont(new Font(tb_lN.getFont().getName(), Font.PLAIN, 14));
				tb_lN.setSize(300, 30);
				tb_lN.setLocation(300,210);
				tb_lN.setText("");
				add(tb_lN);
				
				// Password (info text) label
				JLabel lbl_p = new JLabel("Password:");
				lbl_p.setFont(new Font(lbl_p.getFont().getName(), Font.PLAIN, 14));
				lbl_p.setSize(500, 20);
				lbl_p.setLocation(300,280);
				add(lbl_p);
				
				// Password text box
				final JTextField tb_p = new JTextField();
				tb_p.setFont(new Font(tb_p.getFont().getName(), Font.PLAIN, 14));
				tb_p.setSize(300, 30);
				tb_p.setLocation(300,310);
				tb_p.setText("");
				add(tb_p);
				
				// Is Owner Check Box
				final JCheckBox cb_o = new JCheckBox("This user is an owner");
				cb_o.setFont(new Font(cb_o.getFont().getName(), Font.PLAIN, 14));
				cb_o.setSize(300, 30);
				cb_o.setLocation(300, 380);
				cb_o.setBackground(Color.WHITE);
				add(cb_o);
				
				// Add Button
				JButton btn_add = new JButton("Add");
				btn_add.setFont(new Font(btn_add.getFont().getName(), Font.PLAIN, 14));
				btn_add.setSize(80, 25);
				btn_add.setLocation(670, 480);
				btn_add.setActionCommand("0");
				btn_add.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							addStaffMember(tb_fN.getText(),
									tb_lN.getText(),
									tb_p.getText(),
									cb_o.isSelected());
							clearFields(tb_fN, tb_lN, tb_p, cb_o);
						}
					}
				);
				add(btn_add);
				
				// Clear Button
				JButton btn_clear = new JButton("Clear");
				btn_clear.setFont(new Font(btn_clear.getFont().getName(), Font.PLAIN, 14));
				btn_clear.setSize(80, 25);
				btn_clear.setLocation(570, 480);
				btn_clear.setActionCommand("1");
				btn_clear.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							clearFields(tb_fN, tb_lN, tb_p, cb_o);
						}
					}
				);
				add(btn_clear);
				
				// Delete Button
				JButton btn_delete = new JButton("Delete");
				btn_delete.setFont(new Font(btn_delete.getFont().getName(), Font.PLAIN, 14));
				btn_delete.setSize(80, 25);
				btn_delete.setLocation(470, 480);
				btn_delete.setActionCommand("2");
				btn_delete.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							deleteStaffMember(tb_p.getText());
							clearFields(tb_fN, tb_lN, tb_p, cb_o);
						}
					}
				);
				add(btn_delete);
				
				// Done Button
				JButton btn_done = new JButton("Done");
				btn_done.setFont(new Font(btn_done.getFont().getName(), Font.PLAIN, 14));
				btn_done.setSize(80, 25);
				btn_done.setLocation(710, 530);
				btn_done.setActionCommand("3");
				btn_done.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							AnimalRecordsSystem.getStaff().saveStaff();
						}
					}
				);
				add(btn_done);
	}

	private void fillStaffPanel() {
		// Erases current labels
				for(Component c : pnlStaff.getComponents()){
					if(c instanceof JLabel) pnlStaff.remove(c);
				}
				
				// Gets All of current staff
				StaffMember[] staff = AnimalRecordsSystem.getStaffArray();
				
				// Adds visual elements to panel
				if(staff.length==0){
					JLabel lbl2 = new JLabel("No staff members");
					lbl2.setFont(new Font(lbl2.getFont().getName(), Font.PLAIN, 14));
					lbl2.setSize(180, 20);
					lbl2.setLocation(5,0);
					pnlStaff.add(lbl2);
				}else{
					for(int i = 0; i < staff.length; i++){
						JLabel lbl = new JLabel(staff[i].getName());
						lbl.setFont(new Font(lbl.getFont().getName(), Font.PLAIN, 14));
						lbl.setSize(180, 20);
						lbl.setLocation(5,i*25);
						lbl.setToolTipText(staff[i].toStringForSave().replaceAll(":", " ").replace(';', ' '));
						lbl.setVisible(true);
						pnlStaff.add(lbl);
					}
				}
		AnimalRecordsSystem.getFrame().updateGraphics();
	}
	
	private void addStaffMember(String fN, String lN, String p, boolean o){
		if(fN.equals("") || lN.equals("") || p.equals("")){
			JOptionPane.showMessageDialog(null, "Please complete all fields and confirm that"+
					"\npassword is not identical to an existing password");
			return;
		}
		AnimalRecordsSystem.getStaff().add(new StaffMember(fN, lN, p, o));
		fillStaffPanel();
	}
	
	private void deleteStaffMember(String p){
		if(p.equals("")){
			JOptionPane.showMessageDialog(null, "Please insert a valid pin");
			return;
		}
		Staff staff = AnimalRecordsSystem.getStaff();
		for(String key : staff.getKeySet()){
			if(key.equals(p)){
				staff.remove(staff.getStaffMemberWithPin(p));
				fillStaffPanel();
				return;
			}
		}
	}
	
	protected static void clearFields(JTextField fN, JTextField lN, JTextField p, JCheckBox o){
		fN.setText("");
		lN.setText("");
		p.setText("");
		o.setSelected(false);
	}

}
