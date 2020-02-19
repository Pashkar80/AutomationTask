package by.testtask.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserPage extends PageObject {

	public UserPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 20);

	@Override
	public void openPage() throws OperationNotSupportedException {

	}

	@FindBy(xpath = "//*[@id=\'gb\']/div[2]/div[3]/div/div[2]/div/a/span")
	WebElement profileName;

	@FindBy(xpath = "//*[@id=\'gb\']/div[2]/div[5]/div[1]/div/div[1]")
	WebElement userName;

	@FindBy(xpath = "//*[@id=\'gb_71\']")
	WebElement buttonExit;

	@FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	private WebElement passwordForm;

	@FindBy(id = "passwordNext")
	private WebElement buttonPassword;

	public String check() {
		wait.until(ExpectedConditions.visibilityOf(profileName));
		profileName.click();
		String name = userName.getText();
		return name;

	}

	public boolean exit() {

		wait.until(ExpectedConditions.visibilityOf(profileName));
		profileName.click();
		buttonExit.click();
		boolean isPasswordForm;
		if (passwordForm.isDisplayed()) {
			isPasswordForm = true;
		} else
			isPasswordForm = false;

		return isPasswordForm;
	}

}
