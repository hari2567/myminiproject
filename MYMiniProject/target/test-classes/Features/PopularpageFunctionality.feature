Feature: Popular Functionality
  A s a user of movie app application
  I want to login to home page
  and then navigate to popular page
  Scenario: Successful Popular
    Given   I click login page
    When I click  username and password
    And  I click the    login buttons
    Then I should enter into popular page