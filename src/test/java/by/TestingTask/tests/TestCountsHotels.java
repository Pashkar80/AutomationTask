package by.htp.laboratories.ATTestingTask.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.laboratories.ATTestingTask.driver.MyDriver;
import by.htp.laboratories.ATTestingTask.steps.CommonStetps;

public class TestCountsHotels {
	private WebDriver driver;
	private final String CITY="Вильнюс";
	private final int COUNT_ADULTS=2;
	private final int MIN_HOTELS=3;
	
	@BeforeTest()
	public void init() {
		driver =MyDriver.initeWebDriver();
		
	}
	
	
	@Test
	public void checkCountsHotels() {
		CommonStetps steps= new CommonStetps(driver);
		int counts=steps.testingCountHotels(CITY, COUNT_ADULTS);
		Assert.assertTrue(counts>=MIN_HOTELS);
	}
	
	
	
	
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
