package com.grantbroadwater.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.grantbroadwater.AnimalRecordsSystem;
import com.grantbroadwater.util.Log;

public class ARSFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=800, HEIGHT=600, LOGIN_WIDTH=758, LOGIN_HEIGHT=379;
	private JPanel mainPanel;
	private ARSMenuBar menuBar = new ARSMenuBar();

	public ARSFrame() throws HeadlessException {
		super("Animal Records System");
		
		// Frame
		setMinimumSize(new Dimension(WIDTH+16, HEIGHT+59));
		setMaximumSize(new Dimension(WIDTH+16, HEIGHT+59));
		setSize(new Dimension(WIDTH+16, HEIGHT+59));
		setLocation(new Point(25, 25));
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				ARSFrame.terminate();
			}
		});
		
		// Menu Bar
		menuBar = new ARSMenuBar();
		setMenuBar(menuBar);
		
		// Panel
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setLocation(new Point(0,0));
		mainPanel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		mainPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		mainPanel.setSize(new Dimension(WIDTH, HEIGHT));
		mainPanel.setVisible(true);
		getContentPane().add(mainPanel);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(final JPanel panel){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				getContentPane().remove(mainPanel);
				mainPanel = panel;
				mainPanel.setLocation(new Point(0, 0));
				mainPanel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
				mainPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
				mainPanel.setSize(new Dimension(WIDTH, HEIGHT));
				mainPanel.setVisible(true);
				getContentPane().add(mainPanel);
				mainPanel.revalidate();
				repaint();
			}
		});
	}
	
	public void removePanel(){ 
		setMainPanel(new JPanel());
	}
	
	public void updateGraphics(){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				mainPanel.revalidate();
				repaint();
			}
		});
	}
	
	@Override
	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(ARSMenuBar menuBar) {
		this.menuBar = menuBar;
		super.setMenuBar(this.menuBar);
	}
	
	public void showMenuBar(){
		menuBar = new ARSMenuBar();
		setMenuBar(menuBar);
	}
	
	public void removeMenuBar(){
		setMenuBar(null);
	}

	protected static void terminate(){
		if(AnimalRecordsSystem.getFrame().getMainPanel() instanceof SignInPanel){
			JOptionPane.showMessageDialog(null, "You must sign in to terminate the application");
			return;
		}
		int confirm = JOptionPane.showOptionDialog(null,
                "Are You Sure to Close this Application?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
        	AnimalRecordsSystem.getStaff().saveStaff();
        	AnimalRecordsSystem.getAnimals().saveAnimals();
        	AnimalRecordsSystem.getFrame().dispose();
        	new Log("Now terminating application");
            System.exit(1);
        }
	}


}
