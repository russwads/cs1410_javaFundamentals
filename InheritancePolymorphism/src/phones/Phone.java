package phones;

/**
 * Represents a generic phone that can call over long distances
 * @author Russell
 *
 */
public abstract class Phone {
	private String model;
	private Dimension dimensions;
	
	/**
	 * Creates a generic phone with a model and size dimensions
	 * @param modelIn model of phone
	 * @param dimensionIn dimensions of phone
	 */
	protected Phone(String modelIn, Dimension dimensionIn) {
		model = modelIn;
		dimensions = dimensionIn;
	}
	
	/**
	 * Calls a number, started by dialing the actual number
	 * @param number 10-digit number for USA numbers (or longer, if long-distance)
	 * @return Method of calling a number
	 */
	public abstract String call(long number);

	@Override
	public String toString() {
		return model + " " + dimensions.toString();
	}
}
