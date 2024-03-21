Feature: Login Functionality
  A s a user of movie app application
  I want to login to  page
  Scenario: Successful Login
    Given I enter to the login page
    When I enter valid username and password
    And  I click on the login
    Then  I should enter into  page
