package vacation;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReviewPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 153282298771376704L;

	/**
	 * Creates a review panel for those who had a hotel only.
	 * @param review review panel
	 * @param h1 hotel
	 * @param rm room
	 * @param roomLabel label for room
	 */
	public ReviewPanel(JPanel review, Room rm, JLabel roomLabel, JLabel hotelString, JLabel expeditionString) {
		setBackground(SystemColor.activeCaption);
		expeditionString.setFont(new Font("Forte", Font.BOLD, 25));
		expeditionString.setBounds(40, 216, 710, 89);
		review.add(expeditionString);
		
		hotelString.setFont(new Font("Forte", Font.BOLD, 35));
		hotelString.setBounds(77, 318, 585, 89);
		review.add(hotelString);
		
		roomLabel.setText(rm.toString());
		roomLabel.setFont(new Font("Forte", Font.BOLD, 25));
		roomLabel.setBounds(77, 425, 627, 89);
		review.add(roomLabel);
	}
}
