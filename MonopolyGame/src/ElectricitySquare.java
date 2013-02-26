public class ElectricitySquare extends BoardSquare {
	public ElectricitySquare(String sqName, int sqPosition)									//Square Constructor
	{
		this.sqName=sqName;																//Set the name
		this.sqPosition=sqPosition;														//Set the position
	}
	
	public String landedOn(Player player, Board board)
	{
		int moneyPaid=0;
		if((player.getMoney()/100)*10<=200) moneyPaid=200;
		else moneyPaid=(player.getMoney()/100)*10;
		player.subMoney(moneyPaid);
		return player.getName()+" landed on Electricity and paid out £"+moneyPaid+"!\n\r\n\r";
	}
}
