package docComments;

/**
 * Describes a camera drone primarily used for recreational flying and photography. Main data members are
 * used to describe the name, the model or type, and the camera resolution.
 * @author Russell
 *
 */
public class Drone {
	private String name;
	private String type;
	private int resolution;
	private int seed = 2468012;
	private int staticcount = 1;
	
	/**
	 * Primary constructor to create a drone. Must have all parameters met--name, type, resolution--in order to generate.
	 * @param name_in name of drone company
	 * @param type_in model of drone
	 * @param resolution_in camera resolution, usually in HD
	 */
	public Drone(String name_in, String type_in, int resolution_in) {
		name = name_in;
		type = type_in;
		resolution = resolution_in;
	}
	/**
	 * Returns the name of the drone company
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the type or model of the drone
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Returns the camera resolution of the drone
	 * @return
	 */
	public int getResolution() {
		return resolution;
	}
	/**
	 * Returns the unique ID that is used in the inventory list attached to each drone
	 * @return
	 */
	public int getSeed() {
		return seed;
	}
	/**
	 * Calculates the static count and the unique ID for the drone; used primarily for ease to calculate
	 * the next drone's ID so as to keep the IDs unique of each individual drone
	 * @param oldseed the previous drone's ID in the list
	 * @return the new drone's ID
	 */
	public int counter(int oldseed) {
		seed = oldseed + staticcount;
		return seed;
	}
	/*  (non-Javadoc)
	 *  @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " " + type + ", " + resolution + "p HD; ID: " + seed;
	}
	
}
