Feature: Login Feature

  @smoke @login
  Scenario: Valid login
    Given user launches the application
    When user logs in with valid credentials
    Then user should be logged in successfully
