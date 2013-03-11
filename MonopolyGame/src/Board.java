/////////////////////////////////////////////
//                                         //
//               Board.java                //
//                                         //
// Board class, held by the game class,    //
// Holds the squares and the pieces.       //
//                                         //
/////////////////////////////////////////////


import java.awt.Color;


public class Board {
	private Piece[] pieces;																//Holds the pieces
	private int pieceCount;																//Holds the # of pieces
	
	private BoardSquare[] squares;														//Holds the squares
	private int squareCount;															//Holds the # of squares
	private MonopolyGame game;
	
	public Board(int playerAmount, MonopolyGame game)														//Board Constructor
	{
		this.game = game;
		squareCount=24;																	//Square amount
		squares = new BoardSquare[squareCount];											//Initialise the square array
		for(int i=0;i<squareCount;i++)													//For each space
		{
			String squareName;
			if(i==0)
			{
				squareName="Start";
				squares[i] = new StartSquare(squareName,i);	
			}
			else if(i==2)
			{
				squareName="Electricity";
				squares[i] = new ElectricitySquare(squareName,i);
			}
			else if(i==14)
			{
				squareName="Water";
				squares[i] = new WaterSquare(squareName,i);
			}
			else 
			{
				squareName="Square #"+Integer.toString(i);
				squares[i] = new PropertySquare(squareName,i,(5+i)*10,25,Color.BLUE);									//Fill it with a square
			}
		}
		pieceCount=playerAmount;
		pieces = new Piece[pieceCount];													//Initialise Piece array
		for(int i=0;i<pieceCount;i++)													//For each piece
		{
			pieces[i] = new Piece("Piece #"+Integer.toString(i),i);						//Initialise with a name and an ID
		}
	}
	
	public int assignPiece()															//Functions for piece assignment
	{
		for(int i=0;i<pieceCount;i++)
		{
			if(pieces[i].getPosition()==-1)
			{
				pieces[i].setPosition(0);
				return i;
			}
		}
		return -1;
	}
	public int movePiece(int pieceID, int amount)										//Functions for moving a piece
	{
		pieces[pieceID].incrementPosition(amount, squareCount);
		return pieces[pieceID].getPosition();
	}
	
	public String getPosition(int pieceID)												//Function for getting a pieces position
	{
		return squares[pieces[pieceID].getPosition()].getName();
	}
	
	public int getPositionInt(int pieceID)												//Function for getting a pieces position
	{
		return pieces[pieceID].getPosition();
	}
	
	public String landedOn(int pieceID, Player player)
	{
		return squares[pieces[pieceID].getPosition()].landedOn(player, this, game);
	}
	
}
