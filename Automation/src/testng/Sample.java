package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Sample {//TestNG class
	@Test
	public void sample() {//Test case
		//test steps
		Reporter.log("welcome1",true);
	}
	
	@Test
	public void demo() {
		Reporter.log("welcome2",true);
	}
	
	@Test
	public void add() {
		Reporter.log("welcome3",true);
	}

}
