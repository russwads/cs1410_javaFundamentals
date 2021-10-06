package nuisance;

/**
 * A person who is not a nuisance and is fun to be around; chum, pal, dudes, etc.
 * @author Russell
 *
 */
public class Friend extends Person {
	private Hobby h1;
	
	/**
	 * Creates a friend object
	 * @param name name of person
	 * @param age age of person
	 * @param hobby hobby that this friend enjoys to do
	 */
	public Friend(String name, int age, Hobby hobby) {
		super(name, age);
		h1 = hobby;
	}
	/**
	 * Returns a means of relaxing for one single friend
	 * @return
	 */
	public String chill() {
		return super.getName() + " is chilling";
	}
	/**
	 * Exhibits the method of playing within friend groups and with how many friends there are
	 * @param friends array of friends participating
	 * @return the method of play
	 */
	public String play(Friend[] friends) {
		if (friends.length < 1) {
			return "playing " + h1;
		}
		else if (friends.length == 1) {
			return "playing " + h1 + " with " + friends[0].getName();
		}
		else if (friends.length == 2) {
			return "playing " + h1 + " with " + friends[0].getName() + " and " + friends[1].getName();
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("playing " + h1 + " with ");
			for (int i = 0; i < friends.length - 1; i++) {
				sb.append(friends[i].getName()).append(", ");
			}
			sb.append("and ").append(friends[friends.length-1].getName());
			return sb.toString();
		}
	}
	@Override
	public String toString() {
		return super.toString() + " " + h1;
	}
}
