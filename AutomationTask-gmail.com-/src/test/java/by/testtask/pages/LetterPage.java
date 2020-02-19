package by.testtask.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.testtask.entity.Letter;
import by.testtask.entity.User;

public class LetterPage extends PageObject {
	User user = new User();
	Letter letter = new Letter();

	public LetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Override
	public void openPage() {

	}

	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement buttonWrite;

	@FindBy(name = "to")
	WebElement whomForm;

	@FindBy(name = "subjectbox")
	WebElement subjectForm;

	 @FindBy(xpath = "//div[@aria-label='Message Body']")
	WebElement letterField;

	@FindBy(xpath = "//div[contains(@aria-label, 'Send')]")
	WebElement buttonSend;

	public void completeForm() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonWrite));
		buttonWrite.click();

		wait.until(ExpectedConditions.elementToBeClickable(whomForm));
		whomForm.click();
		whomForm.sendKeys(user.getEmail());
		whomForm.sendKeys(Keys.TAB);

		subjectForm.click();
		subjectForm.sendKeys(letter.getMessagesubject());
		
		
		letterField.click();
		letterField.sendKeys(letter.getContent());

		buttonSend.click();

	}

}