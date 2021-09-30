
public class Profiles {
	
	Profiles()
	{
		//some code for creating blank profiles for player, for adding into list arrays????
	}//constructor to be used for creating profiles for player
	Profiles(int a, int b, int c)
	{
		//some code that get's called and inserts values for stats for enemy profile
	}//constructor to be used for creating profiles for enemies

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

		private int health = 10; //declaring and initializing base stats, exp, and level
		private int defense = 3;
		private int damage = 5;
		private int experience = 0;
		private int level = 1;
		private int points = 3;
		
		
		
	public void stats() //modifying stats
	{

		String a = " "; //temp string variable for calling scan method to distribute stats
		
		System.out.println("Your current stats are: \nHealth: " + health + "\nDefense: " + defense + "\nDamage: " + damage);
		//System.out.println("You have " + points + " points to invest!");
		
		while (points > 0)
		{
			a = " Which stat would you like to invest in: Defense, Damage, or Health?";
		System.out.println("You have " + points + " points to invest! Which stat would you like to invest in: Defense, Damage, or Health?");
		a = Main.scan(a);
		
		switch(a) { //consider maybe using numbers instead here?
		
		case "defense" : //case start for Fight
		case "Defense" :	//case for fight
			System.out.println("You have selected to Defense: Now incrementing Defense!");
			defense++;
			points--;
			System.out.println("Your Defense is now: " + defense);
			break;
		case "health" : //case start for History
		case "Health" :	//case for History
			System.out.println("You have selected to Health: Now incrementing health!");
			health++;
			points--;
			System.out.println("Your Health is now: " + health);
			break;
		case "damage" : //case start for Exit
		case "Damage" :	//case for Exit
			System.out.println("You have selected to Damage: Now incrementing damage!");
			damage++;
			points--;
			System.out.println("Your Damage is now: " + damage);
			break;
		default: 		
			System.out.println("Incorrect entry, please enter a valid option: Defense, Damage, or Health");
		}//end switch
		}//end while
		//code to run to send back stats, can be called for all stats, just use code here to differentiate which stat
		//is being returned, either if's or recursive code

	}//end stats modifying method
	
	public int[] sendStats() //call this when looking for values of stats when battling
	{
		int[] stats = {health, damage, defense}; //sets stats into an array
		return stats;
		//return stats
	}
	
	
}
