package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC005_DuplicateLead extends ProjectMethods{
	@BeforeClass
	public void setEditLeadData(){
		
		dataSheetName="TC005_DuplicateLeadData";
		testCaseName = "TC005_DuplicateLead";
		testDescription = "To Test the Duplicate Lead Functionality";
		category= "Positive";
		authors	="Vicky";
		browserName ="chrome";
	}
	@Test(dataProvider="fetchData")
	public void editLead(String usrName,String password,String comname,String firstname,String lastname,String phNumber,String email,String errMsg){
		new LoginPage(driver, test)
		.enterUserName(usrName).enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLeads().clickEmailTab().enterEmailAddress(email).clickFindLeadsButton().captureLeadName()
		.clickFirstLeadID()
		.clickDuplicate().clickDuplicateLead_CreateLead().verifyDuplicateFirstName();
	}
}
