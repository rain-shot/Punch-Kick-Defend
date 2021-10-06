import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
/*May consider using a character creation mode to allow users to have multiple "builds"
 * they could then iterate through their list of characters to fulfill the "collection" structure requirement.
 * could also possibly make use of 4 pillars of OOP inheritance, polymorphism, encapsulation, and abstraction
 * may need to implement some sort of item system for that though we will see
 */
	static Profiles profile = new Profiles(); //creates profile object
		
	public static void main(String[] args)
{				
		String getSelection = " "; //variable for user input that will be used throughout program
		
		//do a character selection first, or creation if no unit already exists.

		profile.stats(); //calls stats method from Profiles to get stats onto profile object

		
	//next we need a "menu" so ask what the user wants to do, Fight, look at history, or exit program?

		while((!getSelection.equals("q")) && (!getSelection.equals("Q")))
		{
		getSelection = "What would you like to do? (F)ight, (H)istory <this views battle history>, or (Q)uit program"; //resets getSelection since code is restarting and the value will be changed from running process to completion
		System.out.println(getSelection);
		getSelection = scan(getSelection); //gets user selection in menu.
		
		//add case statement for that selection
		
		switch(getSelection.charAt(0)) {
		
		case 'f': //case start for Fight
		case 'F':	//case for fight
			battle();
			break;
		case 'h': //case start for History
		case 'H':	//case for History
			History.record();
			break;
		case 'q': //case start for Exit
		case 'Q':	//case for Exit
			System.out.println("You have selected to Exit: Now quiting program!");
			break;
		default: System.out.println("Incorrect input selected, please choose a letter in parenthesis to continue!");
		}//end switch
		}//end while loop
		
}//end main method

	
	  public static String scan(String s)
	  {
		  String temp = s;
		 s = scan.nextLine();
		  while(s.equals("")) //catches null entry or user pressing enter only
		  {
			  System.out.println("Invalid entry, blank entries are not allowed!" + temp);
			  s = scan.nextLine();
		  }
		 if(s.charAt(0) != 'q' && s.charAt(0) != 'Q') //need to change the logic here on why and when scan is called for how to close the scanner, but not when it isn't called
		 {
			 return s;
		 }else scan.close();
		 return s;
		 
	  }//end scanner method
	  
	 public static void battle()
	  {
		 Random rand = new Random();
		 attack atk = new attack();
		 react act = new react();
		 rest rest = new rest();
		 History history = new History();
		 int damage = 0;
		 
		 String[] aiMoves = {"Punch", "Kick", "Defend", "Dodge", "Rest"}; //sets a variable array that will be used for randomly choosing ai battle choice
		 String aiSelection = " "; //will hold the selection made at random for processing
		 String battleSelection = " "; //variable that holds players battle choices
		 int temp = 0; //temp variable to hold total value of stat points for generating enemy fighter
		 
			int pHealth = profile.sendStats()[0];
			int pDamage = profile.sendStats()[1];
			int pDefense = profile.sendStats()[2]; //sets player stats from profile
			int pMaxHealth = pHealth;
			
			System.out.println(pHealth);
			System.out.println(pDamage);
			System.out.println(pDefense);
			
			System.out.println(profile.getHealth()); //displays the same information as above, may be able to utilize this instead for less code bulk
			System.out.println(profile.getDamage());
			System.out.println(profile.getDefense());

			
			//profile.Profiles(1,2,3);//aiDefense, aiHealth, aiDamage);
			//will generate random stats for opponent based on player stats cumulative value for "fair fight"
			for (int i = 0; i < profile.sendStats().length; i++) //accumulates points total value and puts it into temp
			{
				temp += profile.sendStats()[i];
			}

			int aiHealth = rand.nextInt(temp+1);
			while(aiHealth == 0) //checks aiHealth for 0 value, currently it increments it to 1, but maybe consider redoing the code so it still comes up with a better "spread" of stats
			{
				aiHealth = rand.nextInt(temp+1);
			}
			temp -= aiHealth;
			int aiDefense = rand.nextInt(temp+1); //+1 needed since it's treated similar to an array and starts at 0
			while(aiDefense >= pDamage *2)
			{
				aiDefense = rand.nextInt(temp+1); //Set's aiDefense if it is more than 2X players damage
			}
			temp -= aiDefense; //subtracts value from temp to keep values consistent with player values
			int aiDamage = 7; //temp; //last remaining value of temp is set to aiDamage
			int aiMaxHealth = aiHealth;
			
			//stats are set, engage in battle code below
			
			//will need a loop with a switch statement, switch is to choose what action player wants to do.
			//loop to check if player health or aiHealth is 0 and if it is end the battle and call aftermath
			//will also need a bit of code to randomly choose an action from the enemy
			//battle calculations should be simple, punch uses damage stat, kick uses damage *2, damage is calculated
			//by doing defense - damage, and the remainder is removed from health.
			//if defense is too high then no damage is done (e.g. 15 defense vs a 7 attack)
			//may consider using an alternative method to call for damage calculations, pass in the variables
			//may need a second one for the AI, or maybe to use a class (this could be a great time to use overloading)
			

			
			while (pHealth > 0 && aiHealth > 0)
			{
			battleSelection = "What would you like to do? (P)unch, (K)ick, (D)efend, (E)vade, (R)est? "; //resets getSelection since code is restarting and the value will be changed from running process to completion
			System.out.println(battleSelection);
			battleSelection = scan(battleSelection); //gets user selection in menu.
			//add case statement for that selection
			aiSelection = aiMoves[rand.nextInt(5)]; //sets aiSelection to an option from aiMoves randomly
			//needs to have aiSelection before player selection for resolving code properly
			
			switch(battleSelection.charAt(0)) {
			
			case 'p': //case for punch selection
			case 'P':	//case for punch selection
				if(aiSelection.equals("Defend"))
				{
				damage = atk.Punch(pDamage, aiDefense); //player attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage/2;
				System.out.println("The enemy defended and you inflicted: " + damage / 2 + " points of damage to the enemy");
				}
				
				if(aiSelection.equals("Dodge"))
				{
				damage = atk.Punch(pDamage, aiDefense); //player attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage;
				System.out.println("The enemy tried to dodge but couldn't and you inflicted: " + damage + " points of damage to the enemy");
				}
				
				if(aiSelection.equals("Rest"))
				{
				damage = atk.Punch(pDamage, aiDefense); //player attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage;
				System.out.println("The enemy rested and recovered some health! You inflicted: " + damage + " points of damage to the enemy");
				}
				
				if(aiSelection.equals("Punch") || aiSelection.equals("Kick"))
				{
				damage = atk.Punch(pDamage, aiDefense); //player attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage;
				System.out.println("The enemy also chose to attack! You inflicted: " + damage + " points of damage to the enemy");
				}
				break;
				
			case 'k': //case for kick selection
			case 'K':	//case for kick selection
				if(aiSelection.equals("Defend"))
				{
				damage = atk.Kick(pDamage, aiDefense); //player attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage/2;
				System.out.println("The enemy defended and you inflicted: " + damage / 2 + " points of damage to the enemy");
				}
				
				if(aiSelection.equals("Dodge"))
				{
				System.out.println("The enemy dodged your kick! You did no points of damage to the enemy");
				}
				
				if(aiSelection.equals("Rest"))
				{
				damage = atk.Kick(pDamage, aiDefense); //player attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage;
				System.out.println("The enemy rested and recovered some health! You inflicted: " + damage + " points of damage to the enemy");
				}
				
				if(aiSelection.equals("Punch") || aiSelection.equals("Kick"))
				{
				damage = atk.Kick(pDamage, aiDefense); //player attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("You"); //checks for critical hit and modifies damage if there is a crit
				aiHealth -= damage;
				System.out.println("The enemy also chose to attack! You inflicted: " + damage + " points of damage to the enemy");
				}
				break;
				
			case 'd': //case for defend selection
			case 'D':	//case for defend selection

				//may not even need any code here, could probably just handle this in the enemy switch  for attack like I did for player selection.
				// probably just print out that you selected defend and will take less damage
				//same for evade and rest 
				System.out.println("You have chosen to defend and will take half damage for this turn!");
				break;
				
			case 'e': //case for evade selection
			case 'E':	//case for evade selection	

				System.out.println("You chose to dodge, if the enemy kicks you will avoid it!");
				break;

			case 'r': //case for rest selection
			case 'R':	//case for rest selection
				pHealth += rest.Rested(pMaxHealth, "You ");//calls rested method get's value and turns it into a percentage and multiplies by max health to get value recovered.
				if(pHealth > pMaxHealth) //sets players health to their max if it exceeded it as that wouldn't make sense.
				{
					pHealth = pMaxHealth;
				}
				break;
				
			default: System.out.println("Incorrect input selected, please choose a letter in parenthesis to continue! " + battleSelection);
			}
			
	
			switch(aiSelection) {
			case "Punch":
//				damage = atk.Punch(aiDamage, pDefense);
//				pHealth -= damage;
//				System.out.println("The enemy has punched you and inflicted: " + damage + ". You have " + pHealth + " health remaining!");
				
				
				
				if((battleSelection.charAt(0) == 'd') || (battleSelection.charAt(0) == 'D'))
				{
					damage = atk.Punch(aiDamage, pDefense); //ai attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
					damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
					pHealth -= damage/2;
					System.out.println("The enemy attacked and you defended, they inflicted: " + damage / 2 + " points of damage you!");
				}
				
				if((battleSelection.charAt(0) == 'e') || (battleSelection.charAt(0) == 'E'))
				{
				damage = atk.Punch(pDamage, aiDefense); //ai attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("You tried to dodge but couldn't and the enemy inflicted: " + damage + " points of damage to you");
				}
				
				if((battleSelection.charAt(0) == 'p') || (battleSelection.charAt(0) == 'P'))
				{
				damage = atk.Punch(aiDamage, pDefense); //ai attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("The enemy chose to attack! You received: " + damage + " points of damage to the enemy");
				}
				
				if((battleSelection.charAt(0) == 'k') || (battleSelection.charAt(0) == 'K'))
				{
				damage = atk.Punch(aiDamage, pDefense); //ai attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("The enemy chose to attack! You received: " + damage + " points of damage to the enemy");
				}
				
				if((battleSelection.charAt(0) == 'r') || (battleSelection.charAt(0) == 'R'))
				{
				damage = atk.Punch(aiDamage, pDefense); //ai attacks with punch, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("The enemy chose to attack! You received: " + damage + " points of damage to the enemy");
				}
				
				break;
				
			case "Kick":
//				damage = atk.Kick(aiDamage, pDefense);
//				pHealth -= damage;
//				System.out.println("The enemy has kicked! you and inflicted: " + damage + ". You have " + pHealth + " health remaining!");
				
				if((battleSelection.charAt(0) == 'd') || (battleSelection.charAt(0) == 'D'))
				{
					damage = atk.Kick(aiDamage, pDefense); //ai attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
					damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
					pHealth -= damage/2;
					System.out.println("The enemy attacked and you defended, they inflicted: " + damage / 2 + " points of damage you!");
				}
				
				if((battleSelection.charAt(0) == 'e') || (battleSelection.charAt(0) == 'E'))
				{
				System.out.println("The enemy tried to kick you, but you dodged it! You took no points of damage!");
				}
				
				if((battleSelection.charAt(0) == 'p') || (battleSelection.charAt(0) == 'P'))
				{
				damage = atk.Kick(aiDamage, pDefense); //ai attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("The enemy chose to attack! You received: " + damage + " points of damage to the enemy");
				}
				
				if((battleSelection.charAt(0) == 'k') || (battleSelection.charAt(0) == 'K'))
				{
				damage = atk.Kick(aiDamage, pDefense); //ai attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("The enemy chose to attack! You received: " + damage + " points of damage to the enemy");
				}
				
				if((battleSelection.charAt(0) == 'r') || (battleSelection.charAt(0) == 'R'))
				{
				damage = atk.Kick(aiDamage, pDefense); //ai attacks with kick, calls method for math to calculate in method then return value and subtracts it from aiHealth
				damage *= atk.criticalHit("Enemy"); //checks for critical hit and modifies damage if there is a crit
				pHealth -= damage;
				System.out.println("The enemy chose to attack! You received: " + damage + " points of damage to the enemy");
				}
				
				break;
				
			case "Dodge":
				//act.Dodge();
				break;
			case "Defend":
				//act.Defend();
				break;
			case "Rest":
				aiHealth += rest.Rested(aiMaxHealth, "Enemy ");//calls rested method get's value and turns it into a percentage and multiplies by max health to get value recovered.
				if(aiHealth > aiMaxHealth) //sets ai health to their max if it exceeded it as that wouldn't make sense.
				{
					aiHealth = aiMaxHealth;
				}
				break;
			}//end switch for aiSelection in battle
				System.out.println("Your remaining health is: " + pHealth); //update player on their health

			
			if(pHealth <= 0 && aiHealth > 0) //player loses
			{
				System.out.println("The battle has ended and you have lost!");
				history.aftermath("loss");
			}
			if(pHealth > 0 && aiHealth <= 0) //player wins
			{
				System.out.println("The battle has ended and you have won!");
				history.aftermath("win");
			}
			if(pHealth <= 0 && aiHealth <= 0) //fight ended in a tie
			{
				System.out.println("The battle has ended and it was a draw!");
				history.aftermath("tie");
			}
			
		}//end while loop for battle
	  }

//	 public String aftermath(String x)
//	 {
//		 //need a temp variable to pass in value of player health remaining
//		 //need a temp variable to pass in value of bot player health remaining
//		 if (profile.getHealth() =< 0 && aiHealth > 0) //check player health = 0 && bot player health > 0 = lose
//		 {
//			 result.add("L");
//		 } else if (profile.getHealth > 0 && aiHealth =< 0)
//		 {
//			 result.add("W");
//		 } else if (profile.getHealth =< 0 && aiHealth =< 0)
//		 {
//			 result.add("T");
//		 }
//		 return x;
	 
	 //result could be its own class with a constructor with string and int, and pass in the value from here and numOfBattles (for iterating the array position)
	
	 
}//end Main class
