package phones;

/**
 * Represents a smart phone object that can do more functions than simply calling
 * @author Russell
 *
 */
public class SmartPhone extends Phone {
	private int storage = 0;
	
	/**
	 * Represents the creation of a smart phone object
	 * @param model model of smart phone
	 * @param dimensions dimensions of smart phone
	 * @param storageIn storage capacity of smart phone
	 */
	public SmartPhone(String model, Dimension dimensions, int storageIn) {
		super(model, dimensions);
		if (storageIn < 1) {
			throw new IllegalArgumentException("Storage needs to be assigned a positive value.");
		}
		storage = storageIn;
	}

	@Override
	public String call(long number) {
		return "Calling " + number + " by selecting the number";
	}
	
	/**
	 * Illustrates the ability to browse the web through a web browser
	 * @return
	 */
	public String browse() {
		return "Browsing the web";
	}
	
	/**
	 * Takes pictures, randomly either by landscape or portrait
	 * @return
	 */
	public String takePicture() {
		boolean horver = Math.random() < 0.5;
		if (horver) {
			return "Taking a horizontal picture";
		}
		else {
			return "Taking a vertical picture";
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + storage + "GB";
	}
	
	
}
