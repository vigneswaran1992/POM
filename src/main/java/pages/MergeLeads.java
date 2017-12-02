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

public class MergeLeads extends ProjectMethods{
	static String firstMergeLeadID;
	public MergeLeads(RemoteWebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);		
		if(!verifyTitle("Merge Leads | opentaps CRM")) {
			reportStep("This is not MergeLeads Page", "FAIL");
		}		
	}

	//Click on the first image loopup in the From lead
	@FindBy(how=How.XPATH,using="(//img[@alt='Lookup'])[1]")
	private WebElement eleFromLeadLookup;

	public MergeLeads clickFromLookup() {
		clickWithNoSnap(eleFromLeadLookup);
		return this;
	}

	//Click on the Second image loopup in the From lead
	@FindBy(how=How.XPATH,using="(//img[@alt='Lookup'])[2]")
	private WebElement eleToLeadLookup;

	public MergeLeads clickToLeadsLookup() {
		clickWithNoSnap(eleToLeadLookup);
		return this;
	}

	//Switch to window
	public MergeLeads switchToSearchWindow()
	{
		switchToWindow(1);
		return this;
	}
	//Search the lead id
	@FindBy(how=How.XPATH,using="(//input[contains(@id,'ext-gen')])[1]")
	private WebElement eleLeadID;
	public MergeLeads typeFirstLeadID(){
		type(eleLeadID,"10");
		return this;
	}

	//Search the lead id to Merge
	public MergeLeads typeSecondLeadID(String LeadID){
		type(eleLeadID,LeadID);
		return this;
	}

	//Switch to Default window
	public MergeLeads switchToDefaultWindow()
	{
		switchToWindow(0);
		return this;
	}

	//Click on Find leads in the window
	@FindBy(how=How.XPATH,using="//button[text()='Find Leads']")
	private WebElement eleWindowFindLeads;

	public MergeLeads clickWindowFindLeads() {
		clickWithNoSnap(eleWindowFindLeads);
		return this;
	}

	//Select the first lead in the window

	@FindBy(how=How.XPATH,using ="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleFirstLeadID;
	public MergeLeads clickFirstLeadID()
	{

		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(eleFirstLeadID));
		clickWithNoSnap(eleFirstLeadID);
		return this;
	}

	//Capture first lead id
	@FindBy(how=How.XPATH,using ="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
	private WebElement eleCaptureFirstLeadID;
	public MergeLeads captureLeadID(){
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(eleCaptureFirstLeadID));

		firstMergeLeadID=getText(eleCaptureFirstLeadID);
		System.out.println(firstMergeLeadID);
		return this;
	}


	@FindBy(how=How.CLASS_NAME,using="buttonDangerous")
	private WebElement eleMergeButton;
	public MergeLeads clickMergeButton(){

		click(eleMergeButton);
		return this;
	}

	public ViewLead acceptMergeAlert()
	{
		acceptAlert();
		return new ViewLead(driver, test);
	}

}
