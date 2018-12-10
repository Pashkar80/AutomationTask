package by.htp.laboratories.ATTestingTask.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;

import by.htp.laboratories.ATTestingTask.driver.MyDriver; 

public abstract class PageObject {
	protected WebDriver driver;// not my driver 
public abstract void openPage() throws OperationNotSupportedException;
public PageObject(WebDriver driver) {
	
	this.driver = driver;
}



 
}
