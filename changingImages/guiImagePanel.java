package changingImages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guiImagePanel extends JFrame {

	private JPanel contentPane;
	private boolean pic1 = false;
	private boolean pic2 = false;
	private boolean pic3 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiImagePanel frame = new guiImagePanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiImagePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImagePanel panelImg = new ImagePanel();
		contentPane.add(panelImg, BorderLayout.CENTER);
		
		controlPanel(panelImg);
	}

	/**
	 * Creates the control panel and its functionality.
	 * @param panelImg image panel used for changing pictures
	 */
	private void controlPanel(ImagePanel panelImg) {
		JPanel controlPanel = new JPanel();
		controlPanel.setPreferredSize(new Dimension(125, 200));
		controlPanel.setLayout(null);
		
		JLabel lblDroneFlyer = new JLabel("DroneFlyer");
		lblDroneFlyer.setFont(new Font("Magneto", Font.PLAIN, 15));
		lblDroneFlyer.setBounds(10, 23, 105, 23);
		controlPanel.add(lblDroneFlyer);
		
		JCheckBox chckbxDrone = new JCheckBox("Drone");
		chckbxDrone.setBounds(6, 70, 97, 23);
		controlPanel.add(chckbxDrone);
		
		JCheckBox chckbxOutfit = new JCheckBox("Outfit");
		chckbxOutfit.setBounds(6, 110, 97, 23);
		controlPanel.add(chckbxOutfit);
		
		JCheckBox chckbxScene = new JCheckBox("Scenery");
		chckbxScene.setBounds(6, 150, 97, 23);
		controlPanel.add(chckbxScene);
		
		submitButton(panelImg, controlPanel, chckbxDrone, chckbxOutfit, chckbxScene);
		contentPane.add(controlPanel, BorderLayout.WEST);
	}
	
	/**
	 * Provides functionality for the "Submit" button
	 * @param panelImg image panel used for changing pictures
	 * @param controlPanel the entire control panel
	 * @param chckbxDrone checkbox for drones
	 * @param chckbxOutfit checkbox for people and outfits
	 * @param chckbxScene checkbox for scenery
	 */
	private void submitButton(ImagePanel panelImg, JPanel controlPanel, JCheckBox chckbxDrone,
			JCheckBox chckbxOutfit, JCheckBox chckbxScene) {
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxDrone.isSelected() && chckbxOutfit.isSelected() 
						&& chckbxScene.isSelected()) {
					panelImg.changeDrones();
					panelImg.changePeople();
					panelImg.changeScenery();
				}
				else if (chckbxDrone.isSelected() && chckbxOutfit.isSelected()) {
					panelImg.changeDrones();
					panelImg.changePeople();
				}
				else if (chckbxDrone.isSelected() && chckbxScene.isSelected()) {
					panelImg.changeDrones();
					panelImg.changeScenery();
				}
				else if (chckbxOutfit.isSelected() && chckbxScene.isSelected()) {
					panelImg.changePeople();
					panelImg.changeScenery();
				}
				else if (chckbxOutfit.isSelected()) {
					panelImg.changePeople();
				}
				else if (chckbxScene.isSelected()) {
					panelImg.changeScenery();
				}
				else if (chckbxDrone.isSelected()) {
					panelImg.changeDrones();
				}
				else {
					panelImg.changeBkgrnd();
				}
			}
		});
		btnSubmit.setBounds(6, 200, 89, 23);
		controlPanel.add(btnSubmit);
	}
}
