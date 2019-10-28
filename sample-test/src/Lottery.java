import java.util.ArrayList;
import java.util.Random;

/**
 * class to draw lottery tickets and verify 
 * @author retemadi
 *
 */
public class Lottery {

	private static final Random randomGenerator = new Random(42);

	//the winning numbers to be used for checking
	private static final int[] winnningDraw = {3, 5, 9, 14, 15, 26};
	
	/**
	 * returns an array of 6 random numbers between 1 and 49
	 * @return
	 */
	public static int[] pick6Random() {
		ArrayList<Integer> range = new ArrayList<>();
		for(int i=1; i<50; i++) { //fill it with [1, ..., 49]
			range.add(i);
		}
		
		int[] draw = new int[6]; //the draw to return
		//pick 6 random numbers from above array list
		for(int i=0; i<6; i++) {
			int position = randomGenerator.nextInt(range.size()); 
			draw[i] = range.get(position);
			range.remove(position);  //to avoid duplicate numbers in next random pick
		}
		
		return draw;
	}

	/**
	 * returns all matching numbers for a given draw (compared to internal winning draw)
	 * @param ticket
	 * @return
	 */
	public static ArrayList<Integer> findMatch(Draw ticket) {
		ArrayList<Integer> matches = new ArrayList<>();
		for(int n : winnningDraw) {  // for every number in winning draw
			for(int i=0; i<6; i++) {  //compare it with every number in the ticket
				if (n == ticket.get(i)) {
					matches.add(n);
				}
			}
		}
		return matches;
	}
	
	/**
	 * returns the related prize message for a given number of matches
	 * @param input
	 * @return
	 */
	public static String findPrize(int numberOfMatch) {
		switch(numberOfMatch) {
			case 2 : return "Won Free Ticket";
			case 3 : return "Won $10";
			case 4 : return "Won a share of %9.5 of Pot";
			case 5 : return "Won a share of %5 of Pot";
			case 6 : return "Won JACKPOT!";
		}
		return "Not a Winner"; //anything other than above switch cases
	}
	
}
