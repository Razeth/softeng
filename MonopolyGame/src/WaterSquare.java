public class WaterSquare extends BoardSquare {
	public WaterSquare(String sqName, int sqPosition)									//Square Constructor
	{
		this.sqName=sqName;																//Set the name
		this.sqPosition=sqPosition;														//Set the position
	}
	
	public String landedOn(Player player, Board board, MonopolyGame game)
	{
		int moneyPaid=75;
		player.subMoney(moneyPaid);
		return player.getName()+" landed on Water and paid out £"+moneyPaid+"!\n\r\n\r";
	}
}
