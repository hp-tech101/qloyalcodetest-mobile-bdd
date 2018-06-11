Feature: Login Feature
  As a Fitbit app user
  I would like to be able to login with my secure username and password
  So I can use the fitbit app to my liking

  Background: Navigate to Login Page
    Given that I open the home screen
    And I click on "Log In" option on the HomeScreen
    And I am on the Login Page
    Then I should see the login fields
    And I should see the login button

  @Login @regression
  Scenario: 1 Login with registered user

    When I type valid credentials to LogIn Screen
        | himanshu.tech101@gmail.com  | Eminence17$$18  |
    And I Click on "Log In" button on LoginScreen
    Then I should see the Dashboard icon with text "Dashboard"
    And I should see the account icon on the Dashboard screen
    When I click on account icon on the Dashboard
    And I scroll down to view "Log Out" button
    When I press the "log out" button
    Then I should be redirected to home screen


  @InvalidLogin @regression
  Scenario Outline: 2 Login with unregisterd user
    When I login with invalid <email> and <password> credentials
    Then I should see the error message "Invalid email or password"

    Examples:
        | email                  | password         |
        | himanshu1@gmail.com    | DoesntworkInt1   |
        | himanshu2@gmail.com    | DoesntworkInt2   |

