package Test;
import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Junit {

		
	SREwebdriverScript SRE = new SREwebdriverScript();	
@Given("^Web page is loaded$")
@BeforeClass
	public void openPage(){
		SRE.open();
		
	}
//Tests if the web page title is correct


@Test
@Then("^Check title$")
	public void titleChk() throws IOException{
	String title=SRE.getTitle();
	assertEquals(title,
            "Self-Eval Table");
	}

//Validates the column count
@Then("^check for columns$")
@Test
	public void columCntChk(){
	int colCount=9;
	int actualColcount=SRE.colCntChk();
		assertEquals(colCount,
				actualColcount);
		}

//Validates if ratings are within 1-5
@Then("^check for value range$")
@Test
	public void rangeChk(){
	boolean isInRange=SRE.valueRangechk();
	//some values are out of range so expected assert is false
	assertEquals(true,
			isInRange);
	}

//Validates whether there is a value for each cell
@Then("^check for nulls$")
@Test
	public void nullChk(){
		boolean isNull=SRE.noNullchk();
		assertEquals(false,
				isNull);
			
	}

//Validates the the tear down function works correctly 
@Then("^close the browser$")
@AfterClass
	public void closePage(){
		SRE.closeBrowser();
	}

	
	
}
