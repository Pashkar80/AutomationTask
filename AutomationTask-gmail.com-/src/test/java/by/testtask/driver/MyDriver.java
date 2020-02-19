package by.testtask.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "E:\\\\driver\\\\chromedriver.exe";

	private static WebDriver driver;

	public MyDriver() {

	}

	static {
		initeWebDriver();
	}

	public static WebDriver initeWebDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		if(driver==null) {
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		}
		return driver;
	}

	public static void stopWebDriver() {
		driver.close();
		driver = null;
	}


}
