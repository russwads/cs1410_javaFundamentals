package vacation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.ComponentOrientation;
import javax.swing.JFormattedTextField;

public class Application extends JFrame implements Flight{

	private JPanel contentPane;

	private static ArrayList<Hotel> htl = new ArrayList<Hotel> ();
	private static ArrayList<String> htlNames = new ArrayList<String>();
	private static ArrayList<String> expeditionNames = new ArrayList<String> ();
	private Expedition exp = new Expedition(); // Blank expedition
	private Hotel h = new Hotel(); // Blank hotel
	private Room rm = new Room(); // Blank room
	private int days = 0; // Number of days in expedition

	private int htlIndex; // Use to grab hotel from htl list

	private boolean choice; // First screen boolean
	private boolean hasExp = false; // Has an expedition
	private boolean hasFlight = false; // Has a flight
	private boolean[] amenities = {false,false,false}; // spa, internet, roomservice
	
	private double flgtPrice; // Flight price
	private ArrayList<String> flgt = new ArrayList<String> ();
	
	private JTextField nameText; // Name on first screen
	private JTextField textField; // Used to get number of people
	private int peeps = 1; // Number of people
	
	private Double finPr = 0.0; // final price

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Application.initializeHotels();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
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
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Screen 1--First Choice
		JRadioButton vacationRadio = new JRadioButton("");
		JRadioButton hotelRadio = new JRadioButton("");
		
		//Screen 2--Expedition
		JComboBox vacationChoices = new JComboBox(expeditionNames.toArray());
		vacationChoices.setLocation(100, 239);
		JComboBox boxDays = new JComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7"});
		JCheckBox flgtCheck = new JCheckBox("");
		
		//Screen 3--Hotel
		JComboBox htlName = new JComboBox(htlNames.toArray());
		JComboBox htlNum = new JComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7"});
		
		//Screen 4--Room
		JComboBox viewDDM = new JComboBox(View.values());
		JComboBox bedtypeDDM = new JComboBox(TypeBed.values());
		JComboBox bednumDDM = new JComboBox(new String[] {"1", "2", "3"});
		JCheckBox spa = new JCheckBox("Spa");
		JCheckBox internet = new JCheckBox("Internet");
		JCheckBox roomservice = new JCheckBox("Room Service");
		
		//Review Panel
		JPanel review = new JPanel();
		JLabel roomLabel = new JLabel();
		JLabel expeditionString = new JLabel();
		JLabel hotelString = new JLabel();
		
		//ThankU Panel
		ExpImagePanel panel = new ExpImagePanel();
		HtlImagePanel panel_1 = new HtlImagePanel();
				
		JPanel home = homePanel(vacationRadio, hotelRadio);
		JPanel thankYou = thankuPanel(panel, panel_1);
		review = reviewPanel(roomLabel, hotelString, expeditionString);
		JPanel room = roomPanel(viewDDM, bedtypeDDM, bednumDDM, spa, internet, roomservice);
		JPanel hotel = hotelPanel(room, htlName, htlNum);
		JPanel vacation = vacationPanel(hotel, vacationChoices, boxDays, flgtCheck);
		
