
public class react {

	//write some code here for dodge and defend actions
	
	public boolean Dodge()
	{
		
		//some code to change the value to true or false based on whether or not the enemy or user dodged
		return dodged;
	}
	
	
	public boolean Defend()
	{
		
		//some code to change the value to true or false based on whether the enemy or user selected defend
		
		/* Could just call this from the switch during battle and set the value to true
		 * and return it back to the call
		 * 
		 * e.g. switch for defend selected, calls defend, returns true, applies it to a damage
		 * calculation method
		 * 
		 * should reduce total damage by half
		 */
		return defended;
	}
}
