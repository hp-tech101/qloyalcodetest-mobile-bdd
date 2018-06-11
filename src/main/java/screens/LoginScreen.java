package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen {

    private WebDriver androidDriver = null;
    private int timeOutInSeconds=0;

    //Locators
    private By txt_emailId=By.id("com.fitbit.FitbitMobile:id/login_email");
    private By txt_password=By.id("com.fitbit.FitbitMobile:id/login_password");
    private By btn_login=By.id("com.fitbit.FitbitMobile:id/login_button");
    String lbl_loginPageXpath = "//android.widget.TextView[@resource-id='com.fitbit.FitbitMobile:id/login_footer'][@text='Forgot password?']";
    private By lbl_loginPage=By.xpath(lbl_loginPageXpath);
    private By lbl_errorMsgXpath=By.xpath("//android.widget.TextView[@resource-id='android:id/message'][@text='Invalid email or password']");
    private By btn_okXpath=By.xpath("//android.widget.Button[@resource-id='android:id/button1'][@text='OK']");

    public LoginScreen(WebDriver androidDriver) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=30;
    }

    public LoginScreen(WebDriver androidDriver, int timeOutInSeconds) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=timeOutInSeconds;
    }


    public void enterEmail(String emailUser) {
        try {
            WebElement emailElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(txt_emailId));
            System.out.println("emailElement.isDisplayed() [Explicit Waited] : "+emailElement.isDisplayed());
            emailElement.clear();
            emailElement.sendKeys(emailUser);
        } catch (Exception e) {
            System.out.println("Problem entering username ");
        }

    }
    public void enterPassword(String passwd) {
        try {
            WebElement passwordElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(txt_password));
            System.out.println("emailElement.isDisplayed() [Explicit Waited] : " + passwordElement.isDisplayed());
            passwordElement.clear();
            passwordElement.sendKeys(passwd);
        } catch (Exception e) {
            System.out.println("Problem entering password ");
        }
    }

    void clickLoginBtn() {
        try {
            WebElement loginButton = (new WebDriverWait(androidDriver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_login));
            System.out.println("loginButton.isDisplayed() : " + loginButton.isDisplayed());
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Problem clicking login button");
        }
    }

    public DashboardScreen login(String username, String password) {
         enterEmail(username);
         enterPassword(password);
         clickLoginBtn();
         return new DashboardScreen(androidDriver);
    }

    public DashboardScreen login() {
        clickLoginBtn();
        return new DashboardScreen(androidDriver);
    }

    public boolean isLoginScreenVisible() {
        System.out.println("===============================Inside isLoginScreenVisible");
        boolean loginScreenOpen=false;

        try {
            WebElement lbl_loginPageElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(lbl_loginPage));
            loginScreenOpen=lbl_loginPageElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("==========================Problem locating label on login screen");
        }
        System.out.println("===============================returing  isLoginScreenVisible : "+loginScreenOpen);
        return loginScreenOpen;
    }
    public boolean areLoginFieldsVisible() {
        boolean fieldsVisible=false;

        try {
            WebElement emailElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(txt_emailId));
            //System.out.println("emailElement.isDisplayed() [Explicit Waited] : "+emailElement.isDisplayed());

            WebElement passwordElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(txt_password));
            //System.out.println("emailElement.isDisplayed() [Explicit Waited] : " + passwordElement.isDisplayed());

//            WebElement loginButton = (new WebDriverWait(androidDriver, 15))
//                    .until(ExpectedConditions.presenceOfElementLocated(btn_login));
//            //System.out.println("loginButton.isDisplayed() : " + loginButton.isDisplayed());

            fieldsVisible = emailElement.isDisplayed() && passwordElement.isDisplayed();


        } catch (Exception e) {
            System.out.println("Problem entering username ");
        }

        return fieldsVisible;
    }
    public boolean isLoginButtonVisible() {
        boolean fieldsVisible=false;

        try {


            WebElement loginButton = (new WebDriverWait(androidDriver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_login));
            //System.out.println("loginButton.isDisplayed() : " + loginButton.isDisplayed());

            fieldsVisible = loginButton.isDisplayed();


        } catch (Exception e) {
            System.out.println("Problem entering username ");
        }

        return fieldsVisible;
    }

    public HomeScreen goBack() {
        ((AndroidDriver)androidDriver).pressKeyCode(AndroidKeyCode.BACK);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HomeScreen(androidDriver);
    }

    public String getLoginError() {
        String msg=null;
        try {
            WebElement errorMsgElement = (new WebDriverWait(androidDriver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(lbl_errorMsgXpath));
            msg=errorMsgElement.getText();
            System.out.println("errorMsg.isDisplayed() : " + msg);

            WebElement btnOkElement = (new WebDriverWait(androidDriver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_okXpath));
            System.out.println("btnOkElement.isDisplayed() : " + btnOkElement.isDisplayed());
            btnOkElement.click();


        } catch (Exception e) {
            System.out.println("Problem clicking login button");
        }

        return msg;
    }
}
