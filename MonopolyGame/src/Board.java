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

import javax.swing.JOptionPane;


public class Board {
	
	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1..*
	 */
	
	private Piece[] pieces;																//Holds the pieces
	private int pieceCount;																//Holds the # of pieces
	
	
	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1..*
	 */
	
	private BoardSquare[] squares;														//Holds the squares
	private int squareCount;															//Holds the # of squares
	
	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1
	 */
	
	private CardPileA CoincidencePile;													//Holds the first pile of cards, called Coincidence
	
	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1
	 */
	
	private CardPileB ProvidencePile;													//Holds the second pile, Providence
	
	public Board(int playerAmount)														//Board Constructor
	{
		CoincidencePile = new CardPileA();												//Initialise the CardPiles
		ProvidencePile = new CardPileB();
		squareCount=24;																	//Square amount
		squares = new BoardSquare[squareCount];											//Initialise the square array
		String line="";																	//Make a temporary String for reading lines
		String[] splitArray;															//And an array to split them with
		File file = new File("board.txt");												//Create a handle to the board.txt file
		if(file.exists())																//If it exists...
		{
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));		//Attempt to read from the file.
				try {
					int i=0;															//Then attempt to read each line
					while((line = reader.readLine()) != null)
					{
						splitArray = line.split(",");
						switch(splitArray[4])
						{
						case "Purple":													//From each line, attempt to make the squares! If it's a colour, it's a Property Square
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.MAGENTA, splitArray[4]);
							break;
						case "Cyan":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.CYAN, splitArray[4]);
							break;
						case "Violet":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.PINK, splitArray[4]);
							break;
						case "Orange":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.ORANGE, splitArray[4]);
							break;
						case "Red":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.RED, splitArray[4]);
							break;
						case "Yellow":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.YELLOW, splitArray[4]);
							break;
						case "Green":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.GREEN, splitArray[4]);
							break;
						case "Grey":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.GRAY, splitArray[4]);
							break;
						
						case "Start":													//If it's "Start", it's the start square
							squares[i] = new StartSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Airport":													//If it's "Airport", it's the airport square
							squares[i] = new AirportSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Electricity":												//If it's "Airport", it's the electricity square
							squares[i] = new ElectricitySquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Water":													//If it's "Water", it's the water square
							squares[i] = new WaterSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Jail":													//If it's "Jail", it's the jail square
							squares[i] = new JailSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Card":													//If it's "Card", it's the card square, determine which by the 3rd column
							squares[i] = new CardSquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]));
							break;
						case "SendJail":												//If it's "SendJail", it's the Go To Jail square
							squares[i] = new SendJailSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Blank":													//If it's "Blank", Then it's a problem... for now, put a Water Square to make it easier to debug later.
							squares[i] = new WaterSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						
						}
						System.out.println(splitArray[0]+" "+splitArray[3]+" "+splitArray[3]+" "+i);   //Print out results for debugging
						i+=1;
						
					}
				}
				catch (IOException e) {}																//Catch any IO errors reading the file produces
				try {reader.close();}																	//Attempt to close the reader
				catch (IOException e) {}																//Catch any IO errors closing the reader produces
			}
			catch (FileNotFoundException e) {															//Catch the error if the file is not found..
				
			}
		
		
			//System.out.println(System.getProperty("user.dir"));
			//int i=0;
			//First, create the start square
		
			
		}
		else																							//Else if board.txt ISN'T found
		{
		
			for(int i=0;i<squareCount;i++)																//For each space
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
						squares[i] = new PropertySquare(squareName,i,(5+i)*10,25,Color.BLUE, "Blue");	//Fill it with a square of either Property, Electricity or Water to test with.
					}
				}
			}
		}
		pieceCount=playerAmount;																		//Make enough pieces for all players
		pieces = new Piece[pieceCount];																	//Initialise Piece array
		for(int i=0;i<pieceCount;i++)																	//For each piece
		{
			pieces[i] = new Piece("Piece #"+Integer.toString(i),i);										//Initialise with a name and an ID
		}
	}
	
	public int owns(Player player, String name)															//Function to test ownership of a plot
	{
		for(int i=0;i<squareCount;i++)																	//For each plot
		{
			if(squares[i].getName()==name&&squares[i].getOwner()==player) return 1;						//If the name matches the argument and player owns it, return 1
		}
		return 0;																						//If the player owns no plot of that name, return 0
	}
	
	public int assignPiece()																			//Functions for piece assignment
	{
		for(int i=0;i<pieceCount;i++)																	//For each piece
		{
			if(pieces[i].getPosition()==-1)																//If piece isn't assigned, assign it and set it's position to on the board
			{
				pieces[i].setPosition(0);
				return i;
			}
		}
		return -1;																						//If there are no pieces left (somehow..) return -1
	}
	public int movePiece(int pieceID, int amount)														//Functions for moving a piece
	{
		pieces[pieceID].incrementPosition(amount, squareCount);											//Increment the position of the piece by the amount to move 
		return pieces[pieceID].getPosition();															//Return the new position
	}
	
	public void sendPieceToJail(int pieceID)															//Send the piece to the Jail square
	{
		pieces[pieceID].setPosition(getPositionOfBoardSquare("Jail"));									//Set the pieces position to the same as that of the Jail square
	}
	
	public String getPosition(int pieceID)																//Function for getting a pieces position
	{
		System.out.println(pieces[pieceID].getPosition());
		for(int i=0;i<squareCount;i++)																	//For each square
		{
			if(squares[i].getPosition()==pieces[pieceID].getPosition()) return squares[i].getName();	//If the piece is on that square, return the name of that square
		}
		return "Who Knows?";																			//Else, the piece is nowhere. Somehow.
	}
	
	public int getPositionOfBoardSquare(String name)													//Find a squares position on the board from its name
	{
		for(int i=0;i<squareCount;i++)																	//For each square
		{
			if(squares[i].getName()==name) return squares[i].getPosition();								//If it's name matches, return it's position
		}
		//If not found return -1
		return -1;																						//Else, there is no board square with that name on the board
	}
	
	public boolean checkSet(Player player, Color color)													//Checks if a player owns a set
	{
		for(int i=0;i<squareCount;i++)																	//For each square
		{
			if(squares[i] instanceof PropertySquare)													//If it's a Property Square
			{
				if(squares[i].getColor()==color)														//And the color is the colour we're looking for
				{
					if(squares[i].getOwner()!=player) return false;										//If the player DOESN'T own it, return false
				}
			}
		}
		return true;																					//Only returns true if player owns all squares of that colour.
	}
	
	public int getPositionInt(int pieceID)																//Function for getting a pieces position
	{
		return pieces[pieceID].getPosition();															//Return the pieces position as an int
	}
	
	public String landedOn(int pieceID, Player player)													//Called when a piece lands on a board square
	{
		for(int i=0;i<squareCount;i++)																	//For each square, if the piece is on that board square, call that squares landedOn function
		{
			if(squares[i].getPosition()==pieces[pieceID].getPosition()) return squares[i].landedOn(player, this);
		}
		return "Who knows?";																			//The piece landed.. off the board
	}
	
	public String drawCardFromPile(int Pile, Player player)												//Called when a piece needs a card from a pile
	{
		String returnString="";																			//The string to return to the UI
		if(Pile==1)  //Coincidence																		//If it's from Pile A
		{
			returnString=player.getName()+" landed on Coincidence!\n\r\n\r";							//Say they need a card from Pile A
			returnString+=CoincidencePile.drawCard(player, this);										//Draw a card from Pile A, do it's function.
		}
		if(Pile==2)  //Providence
		{
			returnString=player.getName()+" landed on Providence!\n\r\n\r";								//Else, Pile B
			returnString+=ProvidencePile.drawCard(player, this);										//Draw a card from Pile B
		}
		return returnString;																			//Send results to UI
	}
	
	public void teleportToBoardPosition(Player player, String s)										//Function to teleport board pieces to square names
	{
		pieces[player.getPiece()].setPosition(getPositionOfBoardSquare(s));								//Change it's position to that of the board square
	}
	
	public String airportFlyFunction(Player player)														//Function called when landing on airport square
	{
		String returnString=player.getName()+" landed on the Aiport Square!\n\r";						//Tell UI they landed on the Airport Square
		int optionCount=0;																				//Make an int to count the number of options
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].cost>10)																		//If it has a cost, then it is a property square!
			{
				optionCount++;																			//Only allow the player to teleport to property squares, less broken that way around!
			}
			
		}
		Object[] possibilities = new Object[optionCount];												//For each property square we counted.
		optionCount=0;
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].cost>10) //Then it is a property square!
			{
				possibilities[optionCount] = (Object)squares[i].getName();								//Add their name to the possibilities list
				optionCount++;
			}
			
		}
		String s = null;
		while(s==null)
		{
			s = (String)JOptionPane.showInputDialog(
                null,
                "Airport Square\n"
                + "Which space would you like to move to?",
                player.getName(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities, "Normanton Road");														//Show user a drop-down list, to pick from the collected property squares
		}
		teleportToBoardPosition(player,s);																//Teleport their piece to that property square
		returnString+=player.getName()+" moved to "+s+"!\n\r";											//Inform them they have teleported there
		return returnString;																			//Send string to UI
	}
	
}
