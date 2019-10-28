import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Part I
		Scanner in = new Scanner(System.in);
		System.out.println("Enter how many ticket to draw. O to quit: ");
		while(!in.hasNextInt()) { // skip non digits
			in.next();
		}
		int num = in.nextInt();
		for(int i=1; i<=num; i++) {
			Draw ticket = new Draw(Lottery.pick6Random());
			System.out.println("\nTicket #"+i +" : "+ticket);
			ArrayList<Integer> matches = Lottery.findMatch(ticket);
			System.out.println("Matches are :" + matches);
			System.out.println(" ===> " +Lottery.findPrize(matches.size()));
		}
		
		// Part II/// run stats. for 15millions draw
		long startTime = System.currentTimeMillis();
		runStart(1500000);
		long totalTime = System.currentTimeMillis() - startTime;
		
		in.close();
		System.out.println("Done in "+totalTime+" ms.\nBye!");
	}
	
	public static void runStart(int limit) {
		System.out.println("\n... Running "+limit+" random draws... ");
		int[] total =new int[7];
		for(int i=0; i<limit; i++) {
			Draw tick = new Draw(Lottery.pick6Random());
			int match =Lottery.findMatch(tick).size();
			total[match]++;
			
		}
		
		for(int i=2; i<total.length; i++) {
			System.out.println("\nTotal" +i+" matched tickets : "+total[i]);
			System.out.println("Probability of matching "+i+"number: %"+(total[i]+0.0/limit * 100));
		}
	}

}
