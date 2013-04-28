import java.awt.Color;

import javax.swing.JOptionPane;

public class CardSquare extends BoardSquare {
	int pile=0;
	public CardSquare(String sqName, int sqPosition, int pile)															//Square Constructor
	{
		this.sqName=sqName;																								//Set the name
		this.sqPosition=sqPosition;																						//Set the position
		this.pile=pile;
	}
	
	public String landedOn(Player player, Board board)
	{
		return board.drawCardFromPile(pile,player);
	}
}
