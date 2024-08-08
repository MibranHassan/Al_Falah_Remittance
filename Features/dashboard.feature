Feature: Check Dashboard Functionalities

  Scenario Outline: Check Hamburger Icon
    Given User Launch "<browser>" Browser and login then it should lands on dashboard
    When  user click on Hamburger Icon
    Then  Slider should get Open
    Examples:
      |browser|
      |chrome|
      |edge|