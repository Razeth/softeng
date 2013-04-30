/////////////////////////////////////////////
//                                         //
//             CardSquare.java             //
//                                         //
// Card Square class, held by board class, //
// draws cards when landed on.             //
//                                         //
/////////////////////////////////////////////


import java.awt.Color;

import javax.swing.JOptionPane;

public class CardSquare extends BoardSquare {																			//Card Square
	int pile=0;
	public CardSquare(String sqName, int sqPosition, int pile)															//Square Constructor
	{
		this.sqName=sqName;																								//Set the name
		this.sqPosition=sqPosition;																						//Set the position
		this.pile=pile;																									//Set which pile this square uses
	}
	
	public String landedOn(Player player, Board board)																	//When landed on
	{
		return board.drawCardFromPile(pile,player);																		//Draw a card, do it's effect, return string to UI
	}
}
