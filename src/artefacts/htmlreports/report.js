$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/feat01-login.feature");
formatter.feature({
  "name": "Login Feature",
  "description": "  As a Fitbit app user\n  I would like to be able to login with my secure username and password\n  So I can use the fitbit app to my liking",
  "keyword": "Feature"
});
formatter.background({
  "name": "Navigate to Login Page",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that I open the home screen",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs.that_i_open_my_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Log In\" option on the HomeScreen",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_click_on_something_option_on_the_homescreen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Login Page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_am_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the login fields",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_login_fields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "1 Login with registered user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I type valid credentials to LogIn Screen",
  "rows": [
    {
      "cells": [
        "himanshu.tech101@gmail.com",
        "Eminence17$$18"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs.i_type_valid_and(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Click on \"Log In\" button on LoginScreen",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_click_on_something_button_on_loginscreen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the Dashboard icon with text \"Dashboard\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_dashboard_icon_with_text_something(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the account icon on the Dashboard screen",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_account_icon_on_the_dashboard_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on account icon on the Dashboard",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs.i_click_on_account_icon_on_the_dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I scroll down to view \"Log Out\" button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_scroll_down_to_view_something_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I press the \"log out\" button",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs.i_press_the_something_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be redirected to home screen",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_be_redirected_to_home_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "2 Login with unregisterd user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@InvalidLogin"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I login with invalid \u003cemail\u003e and \u003cpassword\u003e credentials",
  "keyword": "When "
});
formatter.step({
  "name": "I should see the error message \"Invalid email or password\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "himanshu1@gmail.com",
        "DoesntworkInt1"
      ]
    },
    {
      "cells": [
        "himanshu2@gmail.com",
        "DoesntworkInt2"
      ]
    }
  ]
});
formatter.background({
  "name": "Navigate to Login Page",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that I open the home screen",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs.that_i_open_my_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Log In\" option on the HomeScreen",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_click_on_something_option_on_the_homescreen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Login Page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_am_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the login fields",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_login_fields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "2 Login with unregisterd user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@InvalidLogin"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I login with invalid himanshu1@gmail.com and DoesntworkInt1 credentials",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs.i_login_with_invalid_and_credentials(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the error message \"Invalid email or password\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_error_message_something(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Navigate to Login Page",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that I open the home screen",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefs.that_i_open_my_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on \"Log In\" option on the HomeScreen",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_click_on_something_option_on_the_homescreen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Login Page",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_am_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the login fields",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_login_fields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "2 Login with unregisterd user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@InvalidLogin"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I login with invalid himanshu2@gmail.com and DoesntworkInt2 credentials",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefs.i_login_with_invalid_and_credentials(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the error message \"Invalid email or password\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs.i_should_see_the_error_message_something(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});