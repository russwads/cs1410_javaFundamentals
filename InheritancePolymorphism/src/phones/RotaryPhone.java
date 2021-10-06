package phones;

/**
 * Represents a rotary phone that uses a rotation method to dial numbers
 * @author Russell
 *
 */
public class RotaryPhone extends DeskPhone {
	/**
	 * 
	 * @param model model of phone
	 * @param dimensions dimensions of phone
	 * @param voltage voltage of CAT5 cord and phone
	 */
	public RotaryPhone(String model, Dimension dimensions, Voltage voltage ) {
		super(model,dimensions,voltage);
	}
	
	/**
	 * Represents the way a rotary phone calls people
	 */
	public String call (long number) {
		return "Rotating the dial to call " + number;
	}
}
