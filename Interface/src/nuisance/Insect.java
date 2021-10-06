package nuisance;

/**
 * Hexapod invertibrates that compose the largest group in the Phylum "Arthropoda"
 * @author Russell
 *
 */
public class Insect {
	private String species;
	
	/**
	 * Creates an insect object with the name of the species
	 * @param speciesIn name of species
	 */
	public Insect (String speciesIn) {
		species = speciesIn;
	}
	/**
	 * Returns the name of the insect species
	 * @return
	 */
	public String getSpecies() {
		return species;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + species;
	}
	
}
