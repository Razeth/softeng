/////////////////////////////////////////////
//                                         //
//            StartSquare.java             //
//                                         //
// Start Square, held by the board class,  //
// essentially, Go!                        //
//                                         //
/////////////////////////////////////////////

public class StartSquare extends BoardSquare {
	public StartSquare(String sqName, int sqPosition)									//Square Constructor
	{
		this.sqName=sqName;																//Set the name
		this.sqPosition=sqPosition;														//Set the position
	}
	
	public String landedOn(Player player, Board board, MonopolyGame game)				//If they land on it
	{
		player.addMoney(500);															//They haven't PASSED Go, but still counts, so give them money!
		return player.getName()+" landed on Start and got an extra £500!\n\r\n\r";
	}
}
