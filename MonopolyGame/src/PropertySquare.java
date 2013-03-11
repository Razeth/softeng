import java.awt.Color;

public class PropertySquare extends BoardSquare {
	public PropertySquare(String sqName, int sqPosition, int cost, int rent, Color colour)								//Square Constructor
	{
		this.sqName=sqName;																								//Set the name
		this.sqPosition=sqPosition;																						//Set the position
		this.cost=cost;
		this.rent=rent;
		this.colour=colour;
		this.playerID=-1;
	}
	
	public String landedOn(Player player, Board board, MonopolyGame game)
	{
		if(playerID==-1)																//This square is not owned
		{
			//For now, force the player to own the square!
			player.subMoney(this.cost);
			setOwner(player.getPiece());
			return player.getName()+" landed on "+this.sqName+" and purchased it for £"+this.cost+"!\n\r\n\r";
		}
		else if(playerID!=player.getPiece())
		{
			//If a different player owns it.
			Player owningPlayer = game.getPlayerFromPieceID(this.getOwner());
			if(owningPlayer!=null)
			{
				player.subMoney(rent);
				owningPlayer.addMoney(rent);
				return player.getName()+" landed on "+owningPlayer.getName()+"'s "+this.sqName+"!\n\r"+player.getName()+" pays them £"+this.rent+"!\n\r\n\r";
			}
		}
		return player.getName()+" landed on "+this.sqName+"!\n\r\n\r";
	}
}
