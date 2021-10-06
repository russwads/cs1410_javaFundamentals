package nuisance;

import java.util.ArrayList;
import java.util.List;

/**
 * Application that handles an array of nuisances and otherwise, from persons to insects
 * @author Russell
 *
 */
public class NuisanceApp {

	/**
	 * Main method for running the application
	 * @param args string arguments
	 */
	public static void main(String[] args) {
		// Initializing friends, and printing 3 friends
		Friend[] friends = new Friend[4];
		friends[0] = new Friend("Juan",27,Hobby.MUSIC);
		friends[1] = new Friend("Kate",27,Hobby.SPORTS);
		friends[2] = new Friend("Alex",21,Hobby.MUSIC);
		System.out.println("3 Friends:");
		for (int i = 0; i < 3; i++) {
			System.out.println("friend" + (i + 1) + ": " + friends[i].toString());
		}
		System.out.println();
		
		// Comparing friends, and printing the telemarketer
		System.out.println("friend1 equals friend2: " + friends[0].equals(friends[1]));
		System.out.println("friend1 equals friend3: " + friends[0].equals(friends[2]));
		friends[3] = new Friend("Kate",27,Hobby.SPORTS);
		System.out.println("friend2 equals new friend: " + friends[1].equals(friends[3]));
		System.out.println();
		Telemarketer tm = new Telemarketer("Fritz",25);
		System.out.println("telemarketer: " + tm.toString());
		System.out.println();
		
		// Initializing insects and printing 4 insects
		Mosquito m1 = new Mosquito("Aedes vexans");
		PeskyMosquito pm1 = new PeskyMosquito("Anopheles walkeri");
		List<String> l1 = new ArrayList<String>();
		l1.add("yellow");
		l1.add("black");
		l1.add("blue");
		Butterfly b1 = new Butterfly("Swallowtail",l1);
		Butterfly b2 = new Butterfly(b1);
		Insect[] insects = new Insect[4];
		insects[0] = m1;
		insects[1] = pm1;
		insects[2] = b1;
		insects[3] = b2;
		System.out.println("4 Insects:");
		for (int i = 0; i < 4; i++) {
			System.out.println(insects[i].toString());
		}
		System.out.println();
		
		// The 3 Nuisances
		System.out.println("3 Nuisances:");
		Nuisance[] pests = new Nuisance[4];
		pests[0] = tm;
		pests[1] = m1;
		pests[2] = pm1;
		for (int i = 0; i < 3; i++) {
			if (pests[i] instanceof PeskyMosquito) {
				PeskyMosquito pm2 = (PeskyMosquito) pests[i];
				System.out.println(pm2.buzz());
				System.out.println(pm2.bite());
				System.out.println(pm2.annoy());
			}
			else if (pests[i] instanceof Mosquito) {
				Mosquito m2 = (Mosquito) pests[i];
				System.out.println(m2.buzz());
				System.out.println(m2.annoy());
			}
			else {
				System.out.println(pests[i].annoy());
			}
			System.out.println();
		}
	}

}
