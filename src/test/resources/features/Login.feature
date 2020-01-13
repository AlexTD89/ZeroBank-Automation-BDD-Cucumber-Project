@LoginTest @SmokeTest @RegressionTest
Feature: User should be able to login

  Background:
    Given user is on login page

  Scenario: Authorized user able to login
    Then user enters credentials
    Then authorized user should be able to login
    Then account summary page should be displayed


  Scenario: User with wrong username can't login
    Then user enters credentials with WRONG USERNAME
    Then user should not able to login
    Then login error message should be displayed


  Scenario: User with wrong password should not able login
    Then user enters credentials with WRONG PASSWORD
    Then user should not able to login
    Then login error message should be displayed


  Scenario: User with BLANK USERNAME should not able to login
    When user enters credentials with BLANK USERNAME
    Then user should not able to login
    Then login error message should be displayed


  Scenario: User with BLANK PASSWORD should not able to login
    When user enters credentials with BLANK PASSWORD
    Then user should not able to login
    Then login error message should be displayed

