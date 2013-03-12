/////////////////////////////////////////////
//                                         //
//                Player.java              //
//                                         //
// Contains the player class for the game, //
// For names, holding score and gets/sets. //
//                                         //
/////////////////////////////////////////////

public class Player {
	
	private String playerName;														//Player's Name
	private int money;																//Player's Money
	private int piece;																//Players Piece ID
	private int roll;
	
	public Player()																	//Player Constructor
	{
		playerName = "Player";														//Set their name
		money=1500;																	//And money
	}
	
	public Player(String playerName)												//If a name is specified
	{
		this.playerName = playerName;	
		this.money=1500;                                                             //Set it
	}
	
	public Player(String playerName, int money)										//If money is as well
	{
		this.playerName = playerName;
		this.money = money;															//Sets the money
	}
	
	public void setPiece(int piece)													//Set the piece
	{
		this.piece = piece;
	}
	
	public void addMoney(int money)													//Add to the players money
	{
		this.money+=money;
	}
	
	public void subMoney(int money)													//Subtract the players money
	{
		this.money-=money;
	}
	
	public int getMoney()															//Return amount of money
	{
		return this.money;
	}
	public String getName()															//Return Player's Name
	{
		return this.playerName;
	}
	public int getPiece()															//Return Piece ID
	{
		return this.piece;
	}
	
	public int takeTurn(Die Die1, Die Die2)											//Players turn function
	{
		roll = Die1.Roll()+Die2.Roll();											//Roll the die
		return roll;																//Return the result
	}
	
	public int readDice()
	{
		return roll;
	}

}