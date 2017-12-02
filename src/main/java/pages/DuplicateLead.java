package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class DuplicateLead extends ProjectMethods{
	
	public DuplicateLead(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
		if(!verifyTitle("Duplicate Lead | opentaps CRM")) {
			reportStep("This is not My Home Page", "FAIL");
		}		
	}
	
	@FindBy(how=How.NAME,using="submitButton")
	private WebElement eleDuplicateLeads;
	
	public ViewLead clickDuplicateLead_CreateLead() {
		click(eleDuplicateLeads);
		return new ViewLead(driver,test);
		
	}


}
