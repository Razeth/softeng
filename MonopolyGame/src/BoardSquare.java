/////////////////////////////////////////////
//                                         //
//            BoardSquare.java             //
//                                         //
// BoardSquare class, held by the board    //
// class, to return position as string.    //
//                                         //
/////////////////////////////////////////////


import java.awt.Color;

public class BoardSquare {

	int sqPosition;																		//Square position
	Player owner;																		//Square owner
	String sqName;																		//Square name
	int cost;																			//Cost to purchase Square
	int rent;																			//Rent, the getRent function will return this if it does not return a more complex number
	Color colour;																		//Square Color, null if colour not required
	
	public int getPosition()															//Return the position
	{
		return sqPosition;
	}
	
	public String getName()																//Return the name
	{
		return sqName;
	}
	
	public void setOwner(Player owner)
	{
		this.owner=owner;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public Color getColor()
	{
		return colour;
	}
	
	public String landedOn(Player player, Board board)
	{
		return "";
	}
}