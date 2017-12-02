package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class ViewLead extends ProjectMethods{

	public ViewLead(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
		if(!verifyTitle("View Lead | opentaps CRM")) {
			reportStep("This is not My View Lead Page", "FAIL");
		}		
	}
	//Verify firstName
	@FindBy(how=How.ID,using="viewLead_firstName_sp")
	private WebElement eleFirstName;

	public ViewLead verifyFirstName(String fName)
	{
		verifyExactText(eleFirstName, fName);
		return this;

	}
	//Edit Lead
	@FindBy(how=How.XPATH,using="//a[text()='Edit']")
	private WebElement eleEdit;

	public EditLead clickEdit()
	{
		click(eleEdit);
		return new EditLead(driver, test);
	}

	//Update Button
	@FindBy(how=How.ID,using="viewLead_companyName_sp")
	private WebElement eleCompanyName;
	public ViewLead confirmUpdate(String newCompanyName){
		verifyPartialText(eleCompanyName, newCompanyName);
		return this;
	}

	//delete button
	@FindBy(how=How.LINK_TEXT,using="Delete")
	private WebElement eleDelete;
	//click Delete
	public MyLeads clickDelete(){
		click(eleDelete);
		return new MyLeads(driver, test);

	}
	
	//click Duplicate lead
	@FindBy(how=How.LINK_TEXT,using="Duplicate Lead")
	private WebElement eleDuplicateButton;
	//click Delete
	public DuplicateLead clickDuplicate(){
		click(eleDuplicateButton);
		return new DuplicateLead(driver, test);

	}

	//Verify duplicate firstName

	public ViewLead verifyDuplicateFirstName()
	{
		verifyExactText(eleFirstName, FindLead.firstLeadName);
		return this;

	}
	
	//Click Find Leads
	
	@FindBy(how=How.LINK_TEXT,using="Find Leads")
	private WebElement eleFindLeads;
	public FindLead clickFindLeads(){
		
		click(eleFindLeads);
		return new FindLead(driver,test);
	}
}