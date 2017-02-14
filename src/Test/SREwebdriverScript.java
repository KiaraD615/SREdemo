package Test;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SREwebdriverScript {
	WebDriver driver=new ChromeDriver();
	JavascriptExecutor js; 
	//WebElement table = driver.findElement(By.id("table")); 


public void open() {
driver.navigate().to("C:\\Users\\keesh\\Desktop\\apps\\index.html");

}


public String getTitle() throws IOException {
	String title=driver.getTitle().toString();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	System.out.println(title+" page fully loaded");
	
	return title;
}

public int colCntChk(){
	int col_count=0;
	WebElement table = driver.findElement(By.id("table")); 
	List<WebElement> allCols = table.findElements(By.tagName("th")); 
	for (WebElement col : allCols) { 
		col_count++;	}
System.out.println("column count= "+col_count);
return col_count;
}

public boolean valueRangechk() throws StaleElementReferenceException{
	boolean isInRange = false;
		WebElement table = driver.findElement(By.id("table")); 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 
 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    for (WebElement cell : cells) { 
		    	String cellValue=cell.getText().toString();
		    if(cellValue.matches(".*\\d+.*")){
		    	if (cellValue.contentEquals("1") || (cellValue.contentEquals("2") || (cellValue.contentEquals("3") || (cellValue.contentEquals("4") || (cellValue.contentEquals("5"))))))
		    	{
		    		System.out.println(cellValue+" value IS in range");
		    		isInRange=true;
		    	}
		    	else if (!(cellValue.contentEquals("1")) && (!(cellValue.contentEquals("2")) && (!(cellValue.contentEquals("3")) && (!(cellValue.contentEquals("4")) && (!(cellValue.contentEquals("5")))))))
		    	{
			    	isInRange= false;
		    	System.out.println(cellValue+" Value is NOT in range");
		    											}
		    								 }
		    							}
									}  
		return isInRange; 									}


public boolean noNullchk(){
	
	boolean isAnyNull = false;
	WebElement table = driver.findElement(By.id("table")); 
	List<WebElement> allRows = table.findElements(By.tagName("tr")); 

	// And iterate over them, getting the cells 
	for (WebElement row : allRows) { 
	    List<WebElement> cells = row.findElements(By.tagName("td")); 

	    // Check the contents of each cell
	    for (WebElement cell : cells) { 
	    	String cellValue=cell.getText();
	    	if (cellValue.isEmpty() || (cellValue.equals(null)) || (cellValue.contentEquals(""))){
	    		System.out.println("Table contains null value/s");
	    		isAnyNull=true;
	    	}
	    	else isAnyNull=false;
	      
	    }
	}return isAnyNull;
}	
	 

public void closeBrowser() {
	driver.close();
}


}