@PayBillPageTest @RegressionTest
Feature: Testing the features of the Pay Bill module

  Background:
    Given user is on Pay Bills page

  Scenario: Pay Bills page should have title: Zero - Pay Bills
    Then title of the page should be Zero - Pay Bills

  Scenario: when user completes a successful Pay operation, The payment was successfully submitted should be displayed
    Then user should be able to complete payment form
    Then after successful payment, the message should be displayed

  Scenario: when user submits payment with blank amount field, the message should display: Please fill out this field.
    Then user completes payment form, leaves amount box blank
    Then Please fill out this field.  message should be displayed, with blank box "amount"

  Scenario: when user submits payment with blank date field, the message should display: Please fill out this field.
    Then user completes payment form, leaves date box blank
    Then Please fill out this field.  message should be displayed, with blank box "date"

  Scenario: Amount field should not accept alphabetical characters
    When user types alphabetical characters in Amount field
    Then Amount field should not accept it

  Scenario: Amount field should not accept special characters.
    When user types special characters in Amount field
    Then Amount field should not accept it

  Scenario: Date field should not accept alphabetical characters
    When user types alphabetical characters in date field
    Then date field should not accept it