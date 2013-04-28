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

import javax.swing.JOptionPane;


public class Board {
	private Piece[] pieces;																//Holds the pieces
	private int pieceCount;																//Holds the # of pieces
	
	private BoardSquare[] squares;														//Holds the squares
	private int squareCount;															//Holds the # of squares
	private int pileAPosition=0;
	private int pileBPosition=0;
	
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
					while((line = reader.readLine()) != null)
					{
						splitArray = line.split(",");
						switch(splitArray[4])
						{
						case "Purple":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.MAGENTA);
							break;
						case "Cyan":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.CYAN);
							break;
						case "Violet":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.PINK);
							break;
						case "Orange":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.ORANGE);
							break;
						case "Red":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.RED);
							break;
						case "Yellow":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.YELLOW);
							break;
						case "Green":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.GREEN);
							break;
						case "Grey":
							squares[i] = new PropertySquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]),Integer.parseInt(splitArray[3]),Color.GRAY);
							break;
						
						case "Start":
							squares[i] = new StartSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Airport":
							squares[i] = new AirportSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Electricity":
							squares[i] = new ElectricitySquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Water":
							squares[i] = new WaterSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Jail":
							squares[i] = new JailSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Card":
							squares[i] = new CardSquare(splitArray[0],Integer.parseInt(splitArray[1]),Integer.parseInt(splitArray[2]));
							break;
						case "SendJail":
							squares[i] = new SendJailSquare(splitArray[0],Integer.parseInt(splitArray[1]));
							break;
						case "Blank":
							squares[i] = new WaterSquare(splitArray[0],Integer.parseInt(splitArray[1]));
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
	
	public void sendPieceToJail(int pieceID)
	{
		pieces[pieceID].setPosition(getPositionOfBoardSquare("Jail"));
	}
	
	public String getPosition(int pieceID)												//Function for getting a pieces position
	{
		System.out.println(pieces[pieceID].getPosition());
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].getPosition()==pieces[pieceID].getPosition()) return squares[i].getName();
		}
		return "Who Knows?";
	}
	
	public int getPositionOfBoardSquare(String name)
	{
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].getName()==name) return squares[i].getPosition();
		}
		//If not found return -1
		return -1;
	}
	
	public boolean checkSet(Player player, Color color)
	{
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i] instanceof PropertySquare)
			{
				if(squares[i].getColor()==color)
				{
					if(squares[i].getOwner()!=player) return false;
				}
			}
		}
		return true;
	}
	
	public int getPositionInt(int pieceID)												//Function for getting a pieces position
	{
		return pieces[pieceID].getPosition();
	}
	
	public String landedOn(int pieceID, Player player)
	{
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].getPosition()==pieces[pieceID].getPosition()) return squares[i].landedOn(player, this);
		}
		return "Who knows?";
	}
	
	public String drawCardFromPile(int Pile, Player player)
	{
		String returnString="";
		if(Pile==1)  //Coincidence
		{
			returnString=player.getName()+" landed on Coincidence!\n\r\n\r";
			switch(pileAPosition)
			{
				case 0:
					returnString+= "----------------------------\n\r";
					returnString+= "Speeding Fine - £15!\n\r";
					returnString+= "----------------------------\n\r";
					player.subMoney(15);
					break;
				case 1:
					returnString+= "----------------------------\n\r";
					returnString+= "Bank pays you dividend - £50!\n\r";
					returnString+= "----------------------------\n\r";
					player.addMoney(50);
					break;
				case 2:
					returnString+= "----------------------------\n\r";
					returnString+= "Advance to Go!\n\r";
					returnString+= "----------------------------\n\r";
					pieces[player.getPiece()].setPosition(this.getPositionOfBoardSquare("Go"));
					break;
				case 3:
					returnString+= "----------------------------\n\r";
					returnString+= "Pay School Fees - £150!\n\r";
					returnString+= "----------------------------\n\r";
					player.subMoney(150);
					break;
				case 4:
					returnString+= "----------------------------\n\r";
					returnString+= "GO TO JAIL!\n\r";
					returnString+= "----------------------------\n\r";
					this.sendPieceToJail(player.getPiece());
					player.sendToJail();
					pileAPosition=-1;
					break;
			}
			pileAPosition+=1;
		}
		if(Pile==2)  //Providence
		{
			returnString=player.getName()+" landed on Providence!\n\r\n\r";
			switch(pileBPosition)
			{
				case 0:
					returnString+= "----------------------------\n\r";
					returnString+= "Bank error in your favour - £75!\n\r";
					returnString+= "----------------------------\n\r";
					player.addMoney(75);
					break;
				case 1:
					returnString+= "----------------------------\n\r";
					returnString+= "Doctors fees - £50!\n\r";
					returnString+= "----------------------------\n\r";
					player.subMoney(50);
					break;
				case 2:
					returnString+= "----------------------------\n\r";
					returnString+= "Income Tax refund - £20!\n\r";
					returnString+= "----------------------------\n\r";
					player.addMoney(20);
					break;
				case 3:
					returnString+= "----------------------------\n\r";
					returnString+= "Second Prize in a Beauty Contest - £100!\n\r";
					returnString+= "----------------------------\n\r";
					player.addMoney(100);
					break;
				case 4:
					returnString+= "----------------------------\n\r";
					returnString+= "GO TO JAIL!\n\r";
					returnString+= "----------------------------\n\r";
					this.sendPieceToJail(player.getPiece());
					player.sendToJail();
					pileBPosition=-1;
					break;
			}
			pileBPosition+=1;
		}
		return returnString;
	}
	
	public String airportFlyFunction(Player player)
	{
		String returnString=player.getName()+" landed on the Aiport Square!\n\r";
		int optionCount=0;
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].cost>10) //Then it is a property square!
			{
				optionCount++;
			}
			
		}
		Object[] possibilities = new Object[optionCount];
		optionCount=0;
		for(int i=0;i<squareCount;i++)
		{
			if(squares[i].cost>10) //Then it is a property square!
			{
				possibilities[optionCount] = (Object)squares[i].getName();
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
                possibilities, "Normanton Road");
		}
		pieces[player.getPiece()].setPosition(getPositionOfBoardSquare(s));
		returnString+=player.getName()+" moved to "+s+"!\n\r";
		return returnString;
	}
	
}
