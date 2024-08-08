Feature: Check Login Functionality & Reflection to Dashboard

Scenario Outline: Check Search hotel functionality
    Given user launch "<browser>" Browser Again
    When  user enter correct email & password
    And   take screenshot
    Then  click on Signin button so user will reflect to dashboard page
    Examples:
      |browser|
      |chrome|
      |Edge|
