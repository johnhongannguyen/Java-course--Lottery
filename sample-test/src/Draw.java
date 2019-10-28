import java.util.Arrays;

/**
 * the class to represent each draw (a single ticket)
 * @author retemadi
 *
 */
public class Draw {
	
	/**
	 * internal instance variable to store 6 numbers
	 * it is immutable as we don't provide any setter
	 * only during construction its value is set.
	 */
	private int[] pick = new int[6];
	
	/**
	 * constructor, takes an array of 6 numbers as input
	 * it copies the input into instance variable and sort it.
	 * @param pick
	 */
	public Draw(int[] pick) {
		this.pick = Arrays.copyOf(pick, pick.length); 
		Arrays.sort(this.pick);
	}
	
	/**
	 * return number at requested index (0 to 5)
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (index >-1 && index < 6) {
			return pick[index];
		} else {
			return -1;
		}
	}

	/**
	 * provide an String representation of draw object 
	 */
	public String toString() {
		String stringRep = "[ "+pick[0];
		for(int n=1; n<pick.length; n++) {  
			stringRep += ", "+pick[n];
		}
		stringRep +=" ]";
		return stringRep;
	}

}
