package Test;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SREwebdriverScript {

	public  WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 750);

	JavascriptExecutor js; 
	public static By offerInput=By.xpath("//*[@id='finance-input-offer']");
	public static By cashDownInput=By.id("finance-cash-down");
	public static By creditRating=By.id("finance-credit-tier");
	public static By nextStepsButtn=By.id("send-my-offer");
	public static By zipInputbox=By.id("input-shopper-zip");
	public static By continueBttn=By.id("dr_update_zip_continue");
	public static By noThanksBttn=By.id("deal-summary-page-continue-link");
	public static By sendPrgressBttn=By.xpath ("//*[@id='deal_summary_page_send_button']");
	public static By dwnPymtTxtDisplay=By.id("dr-sp-payment-box-detail-down-payment");
	public static By LexusDemoBanner=By.xpath("/html/body/div[1]/div[2]/div[1]/div/h1/a/span");
	public static By offerFrame=By.xpath("//*[@id='mmd-frame-frame2']");
	public static By termsFrame=By.xpath ("//*[@id='mmd-frame-shopperplatform']");
	public static By financeTab=By.xpath("//*[@id='tab-finance']");
	public static By dealSummary=By.id("sp_lead_form_title");
	public String offerPage=("https://lexus.roimotors.com/new/LEXUS/2018-LEXUS-GS+350-9478ae060a0a00f93a13f68a2e7fb412.htm");  
	//public static By offerFrame=By.xpath("/html/body/noscript/text()");
	//WebElement table = driver.findElement(By.id("table")); 
  
    
public void open() {

    driver.get(offerPage);
   // driver.close();
   
}

public boolean waitForOfferPage() {
	
wait.until(ExpectedConditions.visibilityOfElementLocated(LexusDemoBanner));
WebElement myPage = driver.findElement(LexusDemoBanner); 
if (( myPage).isDisplayed()==true) {
System.out.println("Page loaded");
return true;}
else {
System.out.println("Page NOT loaded");
return false;}

}

public void enterOfferAmount(String amount){
	WebElement element = driver.findElement(offerFrame);
	((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('style')", element);
	driver.switchTo().frame( driver.findElement( offerFrame ));

System.out.println("Hidden attributes removed");

driver.findElement(offerInput).click();
driver.findElement(offerInput).clear();
driver.findElement(offerInput).sendKeys(amount);
}

public void entercashDownAmount(String amount){
driver.findElement(cashDownInput).click();
driver.findElement(cashDownInput).clear();
driver.findElement(cashDownInput).sendKeys(amount);

}
public void enterCreditRating(String tier){
Select dropdown = new Select(driver.findElement(creditRating));
dropdown.selectByVisibleText(tier);
System.out.println("offer info complete");
}

public void nextSteps(){
	driver.findElement(nextStepsButtn).click();
System.out.println("Headed to next step");
}

public void enterZip(String zip){
	driver.findElement(zipInputbox).click();
	driver.findElement(zipInputbox).clear();
	driver.findElement(zipInputbox).sendKeys(zip);
	wait.until(ExpectedConditions.elementToBeClickable(continueBttn));
System.out.println("Headed to Contact Info");
}

public void sendProgress(){
	driver.findElement(continueBttn).click();
	wait.until(ExpectedConditions.elementToBeClickable(termsFrame));
	driver.switchTo().frame( driver.findElement(termsFrame));
	wait.until(ExpectedConditions.elementToBeClickable(sendPrgressBttn));
	driver.findElement(sendPrgressBttn).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(dealSummary));
System.out.println("On Contact Page");
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