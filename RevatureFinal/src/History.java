import java.util.ArrayList;

public class History extends Main{

	static ArrayList<String> result = new ArrayList<String>(); //will be used to track wins and losses, will need to call a method that adds code at the end of each battle that adds an entry and iterates
	int x = 1; //variable for iterating so record tracking makes sense
	
	//write some code here for battle history, maybe use a multidimensional listarray? 
	//to remember each battle and what was used each turn until victory. Make it search able?
	//maybe also include "perfect" wins where user takes no damage all round??
	
	//sort ideas, sort by quickest win, quickest loss (in terms of turns)
	//sort by wins, losses, draws/ties
	
	public void aftermath(String info)
	{

		
		switch(info)
		{
		case "loss": //track loss
			result.add("Loss");
				//result.add("Battle " + x + ": Loss");
				//x++;
				break;				
		case "win": //track win
			result.add("Win");
				//result.add("Battle " + x + ": Win ");
				//x++;
				break;
		case "tie": //track tie
			result.add("Tie");
				//result.add("Battle " + x + ": Tie ");
				//x++;
				break;
		}//end switch
	}
	
	static public void record()
	{
		for(int x = 0; x < result.size(); x++)
		{
			System.out.println("Battle " + (x+1) + ": " + result.get(x));
		}
		//code here for showing all battle results stored in arraylist
		//might need it to be a String type, not sure yet
	}
	
	//an idea is to count the number or items in the ArrayList that say win loss tie and display it at the end, maybe with a win loss percentage ratio?
}
