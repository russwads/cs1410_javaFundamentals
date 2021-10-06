package docComments;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	/**
	 * Prints out the menu of options in the program each time it is called.
	 */
	private static void menu() {
		System.out.println("1. Show all drones");
		System.out.println("2. Add a drone");
		System.out.println("3. Find a drone");
		System.out.println("4. Delete a drone");
		System.out.println("5. Number of drones");
		System.out.println("6. Exit");
		System.out.println("Enter your selection: ");
	}
	/**
	 * Retrieves each drone in inventory, and displays the name, model, camera resolution, and inventory ID
	 * @param inv inventory list array; filled with the drone counts
	 */
	private static void display(ArrayList<Drone> inv) {
		for (int i = 0; i < inv.size(); i++) {
			System.out.println(inv.get(i).toString());
		}
	}
	/**
	 * Adds a new drone to the inventory and gives it a unique ID number
	 * @param inv the complete inventory list
	 * @param d1 the drone that will be added to the inventory parameter "inv"
	 * @param seed the number that will be tied to the Drone as the inventory ID
	 * @return
	 */
	private static int addDrone(ArrayList<Drone> inv, Drone d1, int seed) {
		inv.add(d1);
		d1.counter(seed);
		return d1.getSeed();
	}
	/**
	 * Finds a drone in the inventory list and displays the single drone's characteristics.
	 * This function is primarily based on the ID of the drone.
	 * @param inv the complete inventory list
	 * @param number the drone ID used to find the drone in the inventory list
	 * @return the drone's unique inventory ID
	 */
	private static int findDrone(ArrayList<Drone> inv, String number) {
		int inSeed = Integer.parseInt(number);
		for (int i = 0; i< inv.size(); i++) {
			Drone temp = inv.get(i);
			int compare = temp.getSeed();
			if (compare == inSeed) {
				System.out.println(temp.toString());
				return inSeed;
			}
		}
		System.out.println("The ID " + inSeed + " could not be found.");
		return -1;
	}
	/**
	 * Finds a drone in the inventory list and displays the single drone's characteristics.
	 * This function is primarily based on the indexing number of the drone.
	 * @param inv the complete inventory list
	 * @param number the drone ID used to find the drone in the inventory list
	 * @return the drone's index in the inventory list array
	 */
	private static int findDroneIndex (ArrayList<Drone> inv, String number) {
		int inSeed = Integer.parseInt(number);
		for (int i = 0; i< inv.size(); i++) {
			Drone temp = inv.get(i);
			int compare = temp.getSeed();
			if (compare == inSeed) {
				return i;
			}
		}
		System.out.println("There's an error if you get here..");
		return -1;
	}
	/**
	 * The main function to Inventory Program
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Drone> inv = new ArrayList<Drone>();
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		int sel = 0;
		int findSeed = 0;
		Drone stone = new Drone("Holy Stone", "HS110G", 1080);
		Drone mavic = new Drone("DJI", "Mavic 2 Pro", 2160);
		Drone mantis = new Drone("Yuneec", "Mantis G", 2160);
		Drone tello = new Drone("Ryze Tech", "Tello", 720);
		inv.add(stone);
		int newSeed = stone.getSeed();
		newSeed = addDrone(inv,mavic,newSeed);
		newSeed = addDrone(inv,mantis,newSeed);
		newSeed = addDrone(inv,tello,newSeed);
		
		
		while(sel != 6) {
			String inSel;
			menu();
			inSel = myObj.nextLine();
			sel = Integer.parseInt(inSel);
			
			switch (sel) {
				case 1:
					display(inv);
					break;
				case 2:
					Scanner newEnter = new Scanner(System.in);
					System.out.println("Name: ");
					String ent1 = newEnter.nextLine();
					System.out.println("Type: ");
					String ent2 = newEnter.nextLine();
					System.out.println("Camera Resolution: ");
					String ent3 = newEnter.nextLine();
					int res = Integer.parseInt(ent3);
					Drone nextDrone = new Drone(ent1,ent2,res);
					newSeed = addDrone(inv,nextDrone,newSeed);
					break;
				case 3:
					System.out.println("ID: ");
					Scanner newFind = new Scanner(System.in);
					String number = newFind.nextLine();
					findSeed = findDrone(inv, number);
					break;
				case 4:
					System.out.println("ID: ");
					Scanner newFind1 = new Scanner(System.in);
					String number1 = newFind1.nextLine();
					findSeed = findDrone(inv,number1);
					if (findSeed != -1) {
						int i = findDroneIndex(inv,number1);
						inv.remove(i);
						System.out.println(" has been deleted.");
					}
					break;
				case 5:
					System.out.println("Number of drones: " + inv.size());
					break;
				case 6:
					System.out.println("Goodbye!");
					sel = 6;
					break;
				default:
					System.out.println("Please enter a number 1-6");
			}
			System.out.println();
		}
	}
}
