package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wdMethods.ProjectMethods;

public class FindLead extends ProjectMethods{
	static String firstLeadID="";
	static String firstLeadName="";
	
	
	public FindLead(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
		if(!verifyTitle("Find Leads | opentaps CRM")) {
			reportStep("This is not My Home Page", "FAIL");
		}		
	}
	//Enter the first name
	@FindBy(how=How.XPATH,using="(//*[@name='firstName'])[3]")
	private WebElement eleFirstname;

	public FindLead enterFirstName(String fname) {
		type(eleFirstname,fname);
		return this;
	}

	//Navigating to Phone tab

	@FindBy(how=How.XPATH,using="//span[text()='Phone']")
	private WebElement elePhoneTab;

	public FindLead clickPhoneTab() {
		click(elePhoneTab);
		return this;
	}

	//EnterPhone Number
	@FindBy(how=How.XPATH,using="//input[@name='phoneNumber']")
	private WebElement elePhoneNumber;

	public FindLead enterPhoneNumber(String phoneNumber) {
		type(elePhoneNumber,phoneNumber);
		return this;
	}

	//Click Find Leads
	@FindBy(how=How.XPATH, using="//button[text()='Find Leads']")
	private WebElement eleFindLeads;
	public FindLead clickFindLeadsButton()
	{
		click(eleFindLeads);
		return this;
	}

	//Select First lead using Lead ID
	@FindBy(how=How.XPATH,using ="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleFirstLeadID;
	public ViewLead clickFirstLeadID()
	{

		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(eleFirstLeadID));
		click(eleFirstLeadID);
		return new ViewLead(driver,test);
	}

	//Capture Lead ID
	@FindBy(how=How.XPATH,using ="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleCaptureFirstLeadID;
	public FindLead captureLeadID(){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(eleCaptureFirstLeadID));
		
		firstLeadID=getText(eleCaptureFirstLeadID);
		System.out.println(firstLeadID);
		return this;
	}

	//Enter the Captured ID
	@FindBy(how=How.NAME,using="id")
	private WebElement eleId;
	public FindLead enterCapturedID() {
		System.out.println(firstLeadID);
		type(eleId,firstLeadID);
		return this;
	}

	
	//Enter the captured merge ID
	
	public FindLead enterCapturedMergeID() {
		System.out.println(MergeLeads.firstMergeLeadID);
		type(eleId,MergeLeads.firstMergeLeadID);
		return this;
	}
	
	//Verify the error message
	@FindBy(how=How.CLASS_NAME,using ="x-paging-info")
	private WebElement eleErrorMessage;
	public FindLead verifyErrorMessage(String errorMessage)
	{

		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(eleErrorMessage));
		verifyExactText(eleErrorMessage, errorMessage);
		return this;
	}

	
	//Navigate to email tab
	
	@FindBy(how=How.XPATH,using="//span[text()='Email']")
	private WebElement eleEmailTab;

	public FindLead clickEmailTab() {
		click(eleEmailTab);
		return this;
	}

	//Enter email address
	@FindBy(how=How.NAME,using="emailAddress")
	private WebElement eleEmailAddress;

	public FindLead enterEmailAddress(String emailAddress) {
		type(eleEmailAddress,emailAddress);
		return this;
	}
	
	//Capture name of the first lead
	
	@FindBy(how=How.XPATH,using ="//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")
	private WebElement eleCaptureFirstLeadName;
	public FindLead captureLeadName(){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(eleCaptureFirstLeadName));
		
		firstLeadName=getText(eleCaptureFirstLeadName);
		System.out.println(firstLeadName);
		return this;
	}
}
