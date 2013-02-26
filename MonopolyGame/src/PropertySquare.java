public class PropertySquare extends BoardSquare {
	public PropertySquare(String sqName, int sqPosition)									//Square Constructor
	{
		this.sqName=sqName;																//Set the name
		this.sqPosition=sqPosition;														//Set the position
	}
	
	public String landedOn(Player player, Board board)
	{
		return player.getName()+" landed on "+this.sqName+"!\n\r\n\r";
	}
}
