package nuisance;

/**
 * An insect found in the "Diptera" Order under the Family "Culicidae" that resembles a little blood-sucking fly
 * @author Russell
 *
 */
public class Mosquito extends Insect implements Nuisance {
	/**
	 * Creates a mosquito, which is a terrible thing to perform on society...
	 * @param species species of mosquito
	 */
	public Mosquito(String species) {
		super(species);
	}
	/**
	 * Resembles the method of a mosquito's flying movements with a high-pitched buzzing sound
	 * @return
	 */
	public String buzz() {
		return super.getSpecies() + " buzzing around";
	}
	@Override
	public String annoy() {
		return "buzz buzz buzz";
	}
}
