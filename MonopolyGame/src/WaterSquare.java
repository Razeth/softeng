import javax.swing.JOptionPane;

public class WaterSquare extends BoardSquare {
	public WaterSquare(String sqName, int sqPosition)									//Square Constructor
	{
		this.sqName=sqName;																//Set the name
		this.sqPosition=sqPosition;														//Set the position
	}
	
	public String landedOn(Player player, Board board, MonopolyGame game)
	{
		int moneyPaid=0;
		moneyPaid=5*player.readDice();
		if((player.getMoney()/100)*10<=200) moneyPaid=200;
		else moneyPaid=(player.getMoney()/100)*10;
		player.subMoney(moneyPaid);
		
		
		if(owner==null)																//This square is not owned
		{
			//For now, force the player to own the square!
			if(player.getMoney()>=this.cost)
			{
				int buy = JOptionPane.showConfirmDialog(null, "Would you like to purchase "+this.getName()+"?", player.getName(), JOptionPane.YES_NO_OPTION);
				if(buy==JOptionPane.YES_OPTION)
				{
					player.subMoney(this.cost);
					setOwner(player);
					return player.getName()+" landed on "+this.sqName+" and purchased it for £"+this.cost+"!\n\r\n\r";
				}
			}
		}
		else if(owner!=player)
		{
			//If a different player owns it.
			if(owner!=null)
			{
				rent = 5*player.readDice();
				if(board.owns(owner,"Electricity")==1) rent = 10*player.readDice();
				player.subMoney(rent);
				owner.addMoney(rent);
				return player.getName()+" landed on "+owner.getName()+"'s "+this.sqName+"!\n\r"+player.getName()+" pays them £"+this.rent+"!\n\r\n\r";
			}
		}
		return player.getName()+" landed on "+this.sqName+"!\n\r\n\r";
	}
}
