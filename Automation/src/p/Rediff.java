package p;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 

	       try {
	        	driver.get("https://money.rediff.com/gainers");

	            WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']")); //table xpath

	            List<WebElement> rows = table.findElements(By.tagName("tr")); //all rows of the table
	            
	            for (WebElement row : rows) {
	                
	                List<WebElement> columns = row.findElements(By.xpath(".//td | .//th")); //Get all column name
                    for(WebElement column:columns) {
                   System.out.print(column.getText() + "\t"); //print each coloumn name

                         }
                           System.out.println(); 
                           
                           
       	            List<WebElement> cells = row.findElements(By.tagName("td")); // Get all cells in the row
                   for (WebElement cell : cells) {   // Print each cell's text
	                    System.out.print(cell.getText() + "\t");
	                }
	                System.out.println();

	}
	          
	            }
	       finally {
              
                driver.quit();
}
	        
	}
}
