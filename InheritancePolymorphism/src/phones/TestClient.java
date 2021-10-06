package phones;

import java.util.ArrayList;

/**
 * Application used to test phone functionality
 * @author Russell
 *
 */
public class TestClient {
	/**
	 * Randomly selects either a true or false route; used to either plug or unplug a desk phone cord randomly
	 * @return
	 */
	public static boolean randomBool() {
		return Math.random() < 0.5;
	}

	/**
	 * Main functionality for the phone application
	 * @param args string arguments
	 */
	public static void main(String[] args) {
		RotaryPhone rp = new RotaryPhone("Model 500",new Dimension(143,208,119),Voltage.V110);
		PushButtonPhone pbp = new PushButtonPhone("Cortelo 2500",new Dimension(178,228,127),Voltage.DUAL);
		ArrayList<Phone> phones = new ArrayList<Phone>();
		phones.add(rp);
		phones.add(pbp);
		phones.add(new SmartPhone("Pixel3",new Dimension(145.6,68.2,7.9),128));
		phones.add(new SmartPhone("iPhone8",new Dimension(138.4,67.3,7.3),64));
		
		//Printing phones first time
		System.out.println("Various Phones:");
		for (int i = 0; i < phones.size(); i++) {
			System.out.println(phones.get(i).toString());
		}
		System.out.println();
		
		//Plug in the rotary phones and unplug one at random
		rp.plugIn();
		pbp.plugIn();
		if (randomBool()) {
			pbp.unplug();
		}
		else {
			rp.unplug();
		}
		
		//Array Printing
		System.out.println("Array Elements:");
		for (int i = 0; i < phones.size(); i++) {
			System.out.println(phones.get(i).toString());
			System.out.println(phones.get(i).call(8019574111L));
			if (phones.get(i) instanceof SmartPhone) {
				SmartPhone temp = (SmartPhone) phones.get(i);
				System.out.println(temp.browse());
				System.out.println(temp.takePicture());
			}
			System.out.println();
		}
	}

}
