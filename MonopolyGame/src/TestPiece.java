/////////////////////////////////////////////
//                                         //
//             TestPiece.java              //
//                                         //
// Test Piece class, tests the piece class // 
//                                         //
/////////////////////////////////////////////

public class TestPiece {
	Piece PieceTest;
	
	public TestPiece()
	{
		PieceTest = new Piece("Test Piece",0);
	}
	
	public String runTest()
	{
		String returnedString="";
		returnedString+="Piece Test Class \n\r";
		returnedString+="getpieceName() \n\r";
		returnedString+="If working, should return Test Piece \n\r";
		returnedString+=PieceTest.getpieceName()+"\n\r";
		returnedString+="\n\rgetPieceID() \n\r";
		returnedString+="If working, should return 0 \n\r";
		returnedString+=PieceTest.getPieceID()+"\n\r";
		returnedString+="\n\rgetPosition() \n\r";
		returnedString+="If working, should return -1 \n\r";
		returnedString+=PieceTest.getPosition()+"\n\r";
		returnedString+="\n\rsetPosition() \n\r";
		returnedString+="If working, should loop the position from 0 to 9 then getPosition will return the value. \n\r";
		for(int i=0;i<10;i++)
		{
			PieceTest.setPosition(i);
			returnedString+=PieceTest.getPosition()+"\n\r";
		}
		returnedString+="\n\rincrementPosition() \n\r";
		returnedString+="If working, should set max movement to 3, looping between 0, 1 and 2 \n\r";
		PieceTest.setPosition(1);
		for(int i=0;i<10;i++)
		{
			PieceTest.incrementPosition(1, 3);
			returnedString+=PieceTest.getPosition()+"\n\r";
		}
		
		return returnedString;
	}
}
