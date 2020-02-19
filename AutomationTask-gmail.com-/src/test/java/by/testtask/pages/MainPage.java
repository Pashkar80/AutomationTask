package by.testtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage extends PageObject {
	private static final String BASE_URL = "https://www.gmail.com";
	

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	WebDriverWait wait=new WebDriverWait(driver,10);

	@Override
	public void openPage() {
		driver.get(BASE_URL);

	}
	
	@FindBy(id = "identifierId")
	private WebElement emailForm;

	@FindBy(id = "identifierNext")
	private WebElement buttonEmail;

	@FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	private WebElement passwordForm;

	@FindBy(id = "passwordNext")
	private WebElement buttonPassword;

	public void logging(String email, String password){
		emailForm.sendKeys(email);
		buttonEmail.click();
		wait.until(ExpectedConditions.visibilityOf(buttonPassword));
		passwordForm.sendKeys(password);
		buttonPassword.click();

	}
	
	
	

}
