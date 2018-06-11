package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardScreen {

    private WebDriver androidDriver = null;
    private int timeOutInSeconds = 0;

    String dashXpath = "//android.widget.TextView[@resource-id='com.fitbit.FitbitMobile:id/tab_title'][@text='Dashboard']";
    private By icon_dashboard = By.xpath(dashXpath);

    String accountXpath = "//android.widget.TextView[@resource-id='com.fitbit.FitbitMobile:id/account']";
    private By icon_account = By.xpath(accountXpath);

    public DashboardScreen(WebDriver androidDriver) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds = 30;
    }

    public DashboardScreen(WebDriver androidDriver, int timeOutInSeconds) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    public boolean isDashboardScreenLoadedOk() {
        boolean result=false;
        try {
            WebElement dashboard = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(icon_dashboard));
            System.out.println("AE5.isDisplayed() : " + dashboard.isDisplayed());
            System.out.println("AE5.getText() : " + dashboard.getText());
            result=dashboard.isDisplayed();
        } catch (Exception e) {
            System.out.println("Trying to locate dashboard again");
            try {
                WebElement dashboard = (new WebDriverWait(androidDriver, timeOutInSeconds))
                        .until(ExpectedConditions.presenceOfElementLocated(icon_dashboard));
                System.out.println("AE5b.isDisplayed() : " + dashboard.isDisplayed());
                System.out.println("AE5b.getText() : " + dashboard.getText());
                result=dashboard.isDisplayed();

            } catch (Exception el) {
                System.out.println("Problem locating dashboard");
            }

        }

        return result;
    }

    public LogoutScreen goToLogoutPage() {
        try {
            WebElement account = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(icon_account));
            System.out.println("account.isDisplayed() : " + account.isDisplayed());
            account.click();
        } catch (Exception e) {
            System.out.println("Problem in Log out");
        }
        return new LogoutScreen(androidDriver);
    }

    public boolean isAccountIconVisible() {
        boolean isAccountIconOk=false;
        try {
            WebElement account = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(icon_account));
            //System.out.println("account.isDisplayed() : " + account.isDisplayed());
            isAccountIconOk = account.isDisplayed();
        } catch (Exception e) {
            System.out.println("Problem checking the account icon");
        }
        return isAccountIconOk;
    }

}
