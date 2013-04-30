/////////////////////////////////////////////
//                                         //
//              CardPile.java              //
//                                         //
// Card pile class, base class for Card    //
// Piles, allows you to draw and use cards.//
//                                         //
/////////////////////////////////////////////


public class CardPile {
	
	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1..*
	 */
	
	protected Card[] Pile;											//The actual pile
	public int pilePosition=0;										//What position of the pile you're at
	
	public String drawCard(Player player, Board board)				//Allows user the draw a card
	{
		pilePosition+=1;											//Change the piles position
		if(pilePosition==5) pilePosition=0;							//If at the end, go back to the beginning
		return Pile[pilePosition].useCard(player, board);			//Use the card
	}
	
}
