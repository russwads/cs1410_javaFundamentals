package vacation;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HtlImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1352367226032715833L;
	ArrayList<ImageIcon> htl = new ArrayList<ImageIcon>();
	private int index1 = 0;

	/**
	 * Create the panel.
	 */
	public HtlImagePanel() {

	}
	
	/**
	 * Changes the image for the hotel.
	 */
	public void changeBkgrnd(int index) {
		index1 = index;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		initializeArrays();
		htl.get(index1).paintIcon(this, g, 0, 0);
	}
	
	/**
	 * Initializes arrays with all possible choices.
	 */
	private void initializeArrays() {
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/disneyland-hotel.jpg")));
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/sheraton-universal-hotel.jpg")));
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/disney-polynesian-resort.jpg")));
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/nyny-las-vegas.jpg")));
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/plaza-hotel-new-york.jpg")));
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/four-seasons-resort.jpg")));
		htl.add(new ImageIcon(ExpImagePanel.class.getResource("/img/grand-america-hotel.jpg")));
	}
}
