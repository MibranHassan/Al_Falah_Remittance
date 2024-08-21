Feature: Check Initiate LC in Trade Finance-Import

  Scenario Outline: Check Initiate LC functionality
    Given user launch "<browser>" Browser for Initiate LC
    And   perform login
    And   click on Searchbar
    And   Fill Remittance Details
    Examples:
      |browser|
      |chrome|
#      |Edge|