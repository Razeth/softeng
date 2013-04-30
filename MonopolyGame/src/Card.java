/////////////////////////////////////////////
//                                         //
//                Card.java                //
//                                         //
// Card class, held by the CardPile class, //
// holds card text, runs the cards         //
// functions.                              //
//                                         //
/////////////////////////////////////////////

public class Card {
	private String cardText;																			//String to hold the cards text
	private int addMoney=0;																				//If greater than 0, card adds money
	private int subMoney=0;																				//If greater than 0, card subtracts money
	private String teleport="";																			//If not blank, teleports user to specified board square
	
	public Card (String cardText, int addMoney, int subMoney, String teleport)							//Constructor
	{
		this.cardText = cardText;																		//Fill in variables
		this.addMoney = addMoney;
		this.subMoney = subMoney;
		this.teleport = teleport;
	}
	
	public String getText()																				//Function to get the cards text
	{
		return "----------------------------\n\r"+cardText+"\n\r----------------------------\n\r";		//Return the cards text, with lines top and bottom to border
	}
	
	public String useCard(Player player, Board board)													//Function called to use the card
	{
		if(addMoney>0)																					//If it adds money
		{
			player.addMoney(addMoney);
		}
		else if(subMoney>0)																				//If it subtracts money
		{
			player.subMoney(subMoney);
		}
		else if(teleport!="")																			//If it teleports you
		{
			if(teleport.equals("Jail")) player.sendToJail();											//(If to jail, tell the player class that they're in jail!)
			board.teleportToBoardPosition(player, teleport);
		}
		return getText();																				//Return the cards text!
	}
}
