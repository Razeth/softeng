/////////////////////////////////////////////
//                                         //
//         ElectricitySquare.java          //
//                                         //
// Electricity Square class, held by board //
// class, utility.                         //
//                                         //
/////////////////////////////////////////////

import javax.swing.JOptionPane;

public class ElectricitySquare extends BoardSquare {
	public ElectricitySquare(String sqName, int sqPosition)																						//Square Constructor
	{
		this.sqName=sqName;																														//Set the name
		this.sqPosition=sqPosition;																												//Set the position
	}
	
	public String landedOn(Player player, Board board, MonopolyGame game)																		//When it's landed on
	{		
		if(owner==null)																															//This square is not owned
		{
			if(player.getMoney()>=this.cost)
			{																																	//Ask the player if they'd like to purchase it
				int buy = JOptionPane.showConfirmDialog(null, "Would you like to purchase "+this.getName()+" for £"+this.cost+"?", player.getName(), JOptionPane.YES_NO_OPTION);
				if(buy==JOptionPane.YES_OPTION)																									//If they say yes
				{
					player.subMoney(this.cost);																									//Charge them
					setOwner(player);																											//Make them the owner
					return player.getName()+" landed on "+this.sqName+" and purchased it for £"+this.cost+"!\n\r\n\r";							//Tell them they own it!
				}
			}
		}
		else if(owner!=player)																													//If someone else owns it however..
		{
			if(owner!=null)
			{
				rent = 5*player.readDice();																										//Charge them 5* dice roll
				if(board.owns(owner,"Water")==1) rent = 10*player.readDice();																	//Unless the same owner owns Water, then pay 10*
				player.subMoney(rent);																											//Charge player
				owner.addMoney(rent);																											//Pay owner
				return player.getName()+" landed on "+owner.getName()+"'s "+this.sqName+"!\n\r"+player.getName()+" pays them £"+this.rent+"!\n\r\n\r";
			}
		}
		return player.getName()+" landed on "+this.sqName+"!\n\r\n\r";
	}
}
