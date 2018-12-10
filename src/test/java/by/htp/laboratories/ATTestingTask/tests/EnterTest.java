package by.htp.laboratories.ATTestingTask.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.laboratories.ATTestingTask.driver.MyDriver;
import by.htp.laboratories.ATTestingTask.ntety.User;
import by.htp.laboratories.ATTestingTask.pages.MainPage;
import by.htp.laboratories.ATTestingTask.steps.CommonStetps;

public class EnterTest {
	private final String email = "pashkar@bk.ru";
	private final String password = "P5038504";
	private final String name = "pashkar";
	private WebDriver driver;
	
	
	@BeforeTest()
	public void init() {
		driver =MyDriver.initeWebDriver();
		
	}
	
	@Test
	public void authorize() {
	
		CommonStetps steps = new CommonStetps(driver);
		//WebElement form = driver.findByXpath("//*[@id='b_tt_holder_2']/div/span");
		//form.click();
		MainPage main = steps.authorize(email, password);
		main.getAuthorizedName();
		Assert.assertEquals(name, "pashkar");
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
