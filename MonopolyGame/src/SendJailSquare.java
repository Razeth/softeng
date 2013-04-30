/////////////////////////////////////////////
//                                         //
//           SendJailSquare.java           //
//                                         //
// Send to Jail Square, held by the board  //
// class, sends players to jail.           //
//                                         //
/////////////////////////////////////////////

import java.awt.Color;

import javax.swing.JOptionPane;

public class SendJailSquare extends BoardSquare {
	public SendJailSquare(String sqName, int sqPosition)										//Square Constructor
	{
		this.sqName=sqName;																		//Set the name
		this.sqPosition=sqPosition;																//Set the position
	}
	
	public String landedOn(Player player, Board board)
	{
		player.sendToJail();																	//Tell player they are in jail
		board.sendPieceToJail(player.getPiece());												//Send them to jail
		return player.getName()+" landed on "+this.sqName+" and is sent to Jail for 3 turns!\n\r\n\r";
	}
}
