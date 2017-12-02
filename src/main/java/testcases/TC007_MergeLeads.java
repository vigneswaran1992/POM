package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC007_MergeLeads extends ProjectMethods{
	@BeforeClass
	public void setData()
	{
		dataSheetName="TC007_MergeLead";
		testCaseName = "TC007_MergeLead";
		testDescription = "To Test Merge Lead Functionality";
		category= "Positive";
		authors	="Vicky";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteLead(String usrName,String password,String comname,String firstname,String lastname,String errMsg,String MergeLeadID)
	{
		new LoginPage(driver, test)
		.enterUserName(usrName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickMergeLeads()
		.clickFromLookup().switchToSearchWindow()
		.typeFirstLeadID().clickWindowFindLeads().captureLeadID()
		.clickFirstLeadID()
		.switchToDefaultWindow().clickToLeadsLookup()
		.switchToSearchWindow()
		.typeSecondLeadID(MergeLeadID).clickWindowFindLeads()
		.clickFirstLeadID().switchToDefaultWindow()
		.clickMergeButton()
		.acceptMergeAlert()
		.clickFindLeads().enterCapturedMergeID().clickFindLeadsButton().verifyErrorMessage(errMsg);
		
	}
}
