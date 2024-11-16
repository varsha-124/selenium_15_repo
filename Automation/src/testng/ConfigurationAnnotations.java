package testng;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigurationAnnotations {
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Before suite executed",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before test executed",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before class executed",true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("before mothod executed",true);
	}
	
	@Test
	public void demo() {
		Reporter.log("Test demo executed",true);
	}
	
	@Test
	public void sample() {
		Reporter.log("Test sample executed",true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("after method executed",true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("After class executed",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("after test executed",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("After suite executed",true);
	}

}
