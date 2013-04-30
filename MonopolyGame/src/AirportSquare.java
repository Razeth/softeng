/////////////////////////////////////////////
//                                         //
//           AirportSquare.java            //
//                                         //
// AirportSquare class, held by the board  //
// class, teleports pieces around board.   //
//                                         //
/////////////////////////////////////////////

public class AirportSquare extends BoardSquare {																//Airport Square, extends BoardSquare
	public AirportSquare(String sqName, int sqPosition)															//Square Constructor
	{
		this.sqName=sqName;																						//Set the name
		this.sqPosition=sqPosition;																				//Set the position
	}
	
	public String landedOn(Player player, Board board)															//When a player lands on this plot
	{
		return board.airportFlyFunction(player);																//Run the airportFlyFunction ..function. Allow the player to pick a plot and go to said plot
	}
}