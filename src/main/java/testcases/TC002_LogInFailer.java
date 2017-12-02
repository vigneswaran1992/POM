package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC002_LogInFailer extends ProjectMethods{
	@BeforeClass
	public void setData() {
		dataSheetName = "TC002_LogInFailer";
		testCaseName = "TC002_LogInFailer";
		testDescription = "To Test Login Failer";
		category= "Negative";
		authors	="Gopi";
		browserName ="chrome";
	}
	
	@Test(dataProvider="fetchData")
	public void loginFail(String userName, String passWord) {
		
		new LoginPage(driver,test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLoginFailer();
		
		
		
		
		
		
		
	}

}
