package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.AddCustomerPage;
import page.DashBoardPage;
import page.DynamicNameEntryTable;
import page.LoginPage;
import page.ProfilePage;
import page.TablePage;
import util.BrowserFactory;


public class AddCustomerTest{

	WebDriver driver;

	


	@Test
	@Parameters({"UserName","Password","FullName","CompanyName","Email","Phone","Address","City","Country","State","Zip"})
	public void userShouldBeAbleToAddCustomer(String userName,String password,String fullName,String company,String email,String phone,String address,String city,String state,String zip,String country ) {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.insertPassword(password);
		loginPage.ClickOnSigninButton();

		DashBoardPage dashBoardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashBoardPage.validateDashboardPage();
//		dashBoardPage.clickSideMenu();                                                    //extra
		dashBoardPage.clickCustomerMenuElement();
		dashBoardPage.clickAddCustomerMenuElement();

		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.validateAddContactPage();
		addCustomer.insertFullName(fullName);
		addCustomer.selectCompany(company);
		addCustomer.insertEmail(email);
		addCustomer.insertPhoneNum(phone);
		addCustomer.insertAddress(address);
		addCustomer.insertCity(city);
		addCustomer.insertState(state);
		addCustomer.insertZipCode(zip);
		addCustomer.insertCountry(country);
		addCustomer.insertSave();
		
		ProfilePage profilePage=PageFactory.initElements(driver, ProfilePage.class);
		profilePage.validateProfilePage();
		
		dashBoardPage.clickListCustomerMenuElement();
		
		TablePage tablePage = PageFactory.initElements(driver, TablePage.class);
		tablePage.validateTablePage();
	    
//		by ProjectName Element
		DynamicNameEntryTable entryTable = PageFactory.initElements(driver, DynamicNameEntryTable.class);
		entryTable.vlidateInsertedName();
	
	}

}
