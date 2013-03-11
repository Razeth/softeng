public class StartSquare extends BoardSquare {
	public StartSquare(String sqName, int sqPosition)									//Square Constructor
	{
		this.sqName=sqName;																//Set the name
		this.sqPosition=sqPosition;														//Set the position
	}
	
	public String landedOn(Player player, Board board, MonopolyGame game)
	{
		player.addMoney(500);
		return player.getName()+" landed on Start and got an extra £500!\n\r\n\r";
	}
}
