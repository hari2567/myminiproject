Feature: Account Functionality
  A s a user of movie app application
  I want to login to home page
  and then navigate to account page
  Scenario: Successful Account
    Given   I click on login page
    When I click on username and password
    And  I click on    login butto
    Then I should enter into the account page