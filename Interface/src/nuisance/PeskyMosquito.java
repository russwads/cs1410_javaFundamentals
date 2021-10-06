package nuisance;

/**
 * A mosquito that not only flies and annoys like a mosquito, but bites like one too
 * @author Russell
 *
 */
public class PeskyMosquito extends Mosquito {
	/**
	 * Creates a pesky mosquito, which is even sadder and worse than just making a simple mosquito
	 * @param species species of mosquito
	 */
	public PeskyMosquito(String species) {
		super(species);
	}
	/**
	 * Resembles the behavior of this parasite, biting and sucking blood from its host
	 * @return
	 */
	public String bite() {
		return "sucking blood";
	}
}
