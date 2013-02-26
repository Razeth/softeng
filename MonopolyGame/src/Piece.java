/////////////////////////////////////////////
//                                         //
//                Piece.java               //
//                                         //
// Piece class, held by the board class,   //
// Moves around the squares.               //
//                                         //
/////////////////////////////////////////////


public class Piece {
	private String pieceName;															//Piece Name
	private int pieceID;																//Piece ID
	private int position;																//Piece Position
	
	
	public Piece(String pieceName, int pieceID)											//Piece constructor
	{
		this.pieceName = pieceName;														//Set the name
		this.pieceID = pieceID;															//Set the ID
		position=-1;																	//Set it's position to -1 (easiest way to tell if it's taken)
	}
	
	
	public String getpieceName()														//Return the Piece name
	{
		return pieceName;
	}
	
	public int getPieceID()																//Return the Piece ID
	{
		return pieceID;
	}
	
	public int getPosition()															//Return the Piece Position
	{
		return position;
	}
	
	public void setPosition(int position)												//Set the pieces position
	{
		this.position = position;
	}
	
	public void incrementPosition(int position, int max)								//Increment it's position
	{
		this.position+=position;
		if(this.position>=max) this.position-=max;										//If over the max, subtract the max
	}
}
