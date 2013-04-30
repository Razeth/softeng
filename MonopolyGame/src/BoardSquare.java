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
	
	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1..*
	 */
	
	Player owner;																		//Square owner
	String sqName;																		//Square name
	int cost;																			//Cost to purchase Square
	int rent;																			//Rent, the getRent function will return this if it does not return a more complex number
	Color colour;																		//Square Color, null if colour not required
	String colourString;
	
	public int getPosition()															//Return the position
	{
		return sqPosition;
	}
	
	public String getName()																//Return the name
	{
		return sqName;
	}
	
	public void setOwner(Player owner)													//Function to set the owner
	{
		this.owner=owner;																//Make the player in the argument the square owner
	}
	
	public Player getOwner()															//Function to get the owner
	{
		return owner;																	//Return the owner
	}
	
	public Color getColor()																//Function to get the squares color
	{
		return colour;																	//Return it's color
	}
	
	public String getColorAsString()													//Function to get the squares color as a string
	{
		return colourString;															//Return the variable
	}
	
	public String landedOn(Player player, Board board)									//Function called when a player lands on that square
	{
		return "";																		//Return nothing, should never land on BoardSquare
	}
}