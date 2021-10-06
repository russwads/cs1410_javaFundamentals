package vacation;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * A roundtrip flight from two maximum airports. Flights include a departure flight and a return flight, depending on the day. 
 * There is exactly one departure and one return flight that the user can take per day. 
 * @author Russell
 *
 */
public interface Flight {
	/**
	 * Finds two flights from a list and returns the correct flight pair for the person to take.
	 * @param d the state going in to determine the flight
	 * @param r The expedition that the flights will go to and from to
	 * @param f checkbox stating a flight was desired
	 * @return Departing Flight Information and Returning Flight Information
	 */
	public ArrayList<String> trip(String d, Expedition r, JCheckBox f, JPanel review);
}
