import java.util.Random;

public class rest {

	Random resting = new Random();
	
	public int Rested(int maxHealth, String x)
	{
		int value = 0;
		
		while(value == 0) //loop goes if the random value is less than 1 since resting should always increase health by some amount!
		{
			value = resting.nextInt(34); //this will return a random number between 0 and 33
		}
		
		double temp = maxHealth * value/100; //sets value of temp

		if (temp < 1.0) //rounds returning value up to 1 if lower since resting should always heal at least 1 point
		{
			temp = 1.0;
		}
		System.out.println(x + "recovered " + (int)temp + " health!");
		return (int)temp;
	}
	
}