package edu.unl.raikes.BinarySearchTreeLab;

/**
 * This class controls the fuctionality of the person.
 */
public class Person implements Comparable<Person> {
    int key;
    String name;

    /**
     * The constructor.
     * @param NUID - the NUID
     * @param name - the name
     */
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    /**
     * To string method.
     */
    public String toString() {
        return "NUID: " + this.key + "  Name: " + name;
    }

    /**
	 * 
	 */
    public int compareTo(Person other) {
        return Integer.compare(key, other.key);
    }
}
