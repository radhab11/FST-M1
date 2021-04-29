package activities;
import java.util.*;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random indexGen = new Random();
		
		System.out.println("Enter Integer Please");
		System.out.println("(EOF or non-integer to terminate): ");
		
		while(scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		
		Integer nums[] = list.toArray(new Integer[0]);
		int index = indexGen.nextInt(nums.length);
		System.out.println("Index Value generated: " + index);
		System.out.println("Value in array at generated index: " + nums[index]);
		
		scan.close();
	}

}
