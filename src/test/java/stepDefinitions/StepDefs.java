package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import screens.DashboardScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.LogoutScreen;
import static testbase.common.Settings.driver;
import static testbase.common.Settings.logger;

import java.util.List;

public class StepDefs {

    //Background - steps
    @Given("^that I open the home screen$")
    public void that_i_open_my_app() throws Throwable {
        boolean appOpenOk=false;
        String msg=null;
        if(driver!=null) {
            //hack: check if on login screen already
            LoginScreen loginScreen = new LoginScreen(driver);
            if(loginScreen.areLoginFieldsVisible()) {
                logger.info("===================== Login Screen is already open ... continue");
           //     HomeScreen hs=loginScreen.goBack();
                appOpenOk=true;
                msg="Login page was already up ? ";
            } else {
                logger.info("===================== Login Screen was not open ... business as usual");
                HomeScreen homeScreen = new HomeScreen(driver);
                appOpenOk = homeScreen.isPageLoaded();
                //System.out.println("[$$$$$$$$$] Page Loaded Home Screen : "+appOpenOk);
                msg="HomeScreen opened successfully";
                logger.info(msg+"? => " + appOpenOk);
            }

        } else {
            logger.error("Settings.driver is not initialized");
        }
        Assert.assertTrue(msg,appOpenOk);
    }

    @And("^I click on \"([^\"]*)\" option on the HomeScreen$")
    public void i_click_on_something_option_on_the_homescreen(String btnLabel) throws Throwable {
        logger.info("Performing Click on Button : "+btnLabel);
        HomeScreen homeScreen = new HomeScreen(driver);
        LoginScreen loginScreen= homeScreen.goToLoginPage();
        boolean actionOk=false;

        if(loginScreen!=null)
            actionOk=true;
        logger.info("HomeScreen 'Log In' button clicked successfully ? => "+actionOk);
        Assert.assertTrue("HomeScreen 'Log In' button clicked successfully",actionOk);
    }

    @And("^I am on the Login Page$")
    public void i_am_on_the_login_page() throws Throwable {
        LoginScreen loginScreen=new LoginScreen(driver);
        boolean openLoginScreen=loginScreen.isLoginScreenVisible();
        logger.info("Login Page is Open ? => "+openLoginScreen);
        Assert.assertTrue("Login Page is open",openLoginScreen);
    }

    @Then("^I should see the login fields$")
    public void i_should_see_the_login_fields()  {
     //   System.out.println("isLoginPageLoaded : pata nahi abhi, thode steps mein pata chal jayega");
        LoginScreen loginScreen=new LoginScreen(driver);
        boolean onLoginPage= loginScreen.areLoginFieldsVisible();
        logger.info("Login Fields are visible ? => "+onLoginPage);
        Assert.assertTrue("Login Fields are visible", onLoginPage);
    }

    @And("^I should see the login button$")
    public void i_should_see_the_login_button() throws Throwable {

        LoginScreen loginScreen=new LoginScreen(driver);
        boolean onLoginPage= loginScreen.isLoginButtonVisible();
        logger.info("Login Button is visible ? => "+onLoginPage);
        Assert.assertTrue("Login Button is visible", onLoginPage);
    }


    //Scenario 1 - steps
    @When("^I type valid credentials to LogIn Screen$")
    public void i_type_valid_and(DataTable usercredentials) throws Throwable {
        List<List<String>> data = usercredentials.raw();
        String email=data.get(0).get(0);
        String password=data.get(0).get(1);
        logger.info("Typing email = "+email+" and password = "+password);
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.enterEmail(email);
        loginScreen.enterPassword(password);
    }

    @And("^I Click on \"([^\"]*)\" button on LoginScreen$")
    public void i_click_on_something_button_on_loginscreen(String btnLabel) {
        LoginScreen loginScreen = new LoginScreen(driver);
        DashboardScreen dashboardScreen=loginScreen.login();
        boolean clickOperationOk=false;
        if(dashboardScreen!=null)
            clickOperationOk=true;
        logger.info("Login operation is successful ? => "+clickOperationOk);
        Assert.assertTrue("Login operation is successful", clickOperationOk);
    }

    @Then("^I should see the Dashboard icon with text \"([^\"]*)\"$")
    public void i_should_see_the_dashboard_icon_with_text_something(String iconlabel){
        DashboardScreen dashboardScreen=new DashboardScreen(driver);
        boolean isDashOk=dashboardScreen.isDashboardScreenLoadedOk();
        logger.info("Dashboard screen loaded successfully ? => "+isDashOk);
        Assert.assertTrue("Dashboard screen loaded successfully",isDashOk);
    }

    @And("^I should see the account icon on the Dashboard screen$")
    public void i_should_see_the_account_icon_on_the_dashboard_screen() {
        DashboardScreen dashboardScreen=new DashboardScreen(driver);
        boolean accountIconOk=dashboardScreen.isAccountIconVisible();
        logger.info("Account icon is displayed correctly ? => "+accountIconOk);
        Assert.assertTrue("Account icon is displayed correctly ",accountIconOk);
    }


    @When("^I click on account icon on the Dashboard$")
    public void i_click_on_account_icon_on_the_dashboard() {
        DashboardScreen dashboardScreen=new DashboardScreen(driver);
        LogoutScreen logoutScreen=dashboardScreen.goToLogoutPage();
        boolean goToAccountOk=false;
        if(logoutScreen!=null)
             goToAccountOk=true;
        logger.info("Account icon on Dashboard Clicked without issues ? => "+goToAccountOk);
        Assert.assertTrue("Account icon on Dashboard Clicked without issues",goToAccountOk);
    }

    @And("^I scroll down to view \"([^\"]*)\" button$")
    public void i_scroll_down_to_view_something_button(String btnLabel) {
        logger.info("Scroll down to '"+btnLabel+"' button");
        LogoutScreen logoutScreen = new LogoutScreen(driver);
        logoutScreen.scrollDownToViewLogoutButton();
    }

    @When("^I press the \"([^\"]*)\" button$")
    public void i_press_the_something_button(String btnLabel) {
        LogoutScreen logoutScreen = new LogoutScreen(driver);
        HomeScreen homeScreen=logoutScreen.logOutAndConfirm();
        boolean logOutOk=false;
        if(homeScreen!=null)
            logOutOk=true;
        logger.info("Logout operation is successful ? => "+logOutOk);
        Assert.assertTrue("Logout operation is successful",logOutOk);
    }

    @Then("^I should be redirected to home screen$")
    public void i_should_be_redirected_to_home_screen()  {
        HomeScreen homeScreen=new HomeScreen(driver);
        boolean isPageOk=homeScreen.isPageLoaded();
        logger.info("Logout redirected to Home Screen successfully ? => "+isPageOk);
        Assert.assertTrue("Logout redirected to Home Screen successfully",isPageOk);
    }



    @When("^I login with invalid (.+) and (.+) credentials$")
    public void i_login_with_invalid_and_credentials(String email, String password){
        logger.info("Running invalid credentials : username = "+email+" | password = "+password);
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.login(email,password);
    }

    @Then("^I should see the error message \"([^\"]*)\"$")
    public void i_should_see_the_error_message_something(String errMsg) {
        LoginScreen loginScreen = new LoginScreen(driver);
        String actualErrMsg=loginScreen.getLoginError();
        Assert.assertTrue("Authentication for unregistered user failed as expected",actualErrMsg.contentEquals(errMsg));
    }

}
