package activities;
import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("M");
		hs.add("B");
		hs.add("C");
		hs.add("A");
		hs.add("M");
		hs.add("X");
		hs.add("R");
		
		System.out.println("Original Hash Set: " + hs);
		System.out.println("Size of Hash Set: " + hs.size());
		
		System.out.println("Removing A from Hash Set: " + hs.remove("A"));
		
		if(hs.remove("Z")) {
			System.out.println("Z has removed in the set");
		}
		else {
			System.out.println("Z is not present in the set");
		}
		
		System.out.println("Checking if M is present: " + hs.contains("M"));
		System.out.println("Updated Hash Set: " + hs);
		
	}

}
