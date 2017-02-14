package Test;
import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;


public class SREmethodsAbstracted {

	public static void main(String[] args) throws IOException, StaleElementReferenceException {
		SREwebdriverScript SRE = new SREwebdriverScript();
		SRE.open();
		SRE.getTitle();
		SRE.colCntChk();
		SRE.valueRangechk();
		SRE.noNullchk();
		
		SRE.closeBrowser();

	}

}
