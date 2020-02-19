package by.testtask.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.testtask.driver.MyDriver;
import by.testtask.entity.User;
import by.testtask.pages.MainPage;

import by.testtask.steps.CommonSteps;

public class ExitTest {
	User user = new User();
	private WebDriver driver;
	

	@BeforeTest
	public void initeAndLogging() throws InterruptedException {
		driver = MyDriver.initeWebDriver();
		CommonSteps steps = new CommonSteps(driver);
		MainPage main = steps.autorizeUser(user.getEmail(), user.getPassword());
	}
		
	
	@Test
	public void exitAndCheckPasswordForm()  {
		CommonSteps steps = new CommonSteps(driver);
		boolean isPasswordForm = steps.checkExitProfile();
		Assert.assertEquals(isPasswordForm, true);
		
	}
	
	@AfterTest
	public void stopDriver() {
		driver.close();
	}

}
