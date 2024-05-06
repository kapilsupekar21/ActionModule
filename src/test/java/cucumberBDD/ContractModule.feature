 
Feature: Admin Login
  Scenario Outline: Logging in as an admin user
    Given the user is on the login page
    When the user enters "<username>" and "<password>" and clicks Sign In
    Then the user should be logged in as an admin

Examples:

| Username                           | password |
| 6298_SPACE_LN_098452@itcubedev.dev |ITCube@098452 |
