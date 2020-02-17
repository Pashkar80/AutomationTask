package by.htp.laboratories.ATTestingTask.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class MyDriver {
	private static final String CHROME ="webdriver.chrome.driver";
	private static final String CHROME_PATH = "E:\\\\driver\\\\chromedriver.exe";
	
	//private static MyDriver instance = null;
	private static WebDriver driver;
	
	public MyDriver() {
	}
	
	static {
		//instance= new WebDriver();
		initeWebDriver();
	}
	

	
//	public static MyDriver getInstance() {
//		return instance;
//	}

	/**
	 * @param instance the instance to set
	 * @return 
	 */


	public static WebDriver initeWebDriver() {
		System.setProperty(CHROME, CHROME_PATH);
	driver= new ChromeDriver();	
	//driver.manage().window().maximize();
	//пока без временных ограничений
	return driver;
	}
	
	public static void stopWebDriver() {
		driver.close();
		driver=null;
	}
	
	public  void openPage(String url) {
		driver.get(url);
		
	}
	
	public WebElement findByName(String elementName) {
		return driver.findElement(By.name(elementName));
	}

	public WebElement findByXpath(String elementXpath) {
		return driver.findElement(By.xpath(elementXpath));
	}

	public WebElement findcssSelector(String selector) {
		return driver.findElement(By.cssSelector(selector));

	}

	public WebElement findlinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));

	}
	
	public WebElement findByid(String id) {
		return driver.findElement(By.id(id));

	}
	
	public WebElement findByclass (String className) {
		return driver.findElement(By.className(className));

	}
	
	public WebElement findByTag(String name) {
		return driver.findElement(By.tagName(name));
	}

	

	
	
}
