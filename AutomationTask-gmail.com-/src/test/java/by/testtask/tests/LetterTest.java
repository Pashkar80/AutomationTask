package by.testtask.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.testtask.driver.MyDriver;
import by.testtask.entity.Letter;
import by.testtask.entity.User;
import by.testtask.pages.LetterPage;
import by.testtask.pages.MainPage;
import by.testtask.steps.CommonSteps;

public class LetterTest {
	private WebDriver driver;
	Letter letter = new Letter();
	User user = new User();

	@BeforeTest
	public void inite() {
		driver = MyDriver.initeWebDriver();
		CommonSteps steps = new CommonSteps(driver);
		MainPage main = steps.autorize(user.getEmail(), user.getPassword());
	}

	@Test
	public void copleteForm() {
		CommonSteps steps = new CommonSteps(driver);
		LetterPage letter = steps.completeForm();

	}

	@AfterTest
	public void stopDriver() {
		driver.close();
	}

}
