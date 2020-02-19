package by.testtask.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	protected WebDriver driver;

	public abstract void openPage() throws OperationNotSupportedException;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	}

}
