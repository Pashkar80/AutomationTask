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

public class EnterTest {

	User user = new User();
	private WebDriver driver;

	@BeforeTest
	public void inite() {
		driver = MyDriver.initeWebDriver();
	}

	@Test
	public void autorizeAndCheckProfile() {
		CommonSteps steps = new CommonSteps(driver);
		MainPage main = steps.autorize(user.getEmail(), user.getPassword());
		String name = steps.checkProfile();
		Assert.assertEquals(name, user.getLogin());

	}

	@AfterTest
	public void stopDriver() {
		driver.close();
	}
}
