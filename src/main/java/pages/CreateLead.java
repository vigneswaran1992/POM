package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods{

	public CreateLead(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
		if(!verifyTitle("Create Lead | opentaps CRM")) {
			reportStep("This is not My Create Lead Page", "FAIL");
		}		
	}

	@FindBy(how=How.ID,using="createLeadForm_companyName")
	private WebElement eleCompanyName;

	public CreateLead typeCompanyName(String cName) {
		type(eleCompanyName,cName);
		return this;
	}
	@FindBy(how=How.ID,using="createLeadForm_firstName")
	private WebElement eleFirstName;

	public CreateLead typeFirstName(String fName) {
		type(eleFirstName,fName);
		return this;
	}
	@FindBy(how=How.ID,using="createLeadForm_lastName")
	private WebElement eleLastName;

	public CreateLead typeLastName(String lName) {
		type(eleLastName,lName);
		return this;
	}

	@FindBy(how=How.ID,using="createLeadForm_primaryPhoneNumber")
	private WebElement elePhoneNumber;

	public CreateLead typePhoneNumber(String phoneNumber) {
		type(elePhoneNumber,phoneNumber);
		return this;
	}
	
	@FindBy(how=How.ID,using="createLeadForm_primaryEmail")
	private WebElement eleEmailAddress;

	public CreateLead typeEmailAddress(String emailAddress) {
		type(eleEmailAddress,emailAddress);
		return this;
	}
	@FindBy(how=How.CLASS_NAME,using="smallSubmit")
	private WebElement eleSubmit;

	public ViewLead clickSubmit()
	{
		click(eleSubmit);
		return new ViewLead(driver, test);

	}
}
