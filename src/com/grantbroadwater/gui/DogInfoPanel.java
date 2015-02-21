package com.grantbroadwater.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.grantbroadwater.animal.HairType;
import com.grantbroadwater.animal.Sex;

public class DogInfoPanel extends SpecificInfoPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField breedNameTextField;
	private JTextField wrLowTextField;
	private JComboBox<HairType> hairTypeComboBox;
	private JTextField hairColorTextField;
	private JTextField wrHighTextField;
	private JComboBox<Sex> sexComboBox;
	private JComboBox<Boolean> fleaComboBox;
	private JTextField fleaTestTextField;
	private JComboBox<String> heartwormComboBox;
	private JTextField firstHeartwormTextField;
	private JTextField resetHeartwormTextField;
	private JComboBox<Boolean> rabiesComboBox;
	private JComboBox<Boolean> distemperComboBox;
	private JComboBox<Boolean> bordetellaComboBox;
	private JComboBox<Boolean> spayedNeuteredComboBox;
	private JTextField spayedNeuteredTextField;
	
	public DogInfoPanel() {
		super();
		
		int w = 125;
		
		JLabel title = new JLabel("Dog Information");
		title.setFont(new Font(this.getFont().getName(), Font.PLAIN, 20));
		title.setLocation(150, 10);
		title.setSize(300, 40);
		add(title);
		
		// Breed Label
		JLabel lblBreedName = new JLabel("Breed:");
		lblBreedName.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblBreedName.setLocation(10, 65);
		lblBreedName.setSize(w, 20);
		add(lblBreedName);
		
		// Breed Name Text Field
		breedNameTextField = new JTextField();
		breedNameTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		breedNameTextField.setLocation(10, 85);
		breedNameTextField.setSize(w, 20);
		add(breedNameTextField);
		
		// Weight Range Label
		JLabel lblWR = new JLabel("Weight Range:");
		lblWR.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblWR.setLocation(10, 105);
		lblWR.setSize(w, 20);
		add(lblWR);
		
		// Weight Range Low Text Field
		wrLowTextField = new JTextField();
		wrLowTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		wrLowTextField.setLocation(10, 125);
		wrLowTextField.setSize(57, 20);
		add(wrLowTextField);
		
		// Dash Label
		JLabel lblDash = new JLabel("-");
		lblDash.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblDash.setLocation(69, 125);
		lblDash.setSize(6, 20);
		add(lblDash);
		
		// Weight Range High Text Field
		wrHighTextField = new JTextField();
		wrHighTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		wrHighTextField.setLocation(77, 125);
		wrHighTextField.setSize(57, 20);
		add(wrHighTextField);
		
		// Hair Type Label
		JLabel lblHairType = new JLabel("Hair Type:");
		lblHairType.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHairType.setLocation(10, 145);
		lblHairType.setSize(w, 20);
		add(lblHairType);
		
		// Hair Type Combo Box
		HairType[] hairTypes = {HairType.SHORT, HairType.LONG};
		hairTypeComboBox = new JComboBox<HairType>(hairTypes);
		hairTypeComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		hairTypeComboBox.setLocation(10, 165);
		hairTypeComboBox.setSize(w, 20);
		add(hairTypeComboBox);
		
		// Hair Color Label
		JLabel lblHairColor = new JLabel("Hair Color:");
		lblHairColor.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHairColor.setLocation(10, 185);
		lblHairColor.setSize(w, 20);
		add(lblHairColor);
		
		// Hair Color Text Field
		hairColorTextField = new JTextField();
		hairColorTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		hairColorTextField.setLocation(10, 205);
		hairColorTextField.setSize(w, 20);
		add(hairColorTextField);
		
		// Sex Label
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblSex.setLocation(10, 225);
		lblSex.setSize(w, 20);
		add(lblSex);
		
		// Sex Combo Box
		Sex[] sexes = {Sex.MALE, Sex.FEMALE};
		sexComboBox = new JComboBox<Sex>(sexes);
		sexComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		sexComboBox.setLocation(10, 245);
		sexComboBox.setSize(w, 20);
		add(sexComboBox);
		
		// Flea Tested Label
		JLabel lblFleaTest = new JLabel("Flea Tested:");
		lblFleaTest.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblFleaTest.setLocation(145, 65);
		lblFleaTest.setSize(w, 20);
		add(lblFleaTest);
		
		// Flea Tested Combo Box
		Boolean[] bValues = {true, false};
		fleaComboBox = new JComboBox<Boolean>(bValues);
		fleaComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		fleaComboBox.setLocation(145, 85);
		fleaComboBox.setSize(w, 20);
		fleaComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				fleaTestTextField.setEnabled((Boolean)fleaComboBox.getSelectedItem());
				fleaTestTextField.setText("mm/dd/yyyy");
			}
		});
		add(fleaComboBox);
		
		// Flea Date Label
		JLabel lblFleaDate = new JLabel("First Treatment:");
		lblFleaDate.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblFleaDate.setLocation(145, 105);
		lblFleaDate.setSize(w, 20);
		add(lblFleaDate);
		
		// Flea Date Text Field
		fleaTestTextField = new JTextField("mm/dd/yyyy");
		fleaTestTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		fleaTestTextField.setLocation(145, 125);
		fleaTestTextField.setSize(w, 20);
		add(fleaTestTextField);
		
		// HeartWorm Label
		JLabel lblHartworm = new JLabel("Heartworm Results:");
		lblHartworm.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHartworm.setLocation(145, 145);
		lblHartworm.setSize(w, 20);
		add(lblHartworm);
		
		// Heart worm Combo Box
		String[] hwValues = {"Positive", "Negative"};
		heartwormComboBox = new JComboBox<String>(hwValues);
		heartwormComboBox.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		heartwormComboBox.setLocation(145, 165);
		heartwormComboBox.setSize(w, 20);
		heartwormComboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(heartwormComboBox.getSelectedItem().equals("Positive")){
					firstHeartwormTextField.setEnabled(true);
					firstHeartwormTextField.setText("mm/dd/yyyy");
					resetHeartwormTextField.setEnabled(true);
					resetHeartwormTextField.setText("mm/dd/yyyy");
				}else if(heartwormComboBox.getSelectedItem().equals("Negative")){
					firstHeartwormTextField.setEnabled(false);
					firstHeartwormTextField.setText("mm/dd/yyyy");
					resetHeartwormTextField.setEnabled(false);
					resetHeartwormTextField.setText("mm/dd/yyyy");
				}
			}
		});
		add(heartwormComboBox);
		
		// Treatment Begins Label
		JLabel lblHartwormBegins = new JLabel("Begin Treatement:");
		lblHartwormBegins.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblHartwormBegins.setLocation(145, 185);
		lblHartwormBegins.setSize(w, 20);
		add(lblHartwormBegins);
		
		// Treatment Begins Text Field
		firstHeartwormTextField = new JTextField("mm/dd/yyyy");
		firstHeartwormTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		firstHeartwormTextField.setLocation(145, 205);
		firstHeartwormTextField.setSize(w, 20);
		add(firstHeartwormTextField);
		
		// Treatment Reset Label
		JLabel lblReset = new JLabel("Reset Date:");
		lblReset.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
		lblReset.setLocation(145, 225);
		lblReset.setSize(w, 20);
		add(lblReset);
		
		// Treatment Reset Text Field
		resetHeartwormTextField = new JTextField("mm/dd/yyyy");
		resetHeartwormTextField.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
		resetHeartwormTextField.setLocation(145, 245);
		resetHeartwormTextField.setSize(w, 20);
		add(resetHeartwormTextField);
	}
	

}
