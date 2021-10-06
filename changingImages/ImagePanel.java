package changingImages;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	ArrayList<ImageIcon> bkgrnd = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> people = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> drones = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> scenery = new ArrayList<ImageIcon>();
	private int index1 = 0;
	private int index2 = 0;
	private int index3 = 0;
	private int index4 = 0;
	
	/**
	 * Create the panel.
	 */
	public ImagePanel() {

	}
	
	/**
	 * Changes the background of the drone-flying scene.
	 */
	public void changeBkgrnd() {
		index1 = ++index1 % bkgrnd.size();
		repaint();
	}
	
	/**
	 * Changes the people that control the drone.
	 */
	public void changePeople() {
		index2 = ++index2 % people.size();
		repaint();
	}
	
	/**
	 * Changes the drone in the air.
	 */
	public void changeDrones() {
		index3 = ++index3 % drones.size();
		repaint();
	}
	
	/**
	 * Changes the scenery item.
	 */
	public void changeScenery() {
		index4 = ++index4 % scenery.size();
		repaint();
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		initializeArrays();
		bkgrnd.get(index1).paintIcon(this, g, 0, 0);
		
		if ((index2 + 1) % 4 == 0) {
			people.get(index2).paintIcon(this, g, 50, 120); //Brings dog lower
		}
		else {
			people.get(index2).paintIcon(this, g, 50, 75);
		}
		
		drones.get(index3).paintIcon(this, g, 200, 10);
		
		if ((index4 + 2) % 4 == 0) {
			scenery.get(index4).paintIcon(this, g, 250, 30);//Brings castle higher
		}
		else {
			scenery.get(index4).paintIcon(this, g, 250, 60);
		}
	}
	
	/**
	 * Initializes arrays with four different pictures each.
	 */
	private void initializeArrays() {
		bkgrnd.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/background_spring.png")));
		bkgrnd.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/background_summer.png")));
		bkgrnd.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/background_fall.png")));
		bkgrnd.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/background_winter.png")));
		
		people.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/dude_with_controller.png")));
		people.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/dude_with_controller_clothed.png")));
		people.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/girl_with_controller.png")));
		people.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/puppy_with_controller.png")));
		
		drones.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/drone1.png")));
		drones.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/drone2.png")));
		drones.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/drone3.png")));
		drones.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/drone4.png")));
		
		scenery.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/scenery_tree.png")));
		scenery.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/scenery_house.png")));
		scenery.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/scenery_castle.png")));
		scenery.add(new ImageIcon(ImagePanel.class.getResource("/changingImages/img/scenery_monument.png")));
	}
}
