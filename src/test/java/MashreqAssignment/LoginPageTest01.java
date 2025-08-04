package MashreqAssignment;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import MashreqAssignment.pageobjects.LandingPage;
public class LoginPageTest01 extends BaseTest{

	
	@Test(description="Login with Valid Mail Id")
	public void LoginValidMailId() {
		log.info("************* LOGIN FUNCTIONALITY TEST STARTED *************");
		
		LandingPage login=new LandingPage(driver);
		login.handleOptionalContinueButton();
		  login.clickSignInOption();
		  test.log(Status.INFO, "Clicked on Sign In");
		  login.sendMaildId(prop.getProperty("username"));
		  test.log(Status.INFO, "Email entered");
		  login.clickContinue();
		  test.log(Status.PASS, "Clicked Continue");
		  login.sendPassword(prop.getProperty("password"));
		  test.log(Status.INFO, "Test stops here as OTP is required for login.");
		

}
	@Test(description="Login with InValid Mail Id and correct password")
	public void LoginInValidMailId() {
		  	
		LandingPage login=new LandingPage(driver);
		login.handleOptionalContinueButton();
		  login.clickSignInOption();
		  test.log(Status.INFO, "Clicked on Sign In");
		  login.sendMaildId(prop.getProperty("inValidUserName"));
		  test.log(Status.INFO, "Email entered");
		  login.clickContinue();
		  test.log(Status.PASS, "Clicked Continue");
		  login.sendPassword(prop.getProperty("password"));
		  test.log(Status.INFO, "Test stops here as OTP is required for login.");
}
}
