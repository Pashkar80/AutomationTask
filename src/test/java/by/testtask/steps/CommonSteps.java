package by.testtask.steps;


import org.openqa.selenium.WebDriver;


import by.testtask.pages.LetterPage;
import by.testtask.pages.MainPage;
import by.testtask.pages.UserPage;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps(WebDriver driver) {

        this.driver = driver;
    }

    public MainPage autorizeUser(String email, String password) {
        MainPage main = new MainPage(driver);
        main.openPage();
        main.logging(email, password);
        return main;
    }

    public String checkProfile() {
        UserPage page = new UserPage(driver);
        String name = page.check();
        return name;

    }

    public boolean checkExitProfile() {
        UserPage page = new UserPage(driver);
        boolean isEmailForm = false;
        isEmailForm = page.exit();
        return isEmailForm;
    }

    public String completeForm()  {
      String text=  new LetterPage(driver).completeForm();

        return text;

    }

}
