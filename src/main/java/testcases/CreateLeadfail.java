package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class CreateLeadfail extends ProjectMethods{
	@BeforeClass
	public void setData()
	{
		dataSheetName="TC003_CreateLeadData";
		testCaseName = "TC003_CreateLead";
		testDescription = "To Test Create Lead Functionality";
		category= "Positive";
		authors	="$$$";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	public void createLead(String usrName,String password,String comname,String firstname,String lastname,String phNumber,String email,String errMsg)
	{
		new LoginPage(driver, test)
		.enterUserName(usrName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickCreateLead()
		.typeCompanyName(comname)
		.typeFirstName(firstname).typeLastName(lastname).typePhoneNumber(phNumber).typeEmailAddress(email)
		.clickSubmit()
		.verifyFirstName(firstname);
	}
}
