package mutationTest.mutationTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class RandomProgramCodeTest {

	private RandomProgramCode randomProgramCode;
	@Before
	public void setUp(){
		
		randomProgramCode=new RandomProgramCode();
		
	}
	
	@Test
	public void Method1(){
	
		int actualResult=randomProgramCode.addtion(5, 5);
		int expectedResult=18;
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Method2(){
		
	}
}
