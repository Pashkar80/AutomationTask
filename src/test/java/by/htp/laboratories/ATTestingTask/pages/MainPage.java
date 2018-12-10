package by.htp.laboratories.ATTestingTask.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import by.htp.laboratories.ATTestingTask.driver.MyDriver;

public class MainPage extends PageObject {

	private static final String BASE_URL = "https://www.booking.com/ ";
	private static final String WAY = "Вильнюс";
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);//   
	}
	@Override
	public void openPage()  {
		driver.get(BASE_URL);  
	}
	
	////@FindBy(xpath="//*[@id=\'frm\']/div[1]/div[4]/div[2]/button/span[1]")
	@FindBy(xpath="//*[@id='b_tt_holder_2']")
     private WebElement searchForm;
	
//	public void searchForm(){
//		WebElement form = driver.findByXpath("//*[@id='b_tt_holder_2']/div/span");
//		form.click();
//	}
	
	@FindBy(name="username")
	private WebElement emailform;
	
	@FindBy(name = "password")
	WebElement passwordform;
	
	@FindBy (xpath="//*[@id=\'b2indexPage\']/div[23]/div[1]/div/div[2]/form[1]/input[10]")
	WebElement button;
	
	@FindBy(xpath = "//*[@id=\'current_account\']/a/span[2]/span[1]")
	WebElement profileName;
	
	@FindBy(id="ss")
	private WebElement wayFild;
	
	@ FindBy(id ="xp__guests__toggle")
	private WebElement guestsCount;
	
	@FindBy (id="group_adults")
	private WebElement guestsCountField;
	
	@FindBy(xpath= "//div[@data-mode='checkin']//button")
	private WebElement checkInbutton;
	
	
	@FindBy(xpath= "//div[@data-mode='checkout']//button")
	private WebElement checkOutbutton;
	
	@FindBy (className="sb-searchbox__button")
	WebElement priceButton;
	
	public void logging(String email, String password) {
		searchForm.click();
		//emailform.sendKeys(email);
	//	passwordform.sendKeys(password);
	//	button.submit();
	}
	public String getAuthorizedName(){
		
		String name =  profileName.getText();
		return name;
		}
	
	public void setWay(String way) {
		wayFild.sendKeys(way);
		wayFild.click();
	}
	
public void selectCountofAdultGuests(int adults) {
	guestsCount.click();
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Select dropdownAdults=new Select(guestsCountField);
	dropdownAdults.selectByVisibleText(String.valueOf(adults));
}

public void setDayIn(String date) {
	checkInbutton.click();
	checkInbutton.sendKeys(Keys.TAB);
	driver.switchTo().activeElement().sendKeys(date.replaceAll("\\D", ""));
}



public void setDayOut(String date) {
	checkOutbutton.click();
	checkOutbutton.sendKeys(Keys.TAB);
	driver.switchTo().activeElement().sendKeys(date.replaceAll("\\D", ""));
}

public void preesPriceButton() {
	priceButton.click();
}

}
