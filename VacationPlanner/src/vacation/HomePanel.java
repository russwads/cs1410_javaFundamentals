package vacation;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1269597989831955395L;

	public HomePanel(JPanel home, JRadioButton vacationRadio, JRadioButton hotelRadio, JTextField nameText) {
		// Background and title
		setBackground(SystemColor.activeCaption);
		JLabel title = new JLabel("Bon Voyage");
		title.setBounds(182, 41, 409, 102);
		title.setFont(new Font("Forte", Font.BOLD, 75));
		home.add(title);
		
		// Subtitle
		JLabel subtitle = new JLabel("Vacation Planner");
		subtitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		subtitle.setBounds(255, 123, 259, 56);
		home.add(subtitle);
		
		// Name properties
		JLabel fullName = new JLabel("Full Name");
		fullName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		fullName.setHorizontalAlignment(SwingConstants.CENTER);
		fullName.setBounds(162, 226, 186, 63);
		home.add(fullName);
		nameText = new JTextField();
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameText.setBounds(401, 239, 256, 37);
		home.add(nameText);
		nameText.setColumns(10);
		
		// Setting up vacation package radio button
		vacationRadio.setSelectedIcon(new ImageIcon(Application.class.getResource("/img/vacation-s.jpg")));
		vacationRadio.setIcon(new ImageIcon(Application.class.getResource("/img/vacation.jpg")));
		vacationRadio.setHorizontalAlignment(SwingConstants.CENTER);
		vacationRadio.setBounds(112, 314, 256, 256);
		vacationRadio.setSelected(true);
		home.add(vacationRadio);
		
		// Setting up hotel radio button
		hotelRadio.setSelectedIcon(new ImageIcon(Application.class.getResource("/img/hotel-s.png")));
		hotelRadio.setIcon(new ImageIcon(Application.class.getResource("/img/hotel.png")));
		hotelRadio.setHorizontalAlignment(SwingConstants.CENTER);
		hotelRadio.setBounds(401, 315, 244, 255);
		home.add(hotelRadio);
		
		// Setting up labels for vacaPackage and Hotel
		JLabel vacaLabel = new JLabel("V a c a t i o n");
		vacaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vacaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vacaLabel.setBounds(162, 577, 166, 37);
		home.add(vacaLabel);
		
		JLabel hotelLabel = new JLabel("H o t e l   O n l y");
		hotelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hotelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hotelLabel.setBounds(410, 577, 233, 37);
		home.add(hotelLabel);
		
		// Setting up button group for radio buttons to help with functionality
		ButtonGroup group = new ButtonGroup();
	    group.add(vacationRadio);
	    group.add(hotelRadio);
	}
}
