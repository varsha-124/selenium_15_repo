package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataStorageDemowebshop {
	@DataProvider
	public String[][] dataStorage() {
		String data[][]= {
				{"abhi1234@gmail.com","abhi@1234"},
				{"tom@gmail.com","abhi@1234"},
				{"abhi12341@gmail.com","tom@1234"},
				{"tom@gmail.com","tom@1234"}
		};
		return data;
				
				
				
		}
		
	}

