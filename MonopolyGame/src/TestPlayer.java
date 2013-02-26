public class TestPlayer {
	Player PlayerTest;
	
	public TestPlayer()
	{
		PlayerTest = new Player("Test Player");
	}
	
	public String runTest()
	{
		String returnedString="";
		
		returnedString+="Player Test Class \n\r";
		returnedString+="setPiece() \n\r";
		returnedString+="If working, should set Player's piece to 2 \n\r";
		PlayerTest.setPiece(2);
		returnedString+=PlayerTest.getPiece()+"\n\r";
		returnedString+="\n\raddMoney() \n\r";
		returnedString+="If working, should add 500 making the Player's money 1000. \n\r";
		PlayerTest.addMoney(500);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		returnedString+="\n\rsubMoney() \n\r";
		returnedString+="If working, should subtract 500 making the Player's money 500. \n\r";
		PlayerTest.subMoney(500);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		
		returnedString+="\n\rgetName() \n\r";
		returnedString+="If working, should return Test Player. \n\r";
		returnedString+=PlayerTest.getName()+"\n\r";
		
		
		return returnedString;
	}
	
}
