Feature: Login Feature

  @sanity @validlogin
  Scenario: Valid login
    Given user launches the application
    When user logs in with valid credentials
    Then user should be logged in successfully

  @sanity @Invalidlogin
  Scenario: InValid login
    Given user launches the application
    When user logs in with invalid credentials
    Then user should be logged in successfully
