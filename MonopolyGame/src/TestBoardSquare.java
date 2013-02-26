public class TestBoardSquare {
	BoardSquare BoardSquareTest;
	
	public TestBoardSquare()
	{
		BoardSquareTest = new PropertySquare("Test Square",0);
	}
	
	public String runTest()
	{
		String returnedString="";
		returnedString+="BoardSquare Test Class \n\r";
		returnedString+="getPosition() \n\r";
		returnedString+="If working, should return 0: \n\r";
		returnedString+=BoardSquareTest.getPosition()+"\n\r";
		returnedString+="\n\rgetName() \n\r";
		returnedString+="If working, should return Test Square: \n\r";
		returnedString+=BoardSquareTest.getName()+"\n\r";
		return returnedString;
	}
}
