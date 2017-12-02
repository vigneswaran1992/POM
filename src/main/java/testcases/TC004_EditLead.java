package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC004_EditLead extends ProjectMethods{
	@BeforeClass
	public void setEditLeadData(){
		
		dataSheetName="TC004_EditLeadData";
		testCaseName = "TC004_EditLead";
		testDescription = "To Test the Edit Lead Functionality";
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
		.clickFindLeads().enterFirstName(firstname).clickFindLeadsButton()
		.clickFirstLeadID()
		.clickEdit()
		.renameCompanyName(comname).clickUpdate().confirmUpdate(comname);
	}
}
