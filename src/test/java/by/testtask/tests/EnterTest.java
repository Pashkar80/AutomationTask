package by.testtask.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	@FindBy(xpath = "/html/body/div[2]/div[3]/form/input[2]")
	private WebElement buttonHTMLversion;

	@BeforeTest
	public void inite() {
		driver = MyDriver.initeWebDriver();
	}

	@Test
	public void autorizeAndCheckProfile() throws InterruptedException {
		CommonSteps steps = new CommonSteps(driver);
		MainPage main = steps.autorizeUser(user.getEmail(), user.getPassword());
		String name = steps.checkProfile();
		//buttonHTMLversion.click();
		Assert.assertEquals(name, user.getLogin());

	}

	@AfterTest
	public void stopDriver() {
		driver.close();
	}
}
