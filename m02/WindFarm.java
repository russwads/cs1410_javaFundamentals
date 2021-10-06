package m02;

/**
 * A type of power plant that uses wind turbines and strong currents of wind to create power
 * @author Russell
 *
 */
public class WindFarm extends PowerPlant {
	private boolean offshore;
	
	/**
	 * Creates a wind farm
	 * @param capacity capacity for power source
	 * @param offshoreIn location is offshore or not offshore
	 */
	public WindFarm(int capacity, boolean offshoreIn) {
		super(capacity);
		offshore = offshoreIn;
	}
	
	/**
	 * Describes if the wind farm is offshore or not (True if offshore, False if onshore).
	 * @return
	 */
	public boolean offshore() {
		return offshore;
	}
	
	@Override
	public String generateElectricity() {
		return "generating electricity from wind";
	}

	@Override
	public String toString() {
		String isOff;
		if (offshore) {
			isOff = " ~~~";
		}
		else {
			isOff = "";
		}
		return super.toString() + isOff;
	}
}
