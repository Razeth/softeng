/////////////////////////////////////////////
//                                         //
//             CardPileA.java              //
//                                         //
// Card Pile class, inherits from Base     //
// class, holds Pile A cards.              //
//                                         //
/////////////////////////////////////////////

public class CardPileA extends CardPile{
	
	public CardPileA()
	{
		Pile = new Card[5];
		Pile[0] = new Card("Speeding Fine - £15!",0,15,"");
		Pile[1] = new Card("Bank pays you dividend - £50!",50,0,"");
		Pile[2] = new Card("Advance to Go!",0,0,"Go");
		Pile[3] = new Card("Pay School Fees - £150!",0,150,"");
		Pile[4] = new Card("GO TO JAIL!",0,0,"Jail");
	}
}