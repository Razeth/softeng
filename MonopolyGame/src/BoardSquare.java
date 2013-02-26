/////////////////////////////////////////////
//                                         //
//            BoardSquare.java             //
//                                         //
// BoardSquare class, held by the board    //
// class, to return position as string.    //
//                                         //
/////////////////////////////////////////////


public class BoardSquare {

	int sqPosition;																//Square position
	String sqName;																//Square name
	
	public int getPosition()															//Return the position
	{
		return sqPosition;
	}
	
	public String getName()																//Return the name
	{
		return sqName;
	}
	
	public String landedOn(Player player, Board board)
	{
		return "";
	}
}