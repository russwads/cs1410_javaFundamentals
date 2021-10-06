package m02;

import java.util.ArrayList;

/**
 * Main application for the Module 2 Test
 * @author Russell
 *
 */
public class Module02 {

	/**
	 * Main method for testing the power plants
	 * @param args string arguments
	 */
	public static void main(String[] args) {
		ArrayList<PowerPlant> plants = new ArrayList<PowerPlant> ();
		plants.add(new PowerPlant(100));
		plants.add(new WindFarm(6800, false));
		plants.add(new WindFarm(400, true));
		plants.add(new HydroPowerPlant(22500,true));
		plants.add(new HydroPowerPlant(15,false));
		
		for(int i = 0; i < plants.size(); i++) {
			System.out.println(plants.get(i).toString());
			System.out.println(plants.get(i).generateElectricity());
			if (i < plants.size() - 1) {
				System.out.println();
			}
		}
	}

}
