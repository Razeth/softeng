/////////////////////////////////////////////
//                                         //
//               Board.java                //
//                                         //
// Board class, held by the game class,    //
// Holds the squares and the pieces.       //
//                                         //
/////////////////////////////////////////////


import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;


public class Board {
	private Piece[] pieces;																//Holds the pieces
	private int pieceCount;																//Holds the # of pieces
	
	private BoardSquare[] squares;														//Holds the squares
	private int squareCount;															//Holds the # of squares
	
	public Board(int playerAmount)														//Board Constructor
	{
		squareCount=24;																	//Square amount
		squares = new BoardSquare[squareCount];											//Initialise the square array
		String line="";
		String[] splitArray;
		File file = new File("board.txt");
		if(file.exists())
		{
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				try {
					int i=0;
					squares[i] = new StartSquare("Start",i);
					i=1;
					while((line = reader.readLine()) != null)
					{
						splitArray = line.split(",");
						switch(splitArray[4])
						{
						case "Purple":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.MAGENTA);
							break;
						case "Cyan":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.CYAN);
							break;
						case "Violet":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.PINK);
							break;
						case "Orange":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.ORANGE);
							break;
						case "Red":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.RED);
							break;
						case "Yellow":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.YELLOW);
							break;
						case "Green":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.GREEN);
							break;
						case "Grey":
							squares[i] = new PropertySquare(splitArray[0],i,Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.GRAY);
							break;
						case "Electricity":
							squares[i] = new ElectricitySquare(splitArray[0],i);
							break;
						case "Water":
							squares[i] = new WaterSquare(splitArray[0],i);
							break;
						case "Jail":
							squares[i] = new JailSquare(splitArray[0],i);
							break;
						case "Card":
							squares[i] = new CardSquare(splitArray[0],i);
							break;
						case "SendJail":
							squares[i] = new SendJailSquare(splitArray[0],i);
							break;
						case "Blank":
							squares[i] = new WaterSquare(splitArray[0],i);
							break;
						
						}
						System.out.println(splitArray[0]+" "+splitArray[3]+" "+splitArray[3]+" "+i);
						i+=1;
						
					}
				}
				catch (IOException e) {}
				try {reader.close();}
				catch (IOException e) {}
			}
			catch (FileNotFoundException e) {
				
			}
		
		
			//System.out.println(System.getProperty("user.dir"));
			//int i=0;
			//First, create the start square
		
			
		}
		else
		{
		
			for(int i=0;i<squareCount;i++)													//For each space
			{
				String squareName;
				if(i==0)
				{
					squareName="Start";
					squares[i] = new StartSquare(squareName,i);	
				}
				else
				{
					if(i==2)
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
			}
		}
		pieceCount=playerAmount;
		pieces = new Piece[pieceCount];													//Initialise Piece array
		for(int i=0;i<pieceCount;i++)													//For each piece
		{
			pieces[i] = new Piece("Piece #"+Integer.toString(i),i);						//Initialise with a name and an ID
		}
	}
	
	public int owns(Player player, String name)
	{
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].getName()==name&&squares[i].getOwner()==player) return 1;
		}
		return 0;
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
		System.out.println(pieces[pieceID].getPosition());
		String returnString = squares[pieces[pieceID].getPosition()].getName();
		return returnString;
	}
	
	public int getPositionInt(int pieceID)												//Function for getting a pieces position
	{
		return pieces[pieceID].getPosition();
	}
	
	public String landedOn(int pieceID, Player player)
	{
		return squares[pieces[pieceID].getPosition()].landedOn(player, this);
	}
	
}
