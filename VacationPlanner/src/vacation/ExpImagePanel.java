package vacation;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ExpImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 641061760460712568L;
	ArrayList<ImageIcon> expedition = new ArrayList<ImageIcon>();
	private int index1 = 0;

	/**
	 * Create the panel.
	 */
	public ExpImagePanel() {

	}
	
	/**
	 * Changes the image for the expedition.
	 */
	public void changeBkgrnd(int index) {
		index1 = index;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		initializeArrays();
		expedition.get(index1).paintIcon(this, g, 0, 0);
	}
	
	/**
	 * Initializes arrays with all possible expedition choices.
	 */
	private void initializeArrays() {
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/disneyland-resort.jpg")));
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/universal-hollywood.jpg")));
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/walt-disney-world-resort.jpg")));
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/las-vegas.jpg")));
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/nyc.jpg")));
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/hawaii.jpg")));
		expedition.add(new ImageIcon(ExpImagePanel.class.getResource("/img/utah.jpg")));
	}
}
