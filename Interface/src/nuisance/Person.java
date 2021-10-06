package nuisance;

/**
 * Homo sapiens--a human, known for generally being the smartest species of animal, though this is highly debated.
 * @author Russell
 *
 */
public class Person {
	private String name;
	private int age;

	/**
	 * Creates a person object, inserting a name and an age
	 * @param nameIn name of person
	 * @param ageIn age of person, ranging from 1-150
	 */
	public Person(String nameIn, int ageIn) {
		name = nameIn;
		if (ageIn < 1 || ageIn > 150) {
			throw new IllegalArgumentException("Age needs to be within the range of 1 to 150.");
		}
		else {
			age = ageIn;
		}
	}
	/**
	 * Returns the name of the person in a String format.
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the age of the person in an integer format.
	 * @return
	 */
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	@Override
	public boolean equals(Object f) {  
        //Compared to itself
		if (f == this) { 
            return true; 
        } 
		else if (f == null) {
			return false;
		}
		else if (!(f instanceof Person)) {
			return false;
		}
        //Compares members
        if (this.getName().compareTo(((Person) f).getName()) == 0 
        		&& Double.compare(this.getAge(), ((Person) f).getAge()) == 0) {
        	return true;
        }
        else {
        	return false;
        }
	}
}
