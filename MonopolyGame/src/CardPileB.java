/////////////////////////////////////////////
//                                         //
//             CardPileB.java              //
//                                         //
// Card Pile class, inherits from Base     //
// class, holds Pile B cards.              //
//                                         //
/////////////////////////////////////////////

public class CardPileB extends CardPile{
	
	public CardPileB()
	{
		Pile = new Card[5];
		Pile[0] = new Card("Bank error in your favour - £75!",75,0,"");
		Pile[1] = new Card("Doctors fees - £50!",0,50,"");
		Pile[2] = new Card("Income Tax refund - £20!",20,0,"");
		Pile[3] = new Card("Second Prize in a Beauty Contest - £100!",100,0,"");
		Pile[4] = new Card("GO TO JAIL!",0,0,"Jail");
	}
}