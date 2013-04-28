public class AirportSquare extends BoardSquare {
	int pile=0;
	public AirportSquare(String sqName, int sqPosition)															//Square Constructor
	{
		this.sqName=sqName;																								//Set the name
		this.sqPosition=sqPosition;																						//Set the position
	}
	
	public String landedOn(Player player, Board board)
	{
		return board.airportFlyFunction(player);
	}
}