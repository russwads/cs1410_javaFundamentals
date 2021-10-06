package phones;

/**
 * Property for Desk Phone voltage; used for signal strength
 * @author Russell
 *
 */
enum Voltage {
	V110, V220, DUAL;
}

/**
 * Represents a generic desk landline phone
 * @author Russell
 *
 */
public abstract class DeskPhone extends Phone {
	private Voltage voltage;
	public boolean connected;
	
	/**
	 * Creates a desk phone; calls upon the superclass Phone and assigns a voltage
	 * @param model model of phone
	 * @param dimensions dimensions (length, width, depth) in centimeters
	 * @param volt voltage; used for signal strength
	 */
	protected DeskPhone (String model, Dimension dimensions, Voltage volt) {
		super(model, dimensions);
		voltage = volt;
		unplug();
	}
	
	/**
	 * Plugged into the CAT5 connector
	 */
	public void plugIn() {
		connected = true;
	}
	/**
	 * Unplugs the cord from the CAT5 connector
	 */
	public void unplug() {
		connected = false;
	}
	/**
	 * Checks to see if the cord is connected into the CAT5 connector
	 * @return
	 */
	public boolean isConnected() {
		return connected;
	}

	@Override
	public String toString() {
		String connectionInfo;
		if (isConnected()) {
			connectionInfo = "connected";
		}
		else {
			connectionInfo = "not connected";
		}
		return super.toString() + " " + voltage + " " + connectionInfo;
	}
}
