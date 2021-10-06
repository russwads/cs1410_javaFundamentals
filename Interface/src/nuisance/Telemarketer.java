package nuisance;

/**
 * A person who does exhibit an air of nuisance; someone who pesters other people to buy things
 * @author Russell
 *
 */
public class Telemarketer extends Person implements Nuisance {
	/**
	 * Creates a telemarketing person, which is a darn shame.
	 * @param name name of person
	 * @param age age of person
	 */
	public Telemarketer(String name, int age) {
		super(name, age);
	}
	
	/**
	 * Represents how a telemarketer gives a sales pitch
	 * @return
	 */
	public String givesSalesPitch() {
		return super.getName() + " pressures others to buy stuff";
	}

	@Override
	public String annoy() {
		return super.getName() + " annoys by giving a sales pitch";
	}
}
