package by.testtask.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.testtask.entity.Letter;
import by.testtask.entity.User;

import java.util.concurrent.TimeUnit;

public class LetterPage extends PageObject {
    User user = new User();
    Letter letter = new Letter();

    public LetterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, 30);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Override
    public void openPage() {
        driver.get("https://mail.google.com/mail/u/0/#inbox");

    }

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonWrite;

    @FindBy(name = "to")
    WebElement whomForm;

    @FindBy(name = "subjectbox")
    WebElement subjectForm;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    WebElement letterField;

    @FindBy(xpath = "//*[@class='aDh']//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    WebElement buttonSend;

    @FindBy(xpath = "*//a[@class='J-Ke n0']")
    private WebElement ligthting;


    @FindBy(xpath = "//span[@class='bog']//span[text()='Test Letter']")
    private WebElement email;

    @FindBy(xpath = "//div[text()='Hello! This is TestLetter!']")
    private  WebElement emailContetnt;


    public String completeForm()  {
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
        js.executeScript("arguments[0].click()", buttonSend);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        email.click();
        String text = emailContetnt.getAttribute("innerHTML");
        return text;


    }

}