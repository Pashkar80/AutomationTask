package by.testtask.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.testtask.driver.MyDriver;
import by.testtask.entity.Letter;
import by.testtask.entity.User;
import by.testtask.pages.LetterPage;
import by.testtask.pages.MainPage;
import by.testtask.steps.CommonSteps;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.TimeUnit;

public class LetterTest {
	private WebDriver driver;
	Letter letter = new Letter();
	User user = new User();

	@BeforeTest
	public void inite() throws InterruptedException {
		driver = MyDriver.initeWebDriver();
		new CommonSteps(driver).autorizeUser(user.getEmail(), user.getPassword());
	}

	@Test
	public void completeForm()  {
		CommonSteps steps= new CommonSteps(driver);
		String text=steps.completeForm();
		System.out.println("This is get from site->"+ text);
		System.out.println("This is expect  ->" + letter.getContent());
		Assert.assertEquals(text,letter.getContent());

	}

	@AfterTest
	public void stopDriver() {
		driver.close();
	}

}
