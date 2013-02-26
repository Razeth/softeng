/////////////////////////////////////////////
//                                         //
//             MonopolyGame.java           //
//                                         //
// Contains the main class for the game,   //
// MonopolyGame.                           //
//                                         //
/////////////////////////////////////////////


import java.awt.BorderLayout;														//Import for swing layout
import javax.swing.*;																//Import for swing


public class MonopolyGame extends JFrame {											//Main class, extends JFrame for simplicity

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553477879303362641L;				//Auto generated serial UID
	/**
	 * @param args
	 */
	public JTextArea outputBox;														//Main output box of form
	public JScrollPane scrollPane;													//Pane to make output box scrollable
	public String enteredString="";													//Read string for Dialog Input
	
	//For the Game
	public Player[] players;														//Array for Players
	public int numberOfPlayers;														//Count for # of Players
	
	public int numberOfRounds;														//Amount of rounds for the game
	
	public Board gameBoard;															//Variable for the main Board
	
	public Die Die1;																//First Die
	public Die Die2;																//Second Die
	
	public MonopolyGame()															//MonopolyGame Constructor
	{
		outputBox = new JTextArea(20,60);											//Initialise the output box
		scrollPane = new JScrollPane(outputBox);									//Initialise the scroll pane to contain the output box
		outputBox.setEditable(false);												//Stop the user being able to edit the output
		getContentPane().add(scrollPane,BorderLayout.CENTER);						//Add the scroll pane to the main window
		pack();																		//Pack the form
		setTitle("Monopoly Game");													//Name the form
		setVisible(true);															//Show the form
	}
	
	
	
	public void setUpBoard()														//Function to initialise the board
	{
		gameBoard = new Board(numberOfPlayers);										//Initialise the board, containing enough pieces for each player
	}
	
	public void setUpPlayers()														//Function to initialise the players
	{
		String playerName="";
		int pieceID=0;
		players = new Player[numberOfPlayers];											//Create the array to hold the players
		for(int i=0;i<numberOfPlayers;i++)
		{
			playerName = JOptionPane.showInputDialog("What is this Player's name?");//Get the players name
			pieceID = gameBoard.assignPiece();										//Assign it a piece
			players[i]=new Player(playerName);										//Create the player with specified name
			players[i].setPiece(pieceID);											//Give it the piece
		}
	}
	
	public void takeTurns()															//Function to take turns
	{
		for(int player=0;player<numberOfPlayers;player++)								//For each player
		{
			int roll=6;
			while(roll==6)
			{
				int startingPosition = gameBoard.getPositionInt(players[player].getPiece());
				outputBox.append(players[player].getName()+"'s turn!\n\r");				//Announce start of turn
				roll = players[player].takeTurn(Die1, Die2);						//Roll the dice
				outputBox.append(players[player].getName()+" rolled a "+Integer.toString(roll)+"!\n\r");
																						//Announce the roll
				gameBoard.movePiece(players[player].getPiece(),roll);					//Move the piece
				if(gameBoard.getPositionInt(players[player].getPiece())<startingPosition&&gameBoard.getPositionInt(players[player].getPiece())!=0) //Then they must have passed Start..
				{
					players[player].addMoney(500);
					outputBox.append(players[player].getName()+" passed Start and got an extra £500!\n\r");
				}
				outputBox.append(gameBoard.landedOn(players[player].getPiece(),players[player]));
				if(roll==6) outputBox.append(players[player].getName()+" takes another turn!\n\r\n\r");
				else outputBox.append(players[player].getName()+" currently has £"+players[player].getMoney()+"!\n\r\n\r");
			}
																					//Announce the updated position
		}
	}
	
	private static void runGame()													//Function to run the game
	{
		MonopolyGame newGame = new MonopolyGame();									//Initialise the game
		//newGame.setOpacity(1.0f);
		newGame.pack();																//Re-Pack the game
		newGame.setVisible(true);													//Set it to visible
		newGame.Die1 = new Die();													//Initialise the dice
		newGame.Die2 = new Die();
		newGame.enteredString = JOptionPane.showInputDialog("How many players would you like?","2");
																					//Find out # of players
		if(newGame.enteredString.equals("")||newGame.enteredString==null) System.exit(0);
																					//If they cancel, end the program
		else
		{
			newGame.numberOfPlayers = Integer.parseInt(newGame.enteredString);			//Parse to an int
			newGame.setUpBoard();													//Set up the board
			newGame.setUpPlayers();													//Set up the players
		
			for(int i=0;i<newGame.numberOfPlayers;i++)									//For each player
			{
				newGame.outputBox.append(newGame.players[i].getName()+" - Piece #"+Integer.toString(newGame.players[i].getPiece())+"\n\r");
																					//Announce player to piece
			}
			
			
			newGame.enteredString = JOptionPane.showInputDialog("How many rounds would you like?","20");
																					//Find out # of rounds
			if(newGame.enteredString.equals("")||newGame.enteredString==null) System.exit(0);
																					//If they cancel, end
			else
			{
				newGame.numberOfRounds = Integer.parseInt(newGame.enteredString);		//Parse to an int
				//GAME BEGINS
				
				for(int round=0;round<newGame.numberOfRounds;round++)					//For each round
				{
					newGame.outputBox.append("\n\rSTART OF ROUND #"+Integer.toString(round+1)+"! \n\r");
																					//Announce the round
					newGame.takeTurns();											//Take the turns
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestBoard BoardTest = new TestBoard();
		TestBoardSquare BoardSquareTest = new TestBoardSquare();
		TestDie DieTest = new TestDie();
		TestPiece PieceTest = new TestPiece();
		TestPlayer PlayerTest = new TestPlayer();
		
		System.out.println(BoardTest.runTest());
		System.out.println(BoardSquareTest.runTest());
		System.out.println(DieTest.runTest());
		System.out.println(PieceTest.runTest());
		System.out.println(PlayerTest.runTest());
		
		SwingUtilities.invokeLater(new Runnable()									//Once all other computations are finished
		{
			public void run()
			{
				runGame();															//Run the game
			}
		}
		);
		
		

	}

}
