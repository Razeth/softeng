/////////////////////////////////////////////
//                                         //
//                 Die.java                //
//                                         //
// Die class, held by the main class,      //
// Rolled for the player's turns.          //
//                                         //
/////////////////////////////////////////////

public class Die {
	public int Roll()
	{
		return 1 + (int)(Math.random() * ((6 - 1) + 1)); 								//Return a random number between 1 and 6
	}
}