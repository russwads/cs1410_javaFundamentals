package vacation;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VacationPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3181955895551198479L;
	private static ArrayList<String> expeditionNames = new ArrayList<String> ();
	
	public VacationPanel(JPanel vacation, ArrayList<String> expNam, JComboBox vacationChoices, JComboBox boxDays, JCheckBox flgtCheck) {
		setBackground(SystemColor.activeCaption);
		for (int i = 0; i < expNam.size(); i++) 
			expeditionNames.add(expNam.get(i));
		
		// Label creation
		JLabel lblVacation = new JLabel("Vacation");
		lblVacation.setFont(new Font("Forte", Font.BOLD, 75));
		lblVacation.setHorizontalAlignment(SwingConstants.CENTER);
		lblVacation.setBounds(193, 62, 383, 131);
		vacation.add(lblVacation);
		
		JLabel lblVacaSub = new JLabel("Plan a Vacation");
		lblVacaSub.setHorizontalAlignment(SwingConstants.CENTER);
		lblVacaSub.setFont(new Font("Forte", Font.BOLD, 27));
		lblVacaSub.setBounds(256, 158, 238, 48);
		vacation.add(lblVacaSub);
		
		JLabel lblvacaDays = new JLabel("Number of Days");
		lblvacaDays.setFont(new Font("Forte", Font.PLAIN, 25));
		lblvacaDays.setBounds(82, 615, 195, 39);
		vacation.add(lblvacaDays);
		
		boxDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boxDays.setBounds(287, 615, 46, 39);
		vacation.add(boxDays);
		
		JLabel flightPrompt = new JLabel("Check this box to schedule a flight");
		flightPrompt.setFont(new Font("Forte", Font.PLAIN, 20));
		flightPrompt.setBounds(369, 619, 300, 39);
		vacation.add(flightPrompt);
		
		flgtCheck.setHorizontalAlignment(SwingConstants.CENTER);
		flgtCheck.setFont(new Font("Tahoma", Font.PLAIN, 20));
		flgtCheck.setBounds(675, 619, 38, 38);
		vacation.add(flgtCheck);
	}
}
