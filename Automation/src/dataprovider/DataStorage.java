package dataprovider;

import org.testng.annotations.DataProvider;

public class DataStorage {
	@DataProvider
	public String[][] loginData() {
		String data[][]= {
				{"admin","admin"},
				{"ad","admin"},
				{"admin","ad"},
				{"ad","ad"}
		};
				
				return data;
			
	}

}
