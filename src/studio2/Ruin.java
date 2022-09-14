package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("How much money do you have?");
		double startAmount = scan.nextDouble();
		System.out.println("Win chance?");
		double winChance = scan.nextDouble();
		System.out.println("Win limit?");
		double winLimit = scan.nextDouble();
		int winTimes;
		int loseTimes;
		int loseTotal=0;
	    double currentAmount;
		System.out.println("Total Simulations?");
		int totalSimulations = scan.nextInt();
		for(int x = 1; x <= totalSimulations; x++)
		{
			currentAmount = startAmount; winTimes = 0; loseTimes = 0;
		while(currentAmount < winLimit && currentAmount > 0)
		{
	
		if (Math.random() > winChance)
		{
			currentAmount--;
			loseTimes++;
		}
		else
		{
			currentAmount++;
			winTimes++;
		}
		}
		if(currentAmount == 0)
		{
			System.out.println("Simulation " + x + ": " +(winTimes+loseTimes) + " LOSE");
			loseTotal++;
		}
		else
		{
		   System.out.println("Simulation " + x + ": "+(winTimes+loseTimes) + " WIN");
		}
		
		}
	    System.out.println("Losses: " + loseTotal);
	    System.out.println("Simulation: " + totalSimulations);
	    System.out.println("Ruin rate from simulation: " + (double)loseTotal/totalSimulations);
	    double expectedRuin;
	    double y = (1 - winChance)/winChance;
	    if(winChance == 0.5)
	    {
	    	expectedRuin = 1 - startAmount/winLimit;
	    }
	    else
	    {
	    	expectedRuin = (Math.pow(y, startAmount)-Math.pow(y,winLimit))/(1-Math.pow(y,winLimit));
	    }
	System.out.println("Expected Ruin Rate: " + expectedRuin);
	}

}
