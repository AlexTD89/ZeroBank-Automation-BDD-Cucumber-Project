@AccountActivityPageTest
Feature: Account Activity page should display the following features

  Background:
    Given user is logged in
    Then user navigates to Account Activity page

  Scenario: Account Activity page should have the title "Zero – Account activity"
    Then title of the page should be Zero – Account activity

  Scenario: In the Account drop down default option should be Savings
    Then In the Account drop down default option should be Savings

  Scenario: Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage
    Then drop down menu should have the following options: Savings, Checking, Loan, Credit Card, Brokerage

  Scenario: Transactions table should have column names Date, Description, Deposit, Withdrawal
    Then following columns should be displayed: Date, Description, Deposit, Withdrawal