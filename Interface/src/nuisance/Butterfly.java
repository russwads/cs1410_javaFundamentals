package nuisance;

import java.util.ArrayList;
import java.util.List;

/**
 * Insects found in the "Rhopalocera" Suborder containing large, brightly colored wings
 * @author Russell
 *
 */
public final class Butterfly extends Insect {
	private List<String> colors = new ArrayList<String>();
	
	/**
	 * Creates a butterfly with a specific species and list of colors
	 * @param species species of butterfly
	 * @param colorsIn list of colors that butterfly possesses
	 */
	public Butterfly(String species, List<String> colorsIn) {
		super(species);
		for (int i = 0; i < colorsIn.size(); i ++) {
			colors.add(colorsIn.get(i));
		}
	}
	/**
	 * Creates a butterfly based on an existing butterfly
	 * @param butterfly an existing butterfly
	 */
	public Butterfly(Butterfly butterfly) {
		super(butterfly.getSpecies());
		colors = butterfly.getColors();
	}
	/**
	 * Returns the list of colors as a list object
	 * @return
	 */
	public List<String> getColors() {
		List<String> exit = new ArrayList<String> ();
		for (int i = 0; i < colors.size(); i++) {
			exit.add(colors.get(i));
		}
		return exit;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getSpecies()).append(" [");
		for (int i = 0; i < colors.size() - 1; i ++) {
			sb.append(colors.get(i)).append(", ");
		}
		sb.append(colors.get(colors.size() - 1)).append("]");
		return sb.toString();
	}
	
}
