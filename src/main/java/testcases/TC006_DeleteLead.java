package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC006_DeleteLead extends ProjectMethods{
	@BeforeClass
	public void setData()
	{
		dataSheetName="TC006_DeleteLead";
		testCaseName = "TC006_DeleteLead";
		testDescription = "To Test Delete Lead Functionality";
		category= "Positive";
		authors	="$$$";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteLead(String usrName,String password,String comname,String firstname,String lastname,String phNumber,String email,String errMsg)
	{
		new LoginPage(driver, test)
		.enterUserName(usrName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLeads().clickPhoneTab().enterPhoneNumber(phNumber).clickFindLeadsButton().captureLeadID()
		.clickFirstLeadID().clickDelete().clickFindLeads().enterCapturedID().clickFindLeadsButton().verifyErrorMessage(errMsg);
		
	}
}
