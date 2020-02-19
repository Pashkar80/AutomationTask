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

	@FindBy(xpath = "//*[@id='gb']//a[@class='gb_D gb_Oa gb_i']/span")
	WebElement profileName;

	@FindBy(xpath = "//*[@id='gb']//div[@class='gb_ob gb_pb']")//can will be change class name
	WebElement userName;

	@FindBy(xpath = "//*[@id='gb_71']")
	WebElement buttonExit;

	@FindBy(xpath = "//*[@id='view_container']//div[@class='BHzsHc']")
	private  WebElement buttonChangeProfile;

	@FindBy(id = "identifierId")
	private WebElement emailForm;



	@FindBy(id = "passwordNext")
	private WebElement buttonPassword;

	public String check() {
		wait.until(ExpectedConditions.visibilityOf(profileName));
		profileName.click();
		wait.until(ExpectedConditions.visibilityOf(userName));
		String name = userName.getAttribute("innerHTML");
		return name;

	}

	public boolean exit() {

		wait.until(ExpectedConditions.visibilityOf(profileName));
		profileName.click();
		buttonExit.click();
		wait.until(ExpectedConditions.visibilityOf(buttonChangeProfile));
		buttonChangeProfile.click();
		wait.until(ExpectedConditions.visibilityOf(emailForm));
		boolean isEmailForm;
		if (emailForm.isDisplayed()) {
			isEmailForm = true;
		} else
			isEmailForm = false;

		return isEmailForm;
	}

}
