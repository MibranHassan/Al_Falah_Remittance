Feature: Check Initiate LC in Trade Finance-Import

  Scenario Outline: Check Initiate LC functionality
    Given user launch "<browser>" Browser for Initiate LC
    And   perform login
    And   click on hamburger
    When  user click on trade finance
    And   click on Letter of credit
    And   click on Import LC
    And   click on Initiate LC
    And   click on create LC button
    And   Fill LC Details
    And   Fill Goods and Shipment Details
    And   Fill Documents and Conditions
    And   Fill Instructions
    And   Upload attachment and click on submit
    And   take screenshot of Review Screen for Initiate LC
    Then  complete all the details and click on submit button
    Examples:
      |browser|
      |chrome|
#      |Edge|