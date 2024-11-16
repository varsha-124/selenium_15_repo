package testng;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assig1 {
	@Test(priority=1,invocationCount=2)
	public void createAccount() {
		Reporter.log("Account created successfully",true);
		
	}
	
	@Test(priority=3)
	public void deleteAccount() {
		Reporter.log("Account deleted successfully",true);
	}
	
	@Test(priority=2,invocationCount=3,threadPoolSize=3)
	public void editAccount() {
		Reporter.log("Account updated successfully",true);
	}

}
