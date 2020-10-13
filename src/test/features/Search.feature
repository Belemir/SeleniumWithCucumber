Feature: Search product
  Scenario: Search product on home page successfully
    Given I navigate to the home page
    When I enter keyword "laptop" to search bar
    And I click on search button
    Then I should see search results for "laptop" keyword successfully
