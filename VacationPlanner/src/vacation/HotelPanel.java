package vacation;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HotelPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2020170213948096216L;
	ArrayList<Hotel> htl = new ArrayList<Hotel>();
	JComboBox hotels;
	
	public HotelPanel(ArrayList<Hotel> htlIn, JPanel hotel, JComboBox comboBox, JComboBox comboBox_1) {
		setBackground(SystemColor.activeCaption);
		htl = htlIn;
		
		JLabel lblHotel = new JLabel("Hotel");
		lblHotel.setFont(new Font("Forte", Font.BOLD, 75));
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setBounds(248, 66, 263, 119);
		hotel.add(lblHotel);
		
		hotels = comboBox;
		hotels = choicesForHotel(hotel);
		
		JLabel lblNewLabel = new JLabel("Hotel and Amenities Options");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Forte", Font.BOLD, 30));
		lblNewLabel.setBounds(188, 164, 396, 30);
		hotel.add(lblNewLabel);
		
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox_1.setBounds(277, 638, 64, 48);
		hotel.add(comboBox_1);
		
		JLabel daysLbl = new JLabel("Days");
		daysLbl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		daysLbl.setHorizontalAlignment(SwingConstants.CENTER);
		daysLbl.setBounds(175, 638, 76, 48);
		hotel.add(daysLbl);
	}
	
	/**
	 * Creates the overlay for the hotel choices. Provides functionality for the drop-down menu to the adjacent picture.
	 * @param hotel hotel panel
	 * @return
	 */
	private JComboBox choicesForHotel(JPanel hotel) {
		HtlImagePanel expimgpnl = new HtlImagePanel();
		expimgpnl.setBounds(228, 291, 300, 300);
		hotel.add(expimgpnl);
		
		ArrayList<String> htlnames = new ArrayList<String>();
		for (int i = 0; i < htl.size(); i++) {
			htlnames.add(htl.get(i).getName());
		}
		
		hotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hotels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) hotels.getSelectedItem();
				int index1 = htlnames.indexOf(selected);
				expimgpnl.changeBkgrnd(index1);
			}
		});
		hotels.setBounds(248, 232, 263, 48);
		hotel.add(hotels);
		return hotels;
	}
}
