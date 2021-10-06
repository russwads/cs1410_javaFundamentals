package m02;

/**
 * An industrial area that is designed to create power for a given sector of land
 * @author Russell
 *
 */
public class PowerPlant {
	private int capacity;
	
	/**
	 * Creates a power plant by defining its power capacity
	 * @param capacityIn capacity for power source
	 */
	public PowerPlant (int capacityIn) {
		if (capacityIn < 1) {
			throw new IllegalArgumentException("The capacity needs to be a positive number.");
		}
		else {
			capacity = capacityIn;
		}
	}
	
	/**
	 * Simulates the process of generating electricity
	 * @return
	 */
	public String generateElectricity() {
		return "generating electricity";
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + capacity + "MW";
	}
	
}
