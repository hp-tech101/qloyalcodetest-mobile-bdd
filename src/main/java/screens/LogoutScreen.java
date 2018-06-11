package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutScreen {
    private WebDriver androidDriver = null;
    private int timeOutInSeconds=0;

    private String uiSelector="new UiScrollable(new UiSelector()).scrollIntoView(textStartsWith(\"Log Out\"));";
    private By dialog_yesLogout=By.xpath("//*[@class='android.widget.Button'][@text='YES']");
    private By btn_logOut=By.xpath("//android.widget.Button[@resource-id='com.fitbit.FitbitMobile:id/btn_logout'][@text='Log Out']");

    public LogoutScreen(WebDriver androidDriver) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=30;
    }

    public LogoutScreen(WebDriver androidDriver, int timeOutInSeconds) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=timeOutInSeconds;
    }

    public void scrollDownAndClickLogout() {
        try {
            WebElement logout = (new WebDriverWait(androidDriver, timeOutInSeconds)).until(
                    ExpectedConditions.elementToBeClickable(
                            ((AndroidDriver) androidDriver).findElementByAndroidUIAutomator(uiSelector)
                    ));

            System.out.println("AE7.isDisplayed() : " + logout.isDisplayed());
            System.out.println("AE7.getText() : " + logout.getText());
            logout.click();
        } catch (Exception e) {
            System.out.println("Problem scrolling down to Log Out button");
        }
    }

    public void scrollDownToViewLogoutButton() {
        try {
            WebElement logout = (new WebDriverWait(androidDriver, timeOutInSeconds)).until(
                    ExpectedConditions.elementToBeClickable(
                            ((AndroidDriver) androidDriver).findElementByAndroidUIAutomator(uiSelector)
                    ));

            System.out.println("AE7.isDisplayed() : " + logout.isDisplayed());
            System.out.println("AE7.getText() : " + logout.getText());
            //logout.click();
        } catch (Exception e) {
            System.out.println("Problem scrolling down to Log Out button");
        }
    }

    public void confirmLogout() {
        try {
            // WebElement AE8=androidDriver.findElement(By.xpath("//*[@class='android.widget.Button'][@text='YES']"));
            WebElement yesLogout = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(dialog_yesLogout));
            String text = yesLogout.getAttribute("text");
            // String id=temp.getAttribute("resouce-id");
            String id = "none";
            System.out.println(text + " | " + id);
            yesLogout.click();
        } catch (Exception e) {
            System.out.println("Problem clicking YES in confirm logout dialog");
        }

    }

    public HomeScreen logout() {
        scrollDownAndClickLogout();
        confirmLogout();
        return new HomeScreen(androidDriver);
    }

    public HomeScreen logOutAndConfirm() {
        HomeScreen homeScreen = null;
        try {
            WebElement logoutElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_logOut));
            System.out.println("logoutElement.isDisplayed() [Explicit Waited] : " + logoutElement.isDisplayed());
            logoutElement.click();
            confirmLogout();
            homeScreen=new HomeScreen(androidDriver);
        } catch (Exception e) {
            System.out.println("Problem entering password ");
        }
        return homeScreen;
    }

    /*public boolean isLogoutOk() {


    }
*/




}
