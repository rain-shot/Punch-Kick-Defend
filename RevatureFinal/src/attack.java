
public class attack {

	int damage = 0; //declaring damage variable for damage calculations
	
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
		
		damage = attack * 2 - defense;
		
		if (defense > attack) //defense is higher than attack no damage will be done
		{
			return 0;
		}
		//some code for determining kick damage based on stats of user and stats of enemy.
		//possibly add in rng for critical hit
		//should also take into account enemy reaction
		
		/*Strong attack that can be dodged*/
		
		return damage;
	}
	
}
