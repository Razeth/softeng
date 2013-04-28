import java.awt.Color;

import javax.swing.JOptionPane;

public class SendJailSquare extends BoardSquare {
	public SendJailSquare(String sqName, int sqPosition)										//Square Constructor
	{
		this.sqName=sqName;																								//Set the name
		this.sqPosition=sqPosition;																						//Set the position
	}
	
	public String landedOn(Player player, Board board)
	{
		/*if(owner==null)																//This square is not owned
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
		}*/
		player.sendToJail();
		board.sendPieceToJail(player.getPiece());
		return player.getName()+" landed on "+this.sqName+" and is sent to Jail for 3 turns!\n\r\n\r";
	}
}
