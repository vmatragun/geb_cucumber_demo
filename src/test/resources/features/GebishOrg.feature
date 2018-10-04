@Test
Feature: gebish org main page test demo

  Scenario: can get to the current Book of Geb
    When I go to the gebish org home page
    And I click on the manual menu option
    Then the current manual link is visible
    When I click on the current manual link
    Then eventually I am at the the book of geb page
