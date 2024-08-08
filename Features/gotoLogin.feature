Feature: Check Reflection to Login Page

Scenario Outline: Check Cross Browser Functionality
    Given User Launch "<browser>" Browser
    When  user wait to load page
    Then  user click on login button so it should reflect to Login page
    Examples:
      |browser|
      |chrome|
      |edge|