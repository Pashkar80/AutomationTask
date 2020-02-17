package by.htp.laboratories.ATTestingTask.pages;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Result extends PageObject{
	
	public Result (WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);  
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		
	}

	@FindBy (className= "span class=sr-hotel__name")
	private List<WebElement> hotels;
	
	
	public int countHotelsonPage() {
		return hotels.size();
		
	}
}
