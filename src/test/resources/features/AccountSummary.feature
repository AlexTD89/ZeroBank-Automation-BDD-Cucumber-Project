@AccountSummaryPageTest
Feature: Account Summary page should display the following features


  Scenario: Account Summary page should have the title "Zero-Account summary"
    Given user is logged in
    When user is on Account Summary page
    Then title of the page should be Zero - Account summary


  Scenario: Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts
    Given user is logged in
    When user is on Account Summary page
    Then Cash Accounts should be displayed
    And Investment Accounts should be displayed
    And Credit Accounts should be displayed
    And Loan Accounts should be displayed


  Scenario: Credit Accounts table must have columns Account, Credit Card and Balance
    Given user is logged in
    When user is on Account Summary page
    Then Credit Accounts table must have column "Account", "Credit Card" and "Balance"