package m02;

/**
 * A power plant that uses the power of water to create power for a sector close to a water source
 * @author Russell
 *
 */
public class HydroPowerPlant extends PowerPlant {
	private boolean dam;
	
	/**
	 * 
	 * @param capacity capacity for power source
	 * @param dam1 contains a dam as a power source
	 */
	public HydroPowerPlant(int capacity, boolean dam1) {
		super(capacity);
		dam = dam1;
	}
	/**
	 * Determines if the hydro power plant has a connected dam or not (True if has a dam, False if not).
	 * @return
	 */
	public boolean hasDam() {
		return dam;
	}
	
	@Override
	public String generateElectricity () {
		return "generating electricity from water";
	}
	@Override
	public String toString() {
		String hasDam;
		if (dam) {
			hasDam = " with a dam";
		}
		else {
			hasDam = " without a dam";
		}
		return super.toString() + hasDam;
	}
	
}
