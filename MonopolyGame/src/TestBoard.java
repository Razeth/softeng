/////////////////////////////////////////////
//                                         //
//             TestBoard.java              //
//                                         //
// Test Board class, tests the board class //
//                                         //
/////////////////////////////////////////////


public class TestBoard {
	Board BoardToTest;
	
	public TestBoard()
	{
		BoardToTest = new Board(2);
	}
	
	public String runTest()
	{
		String returnedString = "";
		
		//If working should return 2 empty piece then -1;
		returnedString+="Board Test Class \n\rInitialised with 2 players \n\r";
		returnedString+="assignPiece() \n\r";
		returnedString+="If working, should return 0, 1 then -1: \n\r";
		returnedString+=BoardToTest.assignPiece()+"\n\r";
		returnedString+=BoardToTest.assignPiece()+"\n\r";
		returnedString+=BoardToTest.assignPiece()+"\n\r";
		returnedString+="\n\rmovePiece() \n\r";
		returnedString+="If working, should return 22, 23 then 0: \n\r";
		returnedString+=BoardToTest.movePiece(0,22)+"\n\r";
		returnedString+=BoardToTest.movePiece(0,1)+"\n\r";
		returnedString+=BoardToTest.movePiece(0,1)+"\n\r";
		returnedString+="\n\rgetPosition() \n\r";
		returnedString+="If working, should return the name of each Square: \n\r";
		for(int i=0;i<24;i++)
		{
			returnedString+=BoardToTest.getPosition(1)+"\n\r";
			BoardToTest.movePiece(1, 1);
		}
		return returnedString;
	}
}
