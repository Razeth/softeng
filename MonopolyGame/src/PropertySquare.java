import java.awt.Color;

import javax.swing.JOptionPane;

public class PropertySquare extends BoardSquare {
	public PropertySquare(String sqName, int sqPosition, int cost, int rent, Color colour, String colourString)			//Square Constructor
	{
		this.sqName=sqName;																								//Set the name
		this.sqPosition=sqPosition;																						//Set the position
		this.cost=cost;
		this.rent=rent;
		this.colour=colour;
		this.colourString = colourString;
	}
	
	public String landedOn(Player player, Board board)
	{
		if(owner==null)																//This square is not owned
		{
			//For now, force the player to own the square!
			if(player.getMoney()>=this.cost)
			{
				int buy = JOptionPane.showConfirmDialog(null, this.getName()+"\n\r------------\n\r"+this.colourString+"\n\rCost:"+this.cost+"\n\rRent:"+this.rent+"\n\r \n\rWould you like to purchase "+this.getName()+"?", player.getName(), JOptionPane.YES_NO_OPTION);
				if(buy==JOptionPane.YES_OPTION)
				{
					player.subMoney(this.cost);
					setOwner(player);
					return player.getName()+" landed on "+this.sqName+" and purchased it for �"+this.cost+"!\n\r\n\r";
				}
			}
		}
		else if(owner!=player)
		{
			//If a different player owns it.
			if(owner!=null)
			{
				//Check if the owner of this board colour owns the rest..
				int tempRent = rent;
				if(board.checkSet(owner,colour)) tempRent*=2;
				player.subMoney(tempRent);
				owner.addMoney(tempRent);
				return player.getName()+" landed on "+owner.getName()+"'s "+this.sqName+"!\n\r"+player.getName()+" pays them �"+this.rent+"!\n\r\n\r";
			}
		}
		return player.getName()+" landed on "+this.sqName+"!\n\r\n\r";
	}
}
