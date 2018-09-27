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
import cucumber.api.java.en.When;


public class Junit {

		
	SREwebdriverScript SRE = new SREwebdriverScript();	
@Given("^Web page is loaded$")
@BeforeClass  
	public void openPage(){
		SRE.open();
		assertTrue (SRE.waitForOfferPage()); 
	//	SRE.closeBrowser();
	}


@When("^I have \\$(\\d+) dollars to offer$")
public void moneyToOffer(String amount)  {
SRE.enterOfferAmount(amount);
}


@Test
@When("^a \\$(\\d+) down payment$")
public void a_$_down_payment(String amount) {
    SRE.entercashDownAmount(amount);  
}

@Test
@When("^a \"([^\"]*)\" credit rating$")
public void a_credit_score(String rating)  {
    SRE.enterCreditRating(rating);
    
}

@Test
@Then("^I will be able to move to next steps$")
public void i_will_be_able_to_move_to_next_steps()  {
 SRE.nextSteps();  
}

@Test
@Then("^enter my zip code of (\\d+)$")
public void enter_my_zip_code(String zipcode)  {
  SRE.enterZip(zipcode);
}

@Test
@Then("^I will be able to continue and send progress$")
public void i_will_be_able_to() {
 SRE.sendProgress();  
}
/*
@Test
@Then("^enter my contact info$")
public void enter_my_contact_info() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
@Test
@Then("^confirm my pricing summary$")
public void confirm_my_pricing_summary() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
@Test
@Then("^send and view confirmation$")
public void send_and_view_confirmation() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


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

	
	*/
}
