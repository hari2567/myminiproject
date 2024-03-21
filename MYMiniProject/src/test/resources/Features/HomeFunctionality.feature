Feature: Home Functionality
  A s a user of movie app application
  I want to login to home page
  and then redirected to login page
  Scenario: Successful Home
    Given I am on the login page
    When I enter username and password
    And  I click on the login button
    Then  I should enter into home page
    And I check homepage is displayed
