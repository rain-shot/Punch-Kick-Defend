import java.util.Random;

public class attack {

	int damage = 0; //declaring damage variable for damage calculations
	Random criticalHit = new Random();
	
	//write some code here with methods for punch and kick
	public int Punch(int attack, int defense)
	{	
		damage = attack - defense;
		
		if (defense > attack) //defense is higher than attack no damage will be done
		{
			return 0;
		}
		//some code for determining punch damage based on stats of user and stats of enemy.
		//possibly add in rng for critical hit
		//should also take into account enemy reaction
		
		/*weak attack that cannot be dodged*/
		
		return damage;
	}
	
	public int Kick(int attack, int defense)
	{
		
		damage = attack * 2 - defense; //which damage do I want? 7 * 2 - 4 = 10
		//damage = (attack - defense) * 2; //which damage do I want? (7 - 4) * 2 = 6
		
		if (defense > attack * 2) //defense is higher than attack no damage will be done
		{
			return 0;
		}
		//some code for determining kick damage based on stats of user and stats of enemy.
		//possibly add in rng for critical hit
		//should also take into account enemy reaction
		
		/*Strong attack that can be dodged*/
		
		return damage;
	}
	
	
	public double criticalHit(String x)
	{
		int temp = 0;
		temp = criticalHit.nextInt(20);
		if (temp == 19)
		{
			System.out.println(x + " got a critical hit!");
			return 1.15;
		}
		
		return 1;
	} //critical hit function
	
}
