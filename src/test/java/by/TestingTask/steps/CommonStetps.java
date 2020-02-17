package by.htp.laboratories.ATTestingTask.steps;

import org.openqa.selenium.WebDriver;

import by.htp.laboratories.ATTestingTask.driver.MyDriver;
import by.htp.laboratories.ATTestingTask.pages.MainPage;
import by.htp.laboratories.ATTestingTask.pages.Result;
import by.htp.laboratories.ATTestingTask.util.DateUtil;

public class CommonStetps {
	
	private WebDriver driver;

	public CommonStetps(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public MainPage authorize(String email, String password) {
		MainPage main = new MainPage(driver);
		main.openPage();
		main.logging(email, password);
		return main;
	}
	
	public int  testingCountHotels (String place, int guests) {
		Result result= new Result(driver);
		MainPage main = new MainPage(driver);
		main.openPage();
		main.setWay(place);
		main.setDayIn(DateUtil.getNextSaturday());
		main.setDayOut(DateUtil.getNextSunday());
		main.selectCountofAdultGuests(guests);
		int counthotels=result.countHotelsonPage();
		
		return counthotels;
	}

}
