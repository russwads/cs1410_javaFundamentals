package vacation;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class RoomPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7051304803390049153L;

	public RoomPanel(JPanel room, JComboBox viewDDM, JComboBox bedtypeDDM, JComboBox bednumDDM, JCheckBox spa, JCheckBox internet, JCheckBox roomservice) {
		setBackground(SystemColor.activeCaption);
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setFont(new Font("Forte", Font.PLAIN, 60));
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setBounds(261, 93, 227, 86);
		room.add(lblRoom);
		
		JLabel roomSubtitle = new JLabel("Select Room Specifications and Amenities");
		roomSubtitle.setFont(new Font("Forte", Font.BOLD, 30));
		roomSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		roomSubtitle.setBounds(91, 164, 593, 44);
		room.add(roomSubtitle);
		
		viewDDM.setBounds(92, 284, 146, 35);
		room.add(viewDDM);
		
		bedtypeDDM.setBounds(300, 284, 146, 35);
		room.add(bedtypeDDM);
		
		bednumDDM.setBounds(509, 284, 146, 35);
		room.add(bednumDDM);
		
		JLabel labelsRoomSpec = new JLabel("View            Bed Type           Bed #");
		labelsRoomSpec.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelsRoomSpec.setBounds(123, 236, 532, 44);
		room.add(labelsRoomSpec);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.activeCaption);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane.setText("*All views are available in all bed types. The value hotels at Sheraton Universal and \r\n"
				+ "New York New York Las Vegas are the only hotels that support Double beds. Rooms \r\n"
				+ "with King-size beds and are not luxury are the only rooms that support one bed. \r\n"
				+ "Luxury rooms with Queen beds are the only rooms that support 3 beds.");
		textPane.setEditable(false);
		textPane.setBounds(134, 330, 471, 76);
		room.add(textPane);
		
		
		spa.setBackground(SystemColor.activeCaption);
		spa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spa.setBounds(130, 454, 64, 35);
		room.add(spa);
		
		
		internet.setBackground(SystemColor.activeCaption);
		internet.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		internet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		internet.setBounds(322, 454, 97, 35);
		room.add(internet);
		
		roomservice.setBackground(SystemColor.activeCaption);
		roomservice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		roomservice.setBounds(528, 454, 133, 35);
		room.add(roomservice);
		
		JLabel spaPic = new JLabel("");
		spaPic.setIcon(new ImageIcon(Application.class.getResource("/img/spa.jpg")));
		spaPic.setBounds(91, 496, 146, 147);
		room.add(spaPic);
		
		JLabel wwwPic = new JLabel("");
		wwwPic.setIcon(new ImageIcon(Application.class.getResource("/img/internet.jpg")));
		wwwPic.setBounds(300, 496, 146, 147);
		room.add(wwwPic);
		
		JLabel foodPic = new JLabel("");
		foodPic.setIcon(new ImageIcon(Application.class.getResource("/img/roomservice.jpg")));
		foodPic.setBounds(528, 496, 146, 147);
		room.add(foodPic);
	}
}
