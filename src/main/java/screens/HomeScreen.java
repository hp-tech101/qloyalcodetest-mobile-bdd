package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen {

    private WebDriver androidDriver = null;
    private int timeOutInSeconds=0;

    //Locators
    private By btn_logIn = By.id("com.fitbit.FitbitMobile:id/btn_log_in");

    public HomeScreen(WebDriver androidDriver) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=30;
    }

    public HomeScreen(WebDriver androidDriver, int timeOutInSeconds) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=timeOutInSeconds;
    }


    public LoginScreen goToLoginPage() {
        try {
            WebElement loginBtn = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_logIn));
            System.out.println("AE1.isDisplayed() : "+loginBtn.isDisplayed());
            loginBtn.click();
        } catch (Exception e) {
            System.out.println("Problem Clicking login btn on HomeScreen");
        }

        return new LoginScreen(androidDriver);
    }

    public boolean isPageLoaded() {
        boolean result=false;
        try {
            WebElement loginBtn = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_logIn));
            System.out.println("AE1.isDisplayed() : "+loginBtn.isDisplayed());
            result=loginBtn.isDisplayed();
        } catch (Exception e) {
            System.out.println("Problem Checking login btn on HomeScreen");
        }
        return result;
    }
}
