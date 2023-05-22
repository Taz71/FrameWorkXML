package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	

	String userName ; 
	String password ;

	@Test
	@Parameters({"UserName","Password"})
	public void validUserShouldBeAbleToLogin(String userName,String password ) {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUserName(userName);
		loginPage.insertPassword(password);
		loginPage.ClickOnSigninButton();
		
		DashBoardPage dashBoard = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoard.validateDashboardPage();
		
		BrowserFactory.tearDown();

	}

}
