/////////////////////////////////////////////
//                                         //
//             TestPlayer.jav              //
//                                         //
// Test Player class, tests the player     //
// class                                   //
//                                         //
/////////////////////////////////////////////

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
		returnedString+="If working, should set Player's piece to 0, 1 and 2, using getPiece to return the values. \n\r";
		PlayerTest.setPiece(0);
		returnedString+=PlayerTest.getPiece()+"\n\r";
		PlayerTest.setPiece(1);
		returnedString+=PlayerTest.getPiece()+"\n\r";
		PlayerTest.setPiece(2);
		returnedString+=PlayerTest.getPiece()+"\n\r";
		returnedString+="\n\raddMoney() \n\r";
		returnedString+="If working, should add 250, 500, 750 and 1000 making the Player's money 4000. \n\r";
		PlayerTest.addMoney(250);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		PlayerTest.addMoney(500);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		PlayerTest.addMoney(750);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		PlayerTest.addMoney(1000);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		returnedString+="\n\rsubMoney() \n\r";
		returnedString+="If working, should subtract 250, 500, 750 and 1000 making the Player's money 1500. \n\r";
		PlayerTest.subMoney(250);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		PlayerTest.subMoney(500);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		PlayerTest.subMoney(750);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		PlayerTest.subMoney(1000);
		returnedString+=PlayerTest.getMoney()+"\n\r";
		
		returnedString+="\n\rgetName() \n\r";
		returnedString+="If working, should return Test Player. \n\r";
		returnedString+=PlayerTest.getName()+"\n\r";
		
		
		return returnedString;
	}
	
}
