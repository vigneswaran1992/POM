package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC001_LogInLogOut extends ProjectMethods{
	@BeforeClass
	public void setData() {
		dataSheetName = "TC001_Login";
		testCaseName = "TC001_LogInLogOut";
		testDescription = "To Test Login and LogOut";
		category= "Smoke";
		authors	="Nesa";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	public void logInLogOut(String userName, String passWord) {
		
		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.clickLogout();
		
		
		
		
		
		
		
	}

}
