package phones;

/**
 * Represents a type of phone that you plug in and push buttons for to dial a number
 * @author Russell
 *
 */
public class PushButtonPhone extends DeskPhone {
	/**
	 * Creates a Push Button landline phone
	 * @param model model of phone
	 * @param dimensions dimensions of phone
	 * @param voltage voltage of CAT5 cord and phone
	 */
	public PushButtonPhone(String model, Dimension dimensions, Voltage voltage) {
		super(model, dimensions, voltage);
	}
	
	/**
	 * Calls a number by pushing buttons
	 */
	public String call (long number) {
		return "Pushing buttons to call " + number;
	}
}
