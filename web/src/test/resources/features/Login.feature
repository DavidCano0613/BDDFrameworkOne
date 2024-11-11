Feature: Valid login

  Scenario: Perform Valid login
    Given User has navigated to Login page
    When User enters username as "david0613pc@gmail.com" and password as "Vainilla&Almendra2*"
    And User clicks on Login button
    Then Verify user is able to successfully login