		continueFirstScreen(home, vacation, hotel, hotelRadio, vacationRadio);
		continueVacaSecondPage(vacation, room, vacationChoices, boxDays, flgtCheck, review);
		continueRoomFromHotel(room, htlName, htlNum, hotel);
		continueReview(room, viewDDM, bedtypeDDM, bednumDDM, spa, internet, roomservice, review, roomLabel, hotelString, expeditionString);
		finishButton(review, thankYou, panel, panel_1);
	}
	
	/**
	 * Creates list of rooms and initializes rooms, names, and prices to hotels.
	 */
	private static void initializeHotels() {
		ArrayList<Room> rms1 = new ArrayList<Room> ();
		ArrayList<Room> rms2 = new ArrayList<Room> ();
		ArrayList<Room> rms3 = new ArrayList<Room> ();
		readRooms(rms1, "Hotel1.csv");
		readRooms(rms2, "Hotel2.csv");
		readRooms(rms3, "Hotel3.csv");
		
		htlNames.add("Disneyland Hotel");
		htlNames.add("Sheraton Universal Hotel");
		htlNames.add("Disney Polynesian Resort");
		htlNames.add("New York New York Hotel");
		htlNames.add("The Plaza Hotel");
		htlNames.add("Four Seasons Hotel");
		htlNames.add("The Grand America Hotel");
		
		htl.add(new Hotel(rms1, htlNames.get(0), 490.00));
		htl.add(new Hotel(rms2, htlNames.get(1), 268.33));
		htl.add(new Hotel(rms3, htlNames.get(2), 645.75));
		htl.add(new Hotel(rms2, htlNames.get(3), 130.00));
		htl.add(new Hotel(rms3, htlNames.get(4), 1214.79));
		htl.add(new Hotel(rms3, htlNames.get(5), 1445.21));
		htl.add(new Hotel(rms1, htlNames.get(6), 261.63));
		
		expeditionNames.add("Disneyland Resort (CA)");
		expeditionNames.add("Universal Studios Hollywood (CA)");
		expeditionNames.add("Walt Disney World Resort (FL)");
		expeditionNames.add("Go Las Vegas - All-Inclusive (NV)");
		expeditionNames.add("New York City Sightseeing Pass (NY)");
		expeditionNames.add("Lanai Beach Picnic Sail & Germaine's Luau (HI)");
		expeditionNames.add("Temple Square Tour & Lagoon (UT)");
	}
	/**
	 * Reads a list of rooms and creates room objects to add to hotels.
	 * @param rms list of rooms
	 * @param filename name of file reading from
	 */
	private static void readRooms(ArrayList<Room> rms, String filename) {
		try (Scanner input = new Scanner(Application.class.getResourceAsStream(filename))) {
			while (input.hasNextLine()) {
				Room r = Room.getRoom(input.nextLine());
				if (r == null) {
				}
				else{
					rms.add(r);
				}
			}
		}
	}
	
	/**
	 * Creates visibility and printing of final package.
	 * @return
	 */
	private JPanel thankuPanel(ExpImagePanel panel, HtlImagePanel panel_1) {
		JPanel thankYou = new JPanel();
		thankYou.setBackground(SystemColor.activeCaption);
		contentPane.add(thankYou, "Thank You!");
		thankYou.setVisible(false);
		thankYou.setLayout(null);
		
		JLabel titleAdventure = new JLabel("Your Adventure Awaits!");
		titleAdventure.setFont(new Font("Forte", Font.BOLD, 50));
		titleAdventure.setBounds(117, 110, 569, 101);
		thankYou.add(titleAdventure);
		
		panel.setBounds(66, 234, 300, 300);
		thankYou.add(panel);
		
		panel_1.setBounds(418, 234, 300, 300);
		thankYou.add(panel_1);
		
		JTextPane importantText = new JTextPane();
		importantText.setText("**Your decisions and price were written in a text file named \"Trip.txt\"\r\nTickets will be sent to you via email.");
		importantText.setEditable(false);
		importantText.setBackground(SystemColor.activeCaption);
		importantText.setBounds(157, 565, 465, 47);
		thankYou.add(importantText);
		return thankYou;
	}
	
	/**
	 * Creates visibility for the review page.
	 * @return
	 */
	private JPanel reviewPanel(JLabel roomLabel, JLabel hotelString, JLabel expeditionString) {
		JPanel review = new JPanel();		
		review.setBackground(SystemColor.activeCaption);
		contentPane.add(review, "Review Tab");
		review.setVisible(false);
		review.setLayout(null);
		
		JLabel reviewTitle = new JLabel("Review");
		reviewTitle.setFont(new Font("Forte", Font.BOLD, 60));
		reviewTitle.setBounds(281, 63, 205, 95);
		review.add(reviewTitle);
		
		JLabel reviewSubtitle = new JLabel("Review your choices and ensure they are correct");
		reviewSubtitle.setFont(new Font("Forte", Font.PLAIN, 25));
		reviewSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		reviewSubtitle.setBounds(120, 144, 524, 40);
		review.add(reviewSubtitle);
	
		ReviewPanel horp = new ReviewPanel(review, rm, roomLabel, hotelString, expeditionString);
		horp.setBounds(0,215,774,300);
		review.add(horp);
		horp.revalidate();
		horp.repaint();
		horp.setLayout(null);
		
		JLabel lblPrice = new JLabel("PRICE:       $");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblPrice.setBounds(157, 590, 253, 48);
		review.add(lblPrice);
		
		review.revalidate();
		review.repaint();
		
		return review;
	}

	/**
	 * Creates the finishing button to get from the review panel to the thank you panel.
	 * @param review panel for review
	 * @param thankYou panel for thank you
	 * @param panel expedition image panel
	 * @param panel_1 hotel image panel
	 */
	private void finishButton(JPanel review, JPanel thankYou, ExpImagePanel panel, HtlImagePanel panel_1) {
		JButton finish = new JButton("Purchase");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.changeBkgrnd(htlIndex);
				panel_1.changeBkgrnd(htlIndex);
				double expPr = exp.getPrice();
				double htlPr = h.getPrice(rm);
				
				printTrip(expPr, htlPr);
				review.setVisible(false);
				thankYou.setVisible(true);
				
			}

			/**
			 * Prints a text file with all the choices made throughout the running program.
			 * @param expPr expedition price
			 * @param htlPr hotel price
			 * @param rmPr room price
			 */
			private void printTrip(double expPr, double htlPr) {
				try (PrintWriter pw = new PrintWriter("Trip.txt")) {
					pw.println("Bon Voyage Vacation Planner");
					pw.println("(C)MMXX by Wadsworth Codes LLC");
					pw.println();
					pw.println("$" + expPr + " - " + exp.toString() + " (price per person)");
					pw.println("$" + htlPr + " - " + h.toString() + " (price per night includes room & amenities, if selected)");
					pw.println();
					pw.println(peeps + " - Number of People Attending");
					pw.println(days + " - Number of Days Attending");
					pw.println("Spa Amenity ($200 value): " + amenities[0]);
					pw.println("Internet Amenity ($25 value): " + amenities[1]);
					pw.println("Room Service Amenity ($30 value): " + amenities[2]);
					pw.println();
					if (hasFlight) {
						pw.println("Departing Flight: " + flgt.get(0));
						pw.println("Returning Flight: " + flgt.get(1));
						pw.println("$" + flgtPrice + " - Flight Price");
						pw.println();
					}
					pw.println("$" + finPr + " - Total Price");
				} catch (FileNotFoundException e1) {
					System.err.println("File not found.");
					e1.printStackTrace();
				}
			}
		});
		finish.setFont(new Font("Tahoma", Font.PLAIN, 30));
		finish.setBounds(281, 663, 163, 48);
		review.add(finish);
	}

	/**
	 * Creates visibility and choices for the specific room page.
	 * @param roomservice 
	 * @param internet 
	 * @param spa 
	 * @param bednumDDM 
	 * @param bedtypeDDM 
	 * @param viewDDM 
	 * @return
	 */
	private JPanel roomPanel(JComboBox viewDDM, JComboBox bedtypeDDM, JComboBox bednumDDM, JCheckBox spa, JCheckBox internet, JCheckBox roomservice) {
		JPanel room = new JPanel();
		room.setBackground(SystemColor.activeCaption);
		contentPane.add(room, "Room Tab");
		room.setVisible(false);
		room.setLayout(null);
		
		RoomPanel rp = new RoomPanel(room, viewDDM, bedtypeDDM, bednumDDM, spa, internet, roomservice);
		rp.setBounds(0,0,800,676);
		room.add(rp);
		
		return room;
	}
	/**
	 * Continues from both application tracks from room to final review.
	 * @param room room panel
	 * @param viewDDM drop-down menu for hotel room view
	 * @param bedtypeDDM drop-down menu for hotel bed type
	 * @param bednumDDM drop-down menu for the number of hotel beds in room
	 * @param spa checkbox for spa
	 * @param internet checkbox for internet
	 * @param roomservice checkbox for room service
	 * @param review review panel
	 * @param roomLabel 
	 */
	private void continueReview(JPanel room, JComboBox viewDDM, JComboBox bedtypeDDM, JComboBox bednumDDM,
			JCheckBox spa, JCheckBox internet, JCheckBox roomservice, JPanel review, JLabel roomLabel, JLabel hotelString,
			JLabel expeditionString) {
		// Creates button
		JButton roomContinue = new JButton("Continue");
		roomContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Enables amenities to be executed
				if (spa.isSelected()) 
					amenities[0] = true;
				if (internet.isSelected()) 
					amenities[1] = true;
				if (roomservice.isSelected())
					amenities[2] = true;
				
				Hotel h1 = htl.get(htlIndex);
				h = h1;
				if (amenities[0] == true)
					h1.treatmentSpa();
				if (amenities[1] == true)
					h1.treatmentInternet();
				if (amenities[2] == true)
					h1.treatmentRoomService();
				
				// Creates new room
				TypeBed tb = (TypeBed) bedtypeDDM.getSelectedItem();
				View vw = (View) viewDDM.getSelectedItem();
				int bdnum = Integer.parseInt((String) bednumDDM.getSelectedItem());
				rm = new Room(tb, vw, bdnum, true);
				// Grabs chosen hotel rooms list, and checks to see if the room is in the hotel
				ArrayList<Room> check = h1.getRoomsList();
				// False returns a dialog box to try a different hotel room
				boolean continu = check.contains(rm);
				if (!continu) {
					JOptionPane.showMessageDialog(null, "Room is not found in the hotel or is not available.");
				}
				else {
					roomLabel.setText(rm.toString());
					if (hasExp) 
						expeditionString.setText(exp.toString());
					hotelString.setText(h1.toString());
					finPr = (exp.getPrice() * peeps) + (h1.getPrice(rm) * days) + (flgtPrice * peeps); // Expedition price + hotel price (room price and amenities included)
					finPr = (double) Math.round(finPr * 100) / 100;
					
					JLabel priceFinal = new JLabel(finPr.toString());
					priceFinal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
					priceFinal.setBounds(420, 590, 163, 48);
					review.add(priceFinal);
					
					room.setVisible(false);
					review.revalidate();
					review.repaint();
					review.setVisible(true);
				}
			}
		});
		roomContinue.setFont(new Font("Tahoma", Font.PLAIN, 25));
		roomContinue.setBounds(300, 677, 146, 44);
		room.add(roomContinue);
	}
	
	/**
	 * Creates visibility and choices for the hotel page.
	 * @return
	 */
	private JPanel hotelPanel(JPanel room, JComboBox htlName, JComboBox htlNum) {
		//Creating hotel panel
		JPanel hotel = new JPanel();
		hotel.setBackground(SystemColor.activeCaption);
		contentPane.add(hotel, "Hotel Tab");
		hotel.setVisible(false);
		hotel.setLayout(null);
		
		// Styling external panel
		HotelPanel hp = new HotelPanel(htl, hotel, htlName, htlNum);
		hp.setBounds(0,0,800,637);
		hotel.add(hp);
		
		htlNum.setFont(new Font("Tahoma", Font.PLAIN, 25));
		htlNum.setBounds(260, 648, 63, 38);
		hotel.add(htlNum);
		
		return hotel;
	}
	/**
	 * Transitions between hotel panel and room panel. 
	 * @param room room panel
	 * @param htlName name of hotel drop-down container
	 * @param htlNum number of days drop-down container
	 * @param hotel hotel panel
	 */
	private void continueRoomFromHotel(JPanel room, JComboBox htlName, JComboBox htlNum, JPanel hotel) {
		JButton htlCont = new JButton("Continue");
		htlCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				days = Integer.parseInt((String) htlNum.getSelectedItem()); // Sets days since user could not set days in expedition
				String hotelName = (String) htlName.getSelectedItem(); // Finding hotel name and setting index so hotel could be retrieved
				htlIndex = htlNames.indexOf(hotelName);
				room.setVisible(true);
				hotel.setVisible(false);
			}
		});
		htlCont.setFont(new Font("Tahoma", Font.PLAIN, 25));
		htlCont.setBounds(474, 638, 153, 48);
		hotel.add(htlCont);
	}
	
	/**
	 * Creates visibility and choices for the vacation package page.
	 * @return
	 */
	private JPanel vacationPanel(JPanel hotel, JComboBox vacationChoices, JComboBox boxDays, JCheckBox flgtCheck) {
		// Create vacation panel
		JPanel vacation = new JPanel();
		vacation.setPreferredSize(new Dimension(20, 20));
		vacation.setBackground(SystemColor.activeCaption);
		vacation.setVisible(false);
		contentPane.add(vacation, "Vacation Tab");
		vacation.setLayout(null);

		vacationChoices = choicesForVacation(vacation, vacationChoices);
		
		// Styling external panel
		VacationPanel vp = new VacationPanel(vacation, expeditionNames, vacationChoices, boxDays, flgtCheck); // vacation panel, expedition names, comboboxes, and checkbox
		vp.setBounds(0, 0, 800, 699);
		vacation.add(vp);
		vp.setLayout(null);
		
		// People information: creating label and box to type numbers in
		JLabel peopleText = new JLabel("Number of People");
		peopleText.setFont(new Font("Forte", Font.PLAIN, 25));
		peopleText.setBounds(499, 236, 218, 40);
		vp.add(peopleText);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(586, 275, 96, 30);
		vp.add(textField);
		textField.setColumns(10);
		return vacation;
	}
	/**
	 * Creates the overlay for the vacation choices. Provides functionality for the drop-down menu to the adjacent picture.
	 * @param vacation vacation panel
	 * @return
	 */
	private JComboBox choicesForVacation(JPanel vacation, JComboBox vacationChoices) {
		ExpImagePanel expimgpnl = new ExpImagePanel();
		expimgpnl.setBounds(230, 289, 300, 300);
		vacation.add(expimgpnl);
		
		vacationChoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) vacationChoices.getSelectedItem(); // Finding expedition through list
				int index1 = expeditionNames.indexOf(selected);
				expimgpnl.changeBkgrnd(index1); // Changing background based on expedition through list
			}
		});
		vacationChoices.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vacationChoices.setBounds(110, 239, 325, 39);
		vacation.add(vacationChoices);
		return vacationChoices;
	}
	/**
	 * Continuing the application past the next page if the user chose vacation.
	 * @param vacation vacation panel
	 * @param flight flight panel
	 * @param hotel hotel panel
	 * @param vacationChoices array of choices to be selected with a dropdown menu
	 * @param boxDays array of numbers specifying the number of days
	 * @param flgtCheck checking to see if there is a flight to the specified destination
	 */
	private void continueVacaSecondPage(JPanel vacation, JPanel room, JComboBox vacationChoices, JComboBox boxDays, JCheckBox flgtCheck, JPanel review) {
		JButton btnNewButton = new JButton("C o n t i n u e");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// First, create ALL the parameters for the expedition
				String peoplenum = textField.getText();
				boolean continu = false;
				try {
					peeps = Integer.parseInt(peoplenum); // Sets number of people
					if (peeps < 1) {
						throw new IllegalArgumentException(); // Throws if less than 1
					}
					else {
						continu = true;
					}
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Illegal number entered. Please enter a number 1 or higher."); // Used for above throw and strings
					continu = false;
				}
				if (continu == true) {
					// Creating the expedition  
					days = Integer.parseInt((String)boxDays.getSelectedItem());
					String selected = (String) vacationChoices.getSelectedItem();
					exp = new Expedition(findPrice(selected,days), days, selected);
				
					// Creating the flight information
					// Codes: SLC LGB LAX MCO LAS JFK HNL
					selected = selected.substring(selected.length() - 3, selected.length() - 1);
					flgt = trip(selected, exp, flgtCheck, review);
					
					room.setVisible(true);
					vacation.setVisible(false);
				}
			}
			/**
			 * Returns an accurate calculation of flight prices. The calculation is based on an airfare
			 * analysis where $50 is base flight prices and every mile traveled is $0.11.
			 * @param miles number of miles traveled round-trip
			 * @return
			 */
			private double flgtCalc(int miles) {
				return 50 + (.11 * miles);
			}
			/**
			 * Defines the price for the expedition.
			 * @param selected name of expedition
			 * @param days number of days
			 * @return
			 */
			private double findPrice(String selected, int days) {
				double buffer = 0.0;
				if (selected == "Disneyland Resort (CA)")  {
					if (days < 3)
						buffer = 229.00 * days;
					else
						buffer = 141.67 * days;
				}
				else if (selected == "Universal Studios Hollywood (CA)")
					buffer = 265.00 + (days * 84);
				else if (selected == "Walt Disney World Resort (FL)") {
					if (days < 4)
						buffer = 178.23 * days;
					else
						buffer = 107.12 * days;
				}
				else if (selected == "Go Las Vegas - All-Inclusive (NV)")
					buffer = 135.00 * days;
				else if (selected == "New York City Sightseeing Pass (NY)")
					buffer = 129.00 * days;
				else if (selected == "Lanai Beach Picnic Sail & Germaine's Luau (HI)")
					buffer = 375.91 * days;
				else if (selected == "Temple Square Tour & Lagoon (UT)")
					buffer = 66.67 + (days * 69.95);
				else
					System.err.println("Error in array and string parsing. Please try again.");
				buffer = Math.round(buffer * 100)/100;
				return buffer;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(298, 700, 151, 40);
		vacation.add(btnNewButton);
	}
	
	/**
	 * Creates functionality for the first screen: first, evaluating the radio button; second, changing the screen
	 * according to the decision of the radio button. 
	 * @param home panel screen
	 * @param vacation vacation panel
	 * @param hotel hotel panel
	 * @param hotelRadio radio button for hotel
	 * @param vacationRadio radio button for vacation
	 */
	private void continueFirstScreen(JPanel home, JPanel vacation, JPanel hotel, JRadioButton hotelRadio, JRadioButton vacationRadio) {
		// Create button
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Choice boolean used for passing through first screen. Choice enables user to go to vacation package if true.
				if (hotelRadio.isSelected()) { choice = false; }
				else if (vacationRadio.isSelected()) { choice = true; }
				if (choice == true) {
					hasExp = true; // The final product HAS an expedition.
					vacation.setVisible(true);
					home.setVisible(false);
				}
				else {
					hotel.setVisible(true);
					home.setVisible(false);
				}
			}
		});
		continueBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		continueBtn.setBounds(307, 647, 148, 56);
		home.add(continueBtn);
	}
	/**
	 * Creates the first panel for the vacation planner.
	 * @return
	 */
	private JPanel homePanel(JRadioButton vacationRadio, JRadioButton hotelRadio) {
		JPanel home = new JPanel();
		
		HomePanel hm = new HomePanel(home, vacationRadio, hotelRadio, nameText); // home panel, radio buttons, text for name
		hm.setBounds(0, 0, 800, 646);
		home.add(hm);
		
		home.setBackground(SystemColor.activeCaption);
		contentPane.add(home, "Home Tab");
		home.setLayout(null);
		return home;
	}

	@Override
	public ArrayList<String> trip(String selected, Expedition exp, JCheckBox flgtCheck, JPanel review) {
		ArrayList<String> fnl = new ArrayList<String>();
		String depart = "No flight"; // Departing flight
		String retn = "No flight"; // Return flight
		
		if (selected.equals("CA") && exp.getPlace() == "Disneyland Resort (CA)") {
			htlIndex = 0;
			if (flgtCheck.isSelected()) {
				depart = "SLC LGB 0930 Delta 7264";
				retn = "LGB SLC 1830 Delta 5710";
				flgtPrice = 100 + (.11 * 1176);
			}
		}
		if (selected.equals("CA") && exp.getPlace() != "Disneyland Resort (CA)") {
			htlIndex = 1;
			if (flgtCheck.isSelected()) {
				depart = "SLC LAX 0930 Delta 6410";
				retn = "LAX SLC 1830 Delta 3208";
				flgtPrice = 100 + (.11 * 1178);
			}
		}
		if (selected.equals("FL")) {
			htlIndex = 2;
			if (flgtCheck.isSelected()) {
				depart = "SLC MCO 0930 Delta 4999";
				retn = "MCO SLC 1830 Delta 0116";
				flgtPrice = 100 + (.11 * 3860);
			}
		}
		if (selected.equals("NV")) {
			htlIndex = 3;
			if (flgtCheck.isSelected()) {
				depart = "SLC LAS 0930 Delta 0666";
				retn = "LAS SLC 1830 Delta 1313";
				flgtPrice = 100 + (.11 * 734);
			}
		}
		if (selected.equals("NY")) {
			htlIndex = 4;
			if (flgtCheck.isSelected()) {
				depart = "SLC JFK 0930 Delta 5116";
				retn = "JFK SLC 1830 Delta 7118";
				flgtPrice = 100 + (.11 * 3960);
			}
		}
		if (selected.equals("HI")) {
			htlIndex = 5;
			if (flgtCheck.isSelected()) {
				depart = "SLC HNL 0930 Delta 0731";
				retn = "HNL SLC 1830 Delta 4192";
				flgtPrice = 100 + (.11 * 5980);
			}
		}
		if (selected.equals("UT")) {
			depart = "SLC is your current city. Your flight cannot be made";
			retn = "<This field intentionally left blank.>";
			flgtPrice = 0.0;
			htlIndex = 6;
		}
		
		fnl.add(depart);
		fnl.add(retn);
		
		if (flgtCheck.isSelected()) {
			hasFlight = true;
			JLabel flight = new JLabel("*Flight processed and added to price");
			flight.setFont(new Font("Forte", Font.PLAIN, 30));
			flight.setBounds(82, 520, 566, 39);
			review.add(flight);
		}
		
		return fnl;
	}
}
