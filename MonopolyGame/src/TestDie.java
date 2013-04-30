/////////////////////////////////////////////
//                                         //
//              TestDie.java               //
//                                         //
// Test Die class, tests the die 10 times  // 
//                                         //
/////////////////////////////////////////////

public class TestDie {
	Die DieTest;
	
	public TestDie()
	{
		DieTest = new Die();
	}
	
	public String runTest()
	{
		String returnedString="";
		returnedString+="Die Test Class \n\r";
		returnedString+="Roll() \n\r";
		returnedString+="If working, should return 10 numbers between 1 and 6 \n\r";
		for(int i=0;i<10;i++)
		{
			returnedString+=DieTest.Roll()+"\n\r";
		}
		return returnedString;
	}
	
}
